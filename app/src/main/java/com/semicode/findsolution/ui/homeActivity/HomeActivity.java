package com.semicode.findsolution.ui.homeActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;


import com.google.firebase.auth.FirebaseAuth;
import com.semicode.findsolution.R;
import com.semicode.findsolution.adapter.DrawerMenuAdapter;
import com.semicode.findsolution.databinding.ActivityHomeBinding;
import com.semicode.findsolution.model.MenuMoudel;
import com.semicode.findsolution.mvp.activtyHome.ActivityHomePresenter;
import com.semicode.findsolution.mvp.activtyHome.ActivityHomeView;
import com.semicode.findsolution.share.HelperMethod;
import com.semicode.findsolution.ui.LoginActivity;


import java.util.ArrayList;

import nl.psdcompany.duonavigationdrawer.views.DuoMenuView;
import nl.psdcompany.duonavigationdrawer.widgets.DuoDrawerToggle;


public class HomeActivity extends AppCompatActivity implements ActivityHomeView {
    private ActivityHomeBinding binding;
    private FirebaseAuth mAuth;
    DuoDrawerToggle drawerToggle;
    private ArrayList<MenuMoudel> mOptions;
    private String[] tittle;
    private int[] images;
    FragmentManager fragmentManager;
    ActivityHomePresenter presenter;
    DrawerMenuAdapter menuAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        initView();
    }

    @SuppressLint({"ResourceAsColor", "UseCompatLoadingForDrawables"})
    private void initView() {
        mAuth = FirebaseAuth.getInstance();
        fragmentManager = getSupportFragmentManager();
        presenter = new ActivityHomePresenter(this, this, fragmentManager);

//        get menu resources
        tittle = getResources().getStringArray(R.array.menuOptionsTittles);
        images = new int[]{R.drawable.ic_menu_home
                , R.drawable.ic_menu_my_account
                , R.drawable.ic_menu_subscrpyion
                , R.drawable.ic_menu_connect_us
                , R.drawable.ic_menu_about_app
                , R.drawable.ic_menu_terms};

        mOptions = new ArrayList<MenuMoudel>();
        for (int i = 0; i < tittle.length; i++) {
            mOptions.add(new MenuMoudel(tittle[i], getDrawable(images[i])));

        }


        drawerToggle = new DuoDrawerToggle(this, binding.activityHomeDrawer, binding.activityHomeToolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);

        binding.activityHomeDrawer.setDrawerListener(drawerToggle);

        drawerToggle.syncState();

        menuAdapter = new DrawerMenuAdapter(mOptions, this);

        binding.activityHomeMenu.setAdapter(menuAdapter);

        binding.activityHomeMenu.setOnMenuClickListener(new DuoMenuView.OnMenuClickListener() {
            @Override
            public void onFooterClicked() {
                logout();
            }

            @Override
            public void onHeaderClicked() {


            }

            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onOptionClicked(int position, Object objectClicked) {
                menuAdapter.setViewSelected(position, true);
                binding.activityHomeDrawer.closeDrawer();
                presenter.displayFragments(position);

            }
        });
    }

    private void logout() {
        mAuth.signOut();
        HelperMethod.makeTextToast(getApplicationContext(), "logout");
        startActivity(new Intent(HomeActivity.this, LoginActivity.class));
    }

    @Override
    public void onBackPressed() {
        presenter.displayFragments(0);
    }

    @Override
    public void onFinished() {

    }

    @Override
    public void onHomeFragmentSelected() {

    }
}
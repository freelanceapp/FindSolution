package com.semicode.findsolution.ui.homeActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;


import com.google.firebase.auth.FirebaseAuth;
import com.semicode.findsolution.R;
import com.semicode.findsolution.adapter.DrawerMenuAdapter;
import com.semicode.findsolution.databinding.ActivityHomeBinding;
import com.semicode.findsolution.model.MenuMoudel;
import com.semicode.findsolution.mvp.activtyHome.ActivityHomePresenter;
import com.semicode.findsolution.mvp.activtyHome.ActivityHomeView;
import com.semicode.findsolution.ui.HelperMethod;
import com.semicode.findsolution.ui.LoginActivity;


import java.util.ArrayList;

import nl.psdcompany.duonavigationdrawer.views.DuoMenuView;
import nl.psdcompany.duonavigationdrawer.widgets.DuoDrawerToggle;


public class HomeActivity extends AppCompatActivity implements ActivityHomeView {
    private ActivityHomeBinding binding;
    private FirebaseAuth mAuth;
    DuoDrawerToggle drawerToggle;
    private ArrayList<MenuMoudel> mOptions ;
    FragmentManager fragmentManager ;
    ActivityHomePresenter presenter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        initView();


    }

    @SuppressLint("ResourceAsColor")
    private void initView() {
        mAuth = FirebaseAuth.getInstance();
        fragmentManager = getSupportFragmentManager() ;
        presenter = new ActivityHomePresenter(this,this,fragmentManager);
        mOptions = new ArrayList<MenuMoudel>();

        mOptions.add(new MenuMoudel("one","@drawable/ic_edit"));
        mOptions.add(new MenuMoudel("two","@drawable/ic_logout"));
        mOptions.add(new MenuMoudel("three","@drawable/ic_image"));
        mOptions.add(new MenuMoudel("four","@drawable/ic_edit"));
        mOptions.add(new MenuMoudel("five","@drawable/ic_edit"));
        mOptions.add(new MenuMoudel("sex","@drawable/ic_edit"));




        drawerToggle = new DuoDrawerToggle(this, binding.activityHomeDrawer, binding.activityHomeToolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);

        binding.activityHomeDrawer.setDrawerListener(drawerToggle);

        drawerToggle.syncState();

        DrawerMenuAdapter menuAdapter = new DrawerMenuAdapter(mOptions,this);
        binding.activityHomeMenu.setAdapter(menuAdapter);
        binding.activityHomeMenu.setOnMenuClickListener(new DuoMenuView.OnMenuClickListener() {
            @Override
            public void onFooterClicked() {
                logout();
            }

            @Override
            public void onHeaderClicked() {

            }

            @Override
            public void onOptionClicked(int position, Object objectClicked) {
                menuAdapter.setViewSelected(position,true);
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
    public void onFinished() {

    }

    @Override
    public void onHomeFragmentSelected() {

    }
}
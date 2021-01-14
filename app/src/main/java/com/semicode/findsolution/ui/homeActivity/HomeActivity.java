package com.semicode.findsolution.ui.homeActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;


import com.google.firebase.auth.FirebaseAuth;
import com.semicode.findsolution.R;
import com.semicode.findsolution.adapter.menuDrawer.DrawerMenuAdapter;
import com.semicode.findsolution.data.model.categories.CategoryDate;
import com.semicode.findsolution.databinding.ActivityHomeBinding;
import com.semicode.findsolution.data.model.MenuModel;
import com.semicode.findsolution.mvp.activtyHome.ActivityHomePresenter;
import com.semicode.findsolution.mvp.activtyHome.ActivityHomeView;
import com.semicode.findsolution.share.HelperMethod;
import com.semicode.findsolution.share.Language;
import com.semicode.findsolution.share.SharedPreferencesManger;
import com.semicode.findsolution.ui.BaseActivity;
import com.semicode.findsolution.ui.LoginActivity;


import java.util.ArrayList;
import java.util.List;

import nl.psdcompany.duonavigationdrawer.views.DuoMenuView;
import nl.psdcompany.duonavigationdrawer.widgets.DuoDrawerToggle;

import static com.semicode.findsolution.share.SharedPreferencesManger.setSharedPreferences;


public class HomeActivity extends BaseActivity implements ActivityHomeView {
    private ActivityHomeBinding binding;
    private FirebaseAuth mAuth;
    DuoDrawerToggle drawerToggle;
    private ArrayList<MenuModel> mOptions;
    private String[] tittle;
    private int[] images;
    private int[] imagesSelected;
    FragmentManager fragmentManager;
    ActivityHomePresenter presenter;
    DrawerMenuAdapter menuAdapter;
    String lang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        initView();
    }

    @Override
    protected void attachBaseContext(Context newBase) {
//        lang = "en";
        lang =SharedPreferencesManger.LoadData(this,SharedPreferencesManger.LANGUAGE,"ar");
        super.attachBaseContext(Language.updateResources(newBase, lang));
    }

    @SuppressLint({"ResourceAsColor", "UseCompatLoadingForDrawables"})
    private void initView() {
        setSharedPreferences(this);
        mAuth = FirebaseAuth.getInstance();
        fragmentManager = getSupportFragmentManager();
        presenter = new ActivityHomePresenter(this, this, fragmentManager);

        getMenuData();
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
                presenter.openProfile();

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

    private void getMenuData() {
//        get menu resources
        tittle = getResources().getStringArray(R.array.menuOptionsTittles);
        images = new int[]{R.drawable.ic_menu_home_gray
                , R.drawable.ic_menu_my_account_gray
                , R.drawable.ic_menu_subscrpyion_gray
                , R.drawable.ic_menu_translate_gray
                , R.drawable.ic_menu_connect_us_gray
                , R.drawable.ic_menu_about_app_gray
                , R.drawable.ic_menu_terms_gray};
        imagesSelected = new int[]{R.drawable.ic_menu_home
                , R.drawable.ic_menu_my_account
                , R.drawable.ic_menu_subscrpyion
                , R.drawable.ic_menu_translate
                , R.drawable.ic_menu_connect_us
                , R.drawable.ic_menu_about_app
                , R.drawable.ic_menu_terms};

        mOptions = new ArrayList<MenuModel>();
        for (int i = 0; i < tittle.length; i++) {
            mOptions.add(new MenuModel(tittle[i], getDrawable(images[i]), getDrawable(imagesSelected[i])));

        }
    }

    private void logout() {
        mAuth.signOut();
        HelperMethod.makeTextToast(getApplicationContext(), "logout");
        startActivity(new Intent(HomeActivity.this, LoginActivity.class));
    }

    public void refreshActivity(String lang) {
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            SharedPreferencesManger.SaveData(this, SharedPreferencesManger.LANGUAGE, lang);
//            Language.updateResources(this, lang);
            HelperMethod.changeLang(this, lang);
            Intent intent = getIntent();
            finish();
            startActivity(intent);
        }, 1500);


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
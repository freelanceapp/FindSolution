package com.semicode.findsolution.ui.homeActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

import androidx.annotation.RequiresApi;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;


import com.semicode.findsolution.R;
import com.semicode.findsolution.adapter.menuDrawer.DrawerMenuAdapter;
import com.semicode.findsolution.data.model.UserModelData;
import com.semicode.findsolution.data.model.appInformation.AppInformationData;
import com.semicode.findsolution.databinding.ActivityHomeBinding;
import com.semicode.findsolution.data.model.MenuModel;
import com.semicode.findsolution.mvp.activtyHome.ActivityHomePresenter;
import com.semicode.findsolution.mvp.activtyHome.ActivityHomeView;
import com.semicode.findsolution.share.HelperMethod;
import com.semicode.findsolution.share.Language;
import com.semicode.findsolution.data.local.SharedPreferencesManger;
import com.semicode.findsolution.ui.BaseActivity;
import com.semicode.findsolution.ui.LoginActivity;


import java.util.ArrayList;

import nl.psdcompany.duonavigationdrawer.views.DuoMenuView;
import nl.psdcompany.duonavigationdrawer.widgets.DuoDrawerToggle;

import static com.semicode.findsolution.data.local.SharedPreferencesManger.setSharedPreferences;


public class HomeActivity extends BaseActivity implements ActivityHomeView {
    private ActivityHomeBinding binding;
    DuoDrawerToggle drawerToggle;
    private ArrayList<MenuModel> mOptions;
    private String[] tittle;
    private int[] images;
    private int[] imagesSelected;
    FragmentManager fragmentManager;
    ActivityHomePresenter presenter;
    DrawerMenuAdapter menuAdapter;
    String lang;
    UserModelData userModelData;

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
        lang = SharedPreferencesManger.LoadData(this, SharedPreferencesManger.LANGUAGE, "ar");
        super.attachBaseContext(Language.updateResources(newBase, lang));
    }

    @SuppressLint({"ResourceAsColor", "UseCompatLoadingForDrawables"})
    private void initView() {
        setSharedPreferences(this);
        userModelData = SharedPreferencesManger.LoadUserData(this);
        fragmentManager = getSupportFragmentManager();
        presenter = new ActivityHomePresenter(this, this, fragmentManager);

        getMenuData();

        drawerToggle = new DuoDrawerToggle(this, binding.activityHomeDrawer, binding.toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        binding.activityHomeDrawer.setDrawerListener(drawerToggle);
        drawerToggle.syncState();

        menuAdapter = new DrawerMenuAdapter(mOptions, this);

        binding.activityHomeMenu.setAdapter(menuAdapter);
        binding.activityHomeMenu.getFooterView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });

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
        binding.toolbar.inflateMenu(R.menu.top_menu);
        binding.toolbar.setNavigationIcon(this.getDrawable(R.drawable.ic_menu));

//        setSupportActionBar(binding.toolbar);
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
        HelperMethod.makeTextToast(getApplicationContext(), "logout");
        SharedPreferencesManger.clean(this);
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

    @Override
    public void onGetAppInformation(AppInformationData appInformationData) {
        HelperMethod.makeTextToast(this, "App data loaded");
        SharedPreferencesManger.SaveData(this, SharedPreferencesManger.APPDATA, appInformationData);
    }

    @Override
    public void onFailedLoadInformationData() {
        HelperMethod.makeTextToast(this, "Failed to load App data");
        presenter.getAppInformation();
    }


}
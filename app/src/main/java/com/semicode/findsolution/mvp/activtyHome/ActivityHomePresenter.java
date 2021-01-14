package com.semicode.findsolution.mvp.activtyHome;

import android.content.Context;
import android.content.Intent;

import androidx.fragment.app.FragmentManager;

import com.semicode.findsolution.R;
import com.semicode.findsolution.data.api.Api;
import com.semicode.findsolution.data.model.categories.Category;
import com.semicode.findsolution.tags.Tags;
import com.semicode.findsolution.ui.ProfileActivity;
import com.semicode.findsolution.ui.homeActivity.fragment.AboutAppFragment;
import com.semicode.findsolution.ui.homeActivity.fragment.ConnectUsFragment;
import com.semicode.findsolution.ui.homeActivity.fragment.HomeFragment;
import com.semicode.findsolution.ui.homeActivity.fragment.ChangeLanguageFragment;
import com.semicode.findsolution.ui.homeActivity.fragment.SubscriptionFragment;
import com.semicode.findsolution.ui.homeActivity.fragment.TermsAndConditionFragment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityHomePresenter {


    private Context context;
    private FragmentManager fragmentManager;
    private ActivityHomeView view;

    private AboutAppFragment aboutAppFragment;
    private ConnectUsFragment connectUsFragment;
    HomeFragment homeFragment;
    private ChangeLanguageFragment changeLanguageFragment;
    private SubscriptionFragment subscriptionFragment;
    private TermsAndConditionFragment termsAndConditionFragment;


    public ActivityHomePresenter(Context context, ActivityHomeView view, FragmentManager fragmentManager) {
        this.context = context;
        this.fragmentManager = fragmentManager;
        this.view = view;

        displayFragmentHome();

    }



    public void displayFragments(int position) {

        switch (position) {
            case 1:
                openProfile();
                break;
            case 2:
                displayFragmentSubscription();
                break;
            case 3:
                displayFragmentChangeLanguage();
                break;
            case 4:
                displayFragmentConnectUs();
                break;
            case 5:
                displayFragmentAboutApp();
                break;
            case 6:
                displayFragmentTermsAndCondition();
                break;

            default:
                displayFragmentHome();
                break;
        }
    }

    public void openProfile() {
        Intent intent = new Intent(context, ProfileActivity.class);
        context.startActivity(intent);

    }

    private void displayFragmentHome() {
        view.onHomeFragmentSelected();

        if (homeFragment == null) {
            homeFragment = HomeFragment.newInstance();
        }

        if (aboutAppFragment != null && aboutAppFragment.isAdded()) {
            fragmentManager.beginTransaction().hide(aboutAppFragment).commit();
        }

        if (connectUsFragment != null && connectUsFragment.isAdded()) {
            fragmentManager.beginTransaction().hide(connectUsFragment).commit();
        }

        if (changeLanguageFragment != null && changeLanguageFragment.isAdded()) {
            fragmentManager.beginTransaction().hide(changeLanguageFragment).commit();
        }
        if (subscriptionFragment != null && subscriptionFragment.isAdded()) {
            fragmentManager.beginTransaction().hide(subscriptionFragment).commit();
        }
        if (termsAndConditionFragment != null && termsAndConditionFragment.isAdded()) {
            fragmentManager.beginTransaction().hide(termsAndConditionFragment).commit();
        }

        if (homeFragment.isAdded()) {
            fragmentManager.beginTransaction().show(homeFragment).commit();
        } else {
            fragmentManager.beginTransaction().add(R.id.activity_home_container, homeFragment, "home").commit();
        }
    }

    private void displayFragmentAboutApp() {
        if (aboutAppFragment == null) {
            aboutAppFragment = AboutAppFragment.newInstance();
        }

        if (homeFragment != null && homeFragment.isAdded()) {
            fragmentManager.beginTransaction().hide(homeFragment).commit();
        }

        if (connectUsFragment != null && connectUsFragment.isAdded()) {
            fragmentManager.beginTransaction().hide(connectUsFragment).commit();
        }

        if (changeLanguageFragment != null && changeLanguageFragment.isAdded()) {
            fragmentManager.beginTransaction().hide(changeLanguageFragment).commit();
        }
        if (subscriptionFragment != null && subscriptionFragment.isAdded()) {
            fragmentManager.beginTransaction().hide(subscriptionFragment).commit();
        }
        if (termsAndConditionFragment != null && termsAndConditionFragment.isAdded()) {
            fragmentManager.beginTransaction().hide(termsAndConditionFragment).commit();
        }

        if (aboutAppFragment.isAdded()) {
            fragmentManager.beginTransaction().show(aboutAppFragment).commit();
        } else {
            fragmentManager.beginTransaction().add(R.id.activity_home_container, aboutAppFragment, "About App").commit();
        }
    }

    private void displayFragmentConnectUs() {
        if (connectUsFragment == null) {
            connectUsFragment = ConnectUsFragment.newInstance();
        }

        if (aboutAppFragment != null && aboutAppFragment.isAdded()) {
            fragmentManager.beginTransaction().hide(aboutAppFragment).commit();
        }

        if (homeFragment != null && homeFragment.isAdded()) {
            fragmentManager.beginTransaction().hide(homeFragment).commit();
        }

        if (changeLanguageFragment != null && changeLanguageFragment.isAdded()) {
            fragmentManager.beginTransaction().hide(changeLanguageFragment).commit();
        }
        if (subscriptionFragment != null && subscriptionFragment.isAdded()) {
            fragmentManager.beginTransaction().hide(subscriptionFragment).commit();
        }
        if (termsAndConditionFragment != null && termsAndConditionFragment.isAdded()) {
            fragmentManager.beginTransaction().hide(termsAndConditionFragment).commit();
        }

        if (connectUsFragment.isAdded()) {
            fragmentManager.beginTransaction().show(connectUsFragment).commit();
        } else {
            fragmentManager.beginTransaction().add(R.id.activity_home_container, connectUsFragment, "connect us ").commit();
        }
    }

    private void displayFragmentChangeLanguage() {
        if (changeLanguageFragment == null) {
            changeLanguageFragment = ChangeLanguageFragment.newInstance();
        }

        if (aboutAppFragment != null && aboutAppFragment.isAdded()) {
            fragmentManager.beginTransaction().hide(aboutAppFragment).commit();
        }

        if (connectUsFragment != null && connectUsFragment.isAdded()) {
            fragmentManager.beginTransaction().hide(connectUsFragment).commit();
        }

        if (homeFragment != null && homeFragment.isAdded()) {
            fragmentManager.beginTransaction().hide(homeFragment).commit();
        }
        if (subscriptionFragment != null && subscriptionFragment.isAdded()) {
            fragmentManager.beginTransaction().hide(subscriptionFragment).commit();
        }
        if (termsAndConditionFragment != null && termsAndConditionFragment.isAdded()) {
            fragmentManager.beginTransaction().hide(termsAndConditionFragment).commit();
        }

        if (changeLanguageFragment.isAdded()) {
            fragmentManager.beginTransaction().show(changeLanguageFragment).commit();
        } else {
            fragmentManager.beginTransaction().add(R.id.activity_home_container, changeLanguageFragment, "My Account").commit();
        }
    }

    private void displayFragmentSubscription() {
        if (subscriptionFragment == null) {
            subscriptionFragment = SubscriptionFragment.newInstance();
        }

        if (aboutAppFragment != null && aboutAppFragment.isAdded()) {
            fragmentManager.beginTransaction().hide(aboutAppFragment).commit();
        }

        if (connectUsFragment != null && connectUsFragment.isAdded()) {
            fragmentManager.beginTransaction().hide(connectUsFragment).commit();
        }

        if (changeLanguageFragment != null && changeLanguageFragment.isAdded()) {
            fragmentManager.beginTransaction().hide(changeLanguageFragment).commit();
        }
        if (subscriptionFragment != null && subscriptionFragment.isAdded()) {
            fragmentManager.beginTransaction().hide(subscriptionFragment).commit();
        }
        if (termsAndConditionFragment != null && termsAndConditionFragment.isAdded()) {
            fragmentManager.beginTransaction().hide(termsAndConditionFragment).commit();
        }
        if (homeFragment != null && homeFragment.isAdded()) {
            fragmentManager.beginTransaction().hide(homeFragment).commit();
        }

        if (subscriptionFragment.isAdded()) {
            fragmentManager.beginTransaction().show(subscriptionFragment).commit();
        } else {
            fragmentManager.beginTransaction().add(R.id.activity_home_container, subscriptionFragment, "Subscription").commit();
        }
    }

    private void displayFragmentTermsAndCondition() {
        if (termsAndConditionFragment == null) {
            termsAndConditionFragment = TermsAndConditionFragment.newInstance();
        }

        if (aboutAppFragment != null && aboutAppFragment.isAdded()) {
            fragmentManager.beginTransaction().hide(aboutAppFragment).commit();
        }

        if (connectUsFragment != null && connectUsFragment.isAdded()) {
            fragmentManager.beginTransaction().hide(connectUsFragment).commit();
        }

        if (changeLanguageFragment != null && changeLanguageFragment.isAdded()) {
            fragmentManager.beginTransaction().hide(changeLanguageFragment).commit();
        }
        if (subscriptionFragment != null && subscriptionFragment.isAdded()) {
            fragmentManager.beginTransaction().hide(subscriptionFragment).commit();
        }
        if (homeFragment != null && homeFragment.isAdded()) {
            fragmentManager.beginTransaction().hide(homeFragment).commit();
        }

        if (termsAndConditionFragment.isAdded()) {
            fragmentManager.beginTransaction().show(termsAndConditionFragment).commit();
        } else {
            fragmentManager.beginTransaction().add(R.id.activity_home_container, termsAndConditionFragment, "Terms And Condition").commit();
        }
    }


    public void backPress() {
        if (homeFragment != null && homeFragment.isAdded() && homeFragment.isVisible()) {
            view.onFinished();
        } else {
            displayFragmentHome();
            view.onHomeFragmentSelected();
        }
    }
}

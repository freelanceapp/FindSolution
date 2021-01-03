package com.semicode.findsolution.mvp.activtyHome;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.MenuItem;

import androidx.fragment.app.FragmentManager;

import com.semicode.findsolution.R;
import com.semicode.findsolution.ui.homeActivity.fragment.AboutAppFragment;
import com.semicode.findsolution.ui.homeActivity.fragment.ConnectUsFragment;
import com.semicode.findsolution.ui.homeActivity.fragment.HomeFragment;
import com.semicode.findsolution.ui.homeActivity.fragment.MyAccountFragment;
import com.semicode.findsolution.ui.homeActivity.fragment.SubscriptionFragment;
import com.semicode.findsolution.ui.homeActivity.fragment.TermsAndConditionFragment;

public class ActivityHomePresenter {


    private Context context;
    private FragmentManager fragmentManager;
    private ActivityHomeView view;

    private AboutAppFragment aboutAppFragment;
    private ConnectUsFragment connectUsFragment;
    private HomeFragment homeFragment;
    private MyAccountFragment myAccountFragment;
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
                displayFragmentAboutApp();
                break;
            case 2:
                displayFragmentConnectUs();
                break;
            case 3:
                displayFragmentMyAccount();
                break;
            case 4:
                displayFragmentSubscription();
                break;
            case 5:
                displayFragmentTermsAndCondition();
                break;

            default:
                displayFragmentHome();
                break;
        }
    }

    private void displayFragmentHome() {
        if (homeFragment == null) {
            homeFragment = HomeFragment.newInstance();
        }

        if (aboutAppFragment != null && aboutAppFragment.isAdded()) {
            fragmentManager.beginTransaction().hide(aboutAppFragment).commit();
        }

        if (connectUsFragment != null && connectUsFragment.isAdded()) {
            fragmentManager.beginTransaction().hide(connectUsFragment).commit();
        }

        if (myAccountFragment != null && myAccountFragment.isAdded()) {
            fragmentManager.beginTransaction().hide(myAccountFragment).commit();
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

        if (myAccountFragment != null && myAccountFragment.isAdded()) {
            fragmentManager.beginTransaction().hide(myAccountFragment).commit();
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

        if (myAccountFragment != null && myAccountFragment.isAdded()) {
            fragmentManager.beginTransaction().hide(myAccountFragment).commit();
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

    private void displayFragmentMyAccount() {
        if (myAccountFragment == null) {
            myAccountFragment = MyAccountFragment.newInstance();
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

        if (myAccountFragment.isAdded()) {
            fragmentManager.beginTransaction().show(myAccountFragment).commit();
        } else {
            fragmentManager.beginTransaction().add(R.id.activity_home_container, myAccountFragment, "My Account").commit();
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

        if (myAccountFragment != null && myAccountFragment.isAdded()) {
            fragmentManager.beginTransaction().hide(myAccountFragment).commit();
        }
        if (subscriptionFragment != null && subscriptionFragment.isAdded()) {
            fragmentManager.beginTransaction().hide(subscriptionFragment).commit();
        }
        if (termsAndConditionFragment != null && termsAndConditionFragment.isAdded()) {
            fragmentManager.beginTransaction().hide(termsAndConditionFragment).commit();
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

        if (myAccountFragment != null && myAccountFragment.isAdded()) {
            fragmentManager.beginTransaction().hide(myAccountFragment).commit();
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

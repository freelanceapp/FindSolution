package com.semicode.findsolution.adapter.menuDrawer;


import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.semicode.findsolution.data.model.MenuModel;

import java.util.ArrayList;


public class DrawerMenuAdapter extends BaseAdapter {
    private ArrayList<MenuModel> mOptions = new ArrayList<>();
    private ArrayList<MenuOptionView> mOptionViews = new ArrayList<>();
    private Context context;

    public DrawerMenuAdapter(ArrayList<MenuModel> options, Context context) {
        mOptions = options;
        this.context = context;

    }

    @Override
    public int getCount() {
        return mOptions.size();
    }

    @Override
    public Object getItem(int position) {
        return mOptions.get(position);
    }

    @SuppressLint("ResourceAsColor")
    public void setViewSelected(int position, boolean selected) {

        // Looping through the options in the menu

        // Selecting the chosen option

        for (int i = 0; i < mOptionViews.size(); i++) {
            if (i == position) {
                mOptionViews.get(i).setSelected(selected);

            } else {
                mOptionViews.get(i).setSelected(!selected);

            }
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        setViewSelected(0,true);
        final String optionTittle = mOptions.get(position).getTittle();
        final Drawable optionImage = mOptions.get(position).getImage();
        final Drawable optionImageSelected = mOptions.get(position).getImageSelected();

        // Using the DuoOptionView to easily recreate the demo

        final MenuOptionView optionView;

        if (convertView == null) {
            optionView = new MenuOptionView(parent.getContext());
        } else {
            optionView = (MenuOptionView) convertView;
        }

        optionView.bind(optionTittle, optionImage,optionImageSelected);

        // Adding the views to an array list to handle view selection
        mOptionViews.add(optionView);

        return optionView;
    }
}



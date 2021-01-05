package com.semicode.findsolution.adapter;


import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import com.semicode.findsolution.R;
import com.semicode.findsolution.model.MenuMoudel;

import java.util.ArrayList;

import nl.psdcompany.duonavigationdrawer.views.DuoOptionView;


public class DrawerMenuAdapter extends BaseAdapter {
    private ArrayList<MenuMoudel> mOptions = new ArrayList<>();
    private ArrayList<DuoOptionView> mOptionViews = new ArrayList<>();
    private Context context;

    public DrawerMenuAdapter(ArrayList<MenuMoudel> options, Context context) {
        mOptions = options;
        this.context = context;
        setViewSelected(0,true);
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
        final String optionTittle = mOptions.get(position).getTittle();
        final Drawable optionImage = mOptions.get(position).getImage();

        // Using the DuoOptionView to easily recreate the demo

        final DuoOptionView optionView;

        if (convertView == null) {
            optionView = new DuoOptionView(parent.getContext());
        } else {
            optionView = (DuoOptionView) convertView;
        }
        TextView textView = optionView.getRootView().findViewById(R.id.duo_view_option_text);
        textView.setTextColor(Color.BLACK);
        textView.setTextSize(16);


//        String uri = mOptions.get(position).getImage();

//        int imageResource = context.getResources().getIdentifier(uri, null, context.getPackageName());

        // Using the DuoOptionView's default selectors
        // optionView.bind(option, context.getDrawable(R.drawable.ic_logout));

        optionView.bind(optionTittle, optionImage);

        // Adding the views to an array list to handle view selection
        mOptionViews.add(optionView);

        return optionView;
    }
}



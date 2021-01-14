package com.semicode.findsolution.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.semicode.findsolution.R;
import com.semicode.findsolution.data.model.packageModel.PackageData;


import java.util.List;


public class PackageAdapter extends RecyclerView.Adapter<PackageAdapter.MyViewHolder> {


    private LayoutInflater mInflater;
    private List<PackageData> dataList;
    OnPackageClick onPackageClick;
    Context context;

    // data is passed into the constructor
    public PackageAdapter(Activity activity, List<PackageData> data, OnPackageClick onPackageClick) {
        this.context = activity;
        this.mInflater = LayoutInflater.from(activity);
        this.dataList = data;
        this.onPackageClick = onPackageClick;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_rv_subscription, parent, false);
        return new MyViewHolder(view, onPackageClick);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        setData(holder, position);
    }

    private void setData(MyViewHolder holder, int position) {
        holder.price.setText(dataList.get(position).getPrice().toString());
        holder.currency.setText(dataList.get(position).getCurrency());
        holder.months.setText(dataList.get(position).getNumberOfMonths().toString());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView price, currency, months;
        Button btnSubscription;
        OnPackageClick view;

        MyViewHolder(View itemView, OnPackageClick onPackageClick) {
            super(itemView);
            this.view = onPackageClick;
            price = itemView.findViewById(R.id.item_rv_Sub_tv_price);
            currency = itemView.findViewById(R.id.item_rv_Sub_tv_Currency);
            months = itemView.findViewById(R.id.item_rv_Sub_tv_month);
            btnSubscription = itemView.findViewById(R.id.item_rv_Sub_btn_subscription);
            btnSubscription.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    view.onPackageClick(getAdapterPosition());
                }
            });

        }


    }

    public interface OnPackageClick {
        void onPackageClick(int position);

    }
}




package com.semicode.findsolution.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.semicode.findsolution.R;
import com.semicode.findsolution.model.SectionModel;

import java.util.List;


public class SectionFilterAdapter extends RecyclerView.Adapter<SectionFilterAdapter.SectionViewHolder> {


    private List<SectionModel> dataList;
    private LayoutInflater mInflater;
    Context context;
    OnKindClick onKindClick;
    private int selectedPosition =0;

    // data is passed into the constructor
    public SectionFilterAdapter(Activity activity, List<SectionModel> data, OnKindClick onKindClick) {
        this.context = activity;
        this.mInflater = LayoutInflater.from(activity);
        this.dataList = data;
        this.onKindClick = onKindClick;
    }

    @Override
    public SectionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_rv_section_filter, parent, false);
        return new SectionViewHolder(view, onKindClick);
    }

    @Override
    public void onBindViewHolder(SectionViewHolder holder, int position) {
        setData(holder, position);
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private void setData(SectionViewHolder holder, int position) {
        holder.textView.setText(dataList.get(position).getSectionName());
        holder.imageView.setBackgroundResource(dataList.get(position).getSectionImage());

        if (selectedPosition == position) {
            holder.itemView.setBackground(context.getDrawable(R.drawable.btn_background_25_radius));
            holder.textView.setTextColor(context.getResources().getColor(R.color.white));
        }else {
            holder.itemView.setBackground(context.getDrawable(R.drawable.item_background_stroke_gray_20));
            holder.textView.setTextColor(context.getResources().getColor(R.color.gray));

        }




    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }


    public class SectionViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textView;
        ImageView imageView;
        OnKindClick onKindClick;

        SectionViewHolder(View itemView, OnKindClick onKindClick) {
            super(itemView);
            this.onKindClick = onKindClick;

            textView = itemView.findViewById(R.id.item_rv_section_filter_tv);
            imageView = itemView.findViewById(R.id.item_rv_section_filter_iv);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            onKindClick.onItemKindClick(getAdapterPosition());
            selectedPosition= getAdapterPosition();
            notifyDataSetChanged();
        }
    }

    public interface OnKindClick {
        void onItemKindClick(int position);

    }
}
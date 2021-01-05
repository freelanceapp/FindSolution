package com.semicode.findsolution.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import com.semicode.findsolution.R;
import com.semicode.findsolution.model.SectionModel;

import java.util.List;


public class SectionAdapter extends RecyclerView.Adapter<SectionAdapter.SectionViewHolder> {


    private List<SectionModel> dataList;
    private LayoutInflater mInflater;
    ONSectionClick onItemClick;
    Context context;

    // data is passed into the constructor
    public SectionAdapter(Activity activity, List<SectionModel> data, ONSectionClick onItemClick) {
        this.context = activity;
        this.mInflater = LayoutInflater.from(activity);
        this.dataList = data;
        this.onItemClick = onItemClick;
    }

    @Override
    public SectionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_rv_section, parent, false);
        return new SectionViewHolder(view, onItemClick);
    }

    @Override
    public void onBindViewHolder(SectionViewHolder holder, int position) {
        setData(holder, position);
    }

    private void setData(SectionViewHolder holder, int position) {
        holder.textView.setText(dataList.get(position).getSectionName());
        holder.imageView.setBackgroundResource(dataList.get(position).getSectionImage());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }


    public class SectionViewHolder extends RecyclerView.ViewHolder implements ONSectionClick {
        TextView textView;
        ImageView imageView;
        ONSectionClick itemClick;

        SectionViewHolder(View itemView, ONSectionClick itemClick) {
            super(itemView);
            this.itemClick = itemClick;

            textView = itemView.findViewById(R.id.item_rv_section_tv);
            imageView = itemView.findViewById(R.id.item_rv_section_iv);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClick.onSectionClick(getAdapterPosition());

                }
            });
        }


        @Override
        public void onSectionClick(int position) {
            itemClick.onSectionClick(getAdapterPosition());

        }
    }

    public interface ONSectionClick {
        void onSectionClick(int position);

    }
}
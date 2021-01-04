package com.semicode.findsolution.adapter;

import android.app.Activity;
import android.content.Context;
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

    // data is passed into the constructor
    public SectionFilterAdapter(Activity activity, List<SectionModel> data) {
        this.context = activity;
        this.mInflater = LayoutInflater.from(activity);
        this.dataList = data;
    }

    @Override
    public SectionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_rv_section_filter, parent, false);
        return new SectionViewHolder(view);
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


    public class SectionViewHolder extends RecyclerView.ViewHolder  {
        TextView textView;
        ImageView imageView;


        SectionViewHolder(View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.item_rv_section_filter_tv);
            imageView = itemView.findViewById(R.id.item_rv_section_filter_iv);
        }



    }

    public interface ONSectionClick {
        void onItemClick(int position);

    }
}
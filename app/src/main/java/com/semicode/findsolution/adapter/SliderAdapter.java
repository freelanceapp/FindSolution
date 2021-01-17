package com.semicode.findsolution.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.semicode.findsolution.R;
import com.semicode.findsolution.data.model.Slider.SliderData;
import com.semicode.findsolution.tags.Tags;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SliderAdapter extends RecyclerView.Adapter<SliderAdapter.SliderViewHolder> {


    private List<SliderData> dataList;
    private LayoutInflater mInflater;
    Context context;

    // data is passed into the constructor
    public SliderAdapter(Activity activity, List<SliderData> data) {
        this.context = activity;
        this.mInflater = LayoutInflater.from(activity);
        this.dataList = data;
    }

    @Override
    public SliderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_rv_slider, parent, false);
        return new SliderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SliderViewHolder holder, int position) {
        setData(holder, position);
        setAction(holder, position);


    }

    private void setAction(SliderViewHolder holder, int position) {
    }

    private void setData(SliderViewHolder holder, int position) {
        Picasso.get().load(Tags.IMAGE_URL + dataList.get(position).getImage()).into(holder.imageView);


    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }


    public class SliderViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;


        SliderViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.item_rv_slider_image);

        }
    }

}
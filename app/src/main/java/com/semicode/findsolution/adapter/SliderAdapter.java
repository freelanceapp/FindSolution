package com.semicode.findsolution.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.semicode.findsolution.R;
import com.semicode.findsolution.data.model.sliderModel.SliderData;
import com.semicode.findsolution.databinding.ItemRvSliderBinding;


import java.util.List;


public class SliderAdapter extends RecyclerView.Adapter<SliderAdapter.SliderViewHolder> {

    private List<SliderData> dataList;
    private LayoutInflater mInflater;
    Context context;

    //    -------------   -------------   -------------   -------------   -------------   -------------   -------------
    public SliderAdapter(List<SliderData> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
        mInflater = LayoutInflater.from(context);

    }

    @NonNull
    @Override
    public SliderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemRvSliderBinding binding = DataBindingUtil.inflate(mInflater, R.layout.item_rv_slider, parent, false);
        return new SliderViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull SliderViewHolder holder, int position) {
        SliderViewHolder sliderViewHolder = (SliderViewHolder) holder;
        sliderViewHolder.binding.setSliderData(dataList.get(position));

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class SliderViewHolder extends RecyclerView.ViewHolder {
        public ItemRvSliderBinding binding;


        public SliderViewHolder(@NonNull ItemRvSliderBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }


}
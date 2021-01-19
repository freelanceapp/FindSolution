package com.semicode.findsolution.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.semicode.findsolution.R;
import com.semicode.findsolution.data.model.categories.CategoryDate;
import com.semicode.findsolution.databinding.ItemRvSectionBinding;

import java.util.List;


public class SectionAdapter extends RecyclerView.Adapter<SectionAdapter.SectionViewHolder> {

    private List<CategoryDate> dataList;
    private LayoutInflater mInflater;
    ONSectionClick onItemClick;
    Context context;
//    -------------   -------------   -------------   -------------   -------------   -------------   -------------
    public SectionAdapter(List<CategoryDate> categoryDate, Context context, ONSectionClick onItemClick) {
        this.dataList = categoryDate;
        this.context = context;
        mInflater = LayoutInflater.from(context);
        this.onItemClick =onItemClick ;

//        Paper.init(context);
//        lang = Paper.book().read("lang", java.util.Locale.getDefault().getLanguage());

    }
    @androidx.annotation.NonNull
    @Override
    public SectionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemRvSectionBinding binding = DataBindingUtil.inflate(mInflater, R.layout.item_rv_section, parent, false);
        return new SectionViewHolder(binding,onItemClick);
    }
    @Override
    public void onBindViewHolder(@androidx.annotation.NonNull SectionViewHolder holder, int position) {
        SectionViewHolder sectionViewHolder = (SectionViewHolder) holder;
        sectionViewHolder.binding.setSectionModelData(dataList.get(position));
        sectionViewHolder.itemView.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                onItemClick.onSectionClick(sectionViewHolder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class SectionViewHolder extends RecyclerView.ViewHolder {
        public ItemRvSectionBinding binding;
        ONSectionClick onItemClick;
        public SectionViewHolder(@androidx.annotation.NonNull ItemRvSectionBinding binding,ONSectionClick onItemClick) {
            super(binding.getRoot());
            this.binding = binding;
            this.onItemClick =onItemClick ;

        }
    }

    public interface ONSectionClick {
        void onSectionClick(int position);

    }
}
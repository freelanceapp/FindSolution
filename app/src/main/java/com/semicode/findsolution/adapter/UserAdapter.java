package com.semicode.findsolution.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.semicode.findsolution.R;
import com.semicode.findsolution.model.UserModel;

import java.util.List;


public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {


    private List<UserModel> dataList;
    private LayoutInflater mInflater;
    Context context;
    OnUserClick onUserClick ;

    // data is passed into the constructor
    public UserAdapter(Activity activity, List<UserModel> data,OnUserClick onUserClick) {
        this.context = activity;
        this.mInflater = LayoutInflater.from(activity);
        this.dataList = data;
        this.onUserClick = onUserClick ;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_rv_user, parent, false);
        return new UserViewHolder(view, onUserClick);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        setData(holder, position);
    }

    private void setData(UserViewHolder holder, int position) {
        holder.name.setText(dataList.get(position).getName());
        holder.jop.setText(dataList.get(position).getJop());
        holder.location.setText(dataList.get(position).getLocation());
        holder.kind.setText(dataList.get(position).getKind());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }


    public class UserViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView name, jop, location, kind;
        OnUserClick onUserClick;

        UserViewHolder(View itemView, OnUserClick onUserClick) {
            super(itemView);
            this.onUserClick = onUserClick;


            name = itemView.findViewById(R.id.item_rv_user_tv_name);
            jop = itemView.findViewById(R.id.item_rv_user_tv_jop);
            location = itemView.findViewById(R.id.item_rv_user_tv_location);
            kind = itemView.findViewById(R.id.item_rv_user_tv_kind);
            itemView.setOnClickListener((View.OnClickListener) this);
        }


        @Override
        public void onClick(View v) {
            onUserClick.onItemUserClick(getAdapterPosition());

        }
    }
    public interface OnUserClick {
        void onItemUserClick(int position);

    }
}



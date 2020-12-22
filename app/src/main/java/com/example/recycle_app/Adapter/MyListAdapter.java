package com.example.recycle_app.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycle_app.DetailActivity;
import com.example.recycle_app.Model.ItemData;
import com.example.recycle_app.R;

import java.util.List;

public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.MyListHolder> {
    private Context mContext;
    private List<ItemData> myItemData;

    public MyListAdapter(Context mContext, List<ItemData> myItemData){
        this.mContext = mContext;
        this.myItemData = myItemData;
    }
    @NonNull
    @Override
    public MyListAdapter.MyListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        MyListHolder holder = new MyListHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyListAdapter.MyListHolder holder, int position) {
        MyListHolder.imageView.setImageResource(myItemData.get(position).getItemImage());
        MyListHolder.mNama.setText(myItemData.get(position).getItemName());
        MyListHolder.mOwner.setText(myItemData.get(position).getItemOwner());

        MyListHolder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, DetailActivity.class);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return myItemData.size();
    }

    static class MyListHolder extends RecyclerView.ViewHolder{
        static ImageView imageView;
        static TextView mNama, mOwner;
        static ConstraintLayout constraintLayout;

        public MyListHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
            mNama = itemView.findViewById(R.id.NamaTempat);
            mOwner = itemView.findViewById(R.id.Owner);
            constraintLayout = itemView.findViewById(R.id.constraint);
        }
    }
}

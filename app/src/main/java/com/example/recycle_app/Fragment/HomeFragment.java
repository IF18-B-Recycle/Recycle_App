package com.example.recycle_app.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.recycle_app.Adapter.MyListAdapter;
import com.example.recycle_app.LoginActivity;
import com.example.recycle_app.MainActivity;
import com.example.recycle_app.Model.ItemData;
import com.example.recycle_app.R;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    List<ItemData> myItemData;
    ItemData mItemData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        RecyclerView mRecyclerView = (RecyclerView)view.findViewById(R.id.recyclerViewHome);
        mRecyclerView.setHasFixedSize(true);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),1);
        mRecyclerView.setLayoutManager(gridLayoutManager);

        myItemData= new ArrayList<>();
        mItemData = new ItemData("Jaya Abadi", "Johanes", R.drawable.default_gambar);
        myItemData.add(mItemData);
        mItemData = new ItemData("Sinar Rongsok", "Hartanto", R.drawable.default_gambar);
        myItemData.add(mItemData);
        mItemData = new ItemData("Cahaya Elang", "Ardjuna", R.drawable.default_gambar);
        myItemData.add(mItemData);

        MyListAdapter myAdapter = new MyListAdapter(getContext(),myItemData);
        mRecyclerView.setAdapter(myAdapter);
        return view;
    }
}
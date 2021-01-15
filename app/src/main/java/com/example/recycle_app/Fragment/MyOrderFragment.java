package com.example.recycle_app.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.recycle_app.Adapter.MyListAdapter;
import com.example.recycle_app.Adapter.MyOrderAdapter;
import com.example.recycle_app.Model.ItemData;
import com.example.recycle_app.Model.ModelMyOrder;
import com.example.recycle_app.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.ArrayList;

public class MyOrderFragment extends Fragment {

    // [START define_database_reference]
    private DatabaseReference mDatabase;
    // [END define_database_reference]

    private FirebaseRecyclerAdapter<ModelMyOrder, MyOrderAdapter> mAdapter;
    private RecyclerView mRecyclerView;

    FirebaseAuth auth;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_order, container, false);

        //Untuk atuhentikasi user yang login
        auth = FirebaseAuth.getInstance();


        mDatabase = FirebaseDatabase.getInstance().getReference();

        mRecyclerView = view.findViewById(R.id.recyclerview_myOrder);
        mRecyclerView.setHasFixedSize(true);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),1);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        getdata();
        return view;
    }

    private void getdata() {
        // Set up FirebaseRecyclerAdapter with the Query
        Query query = getQuery(mDatabase);

        FirebaseRecyclerOptions options = new FirebaseRecyclerOptions.Builder<ModelMyOrder>()
                .setQuery(query, ModelMyOrder.class)
                .build();

        mAdapter = new FirebaseRecyclerAdapter<ModelMyOrder, MyOrderAdapter>(options) {
            @NonNull
            @Override
            public MyOrderAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                LayoutInflater inflater = LayoutInflater.from(parent.getContext());
                return new MyOrderAdapter(inflater.inflate(R.layout.item_myorder, parent, false));
            }

            @Override
            protected void onBindViewHolder(@NonNull MyOrderAdapter holder, int position, @NonNull final ModelMyOrder model) {
                holder.bindtoItemOrder(model);
            }
        };

        mAdapter.notifyDataSetChanged();
        mRecyclerView.setAdapter(mAdapter);
    }


    @Override
    public void onStart() {
        super.onStart();
        if (mAdapter != null) {
            mAdapter.startListening();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAdapter != null) {
            mAdapter.stopListening();
        }
    }

    private Query getQuery(DatabaseReference mDatabase){
        String getUserID = auth.getCurrentUser().getUid();
        Query query = mDatabase.child("Transaksi").child(getUserID);
        return query;
    }

}
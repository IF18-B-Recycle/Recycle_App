package com.example.recycle_app.Pengepul.PengepulFragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.recycle_app.Pengepul.MapsActivity;
import com.example.recycle_app.R;
import com.example.recycle_app.User.Adapter.MyOrderAdapter;
import com.example.recycle_app.User.DetailActivity;
import com.example.recycle_app.User.Model.ModelMyOrder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class PengepulHomeFragment extends Fragment {

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
        View view = inflater.inflate(R.layout.fragment_pengepul_home, container, false);

        //Untuk atuhentikasi user yang login
        auth = FirebaseAuth.getInstance();


        mDatabase = FirebaseDatabase.getInstance().getReference();

        mRecyclerView = view.findViewById(R.id.recyclerviewPengepulHomer);
        mRecyclerView.setHasFixedSize(true);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 1);
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
            public void onDataChanged() {
                super.onDataChanged();
            }

            @Override
            protected void onBindViewHolder(@NonNull MyOrderAdapter holder, int position, @NonNull final ModelMyOrder model) {
                holder.bindtoItemOrder(model);
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getContext(), MapsActivity.class);
                        intent.putExtra("longitude", model.longitude);
                        intent.putExtra("latitude", model.latitude);
                        intent.putExtra("id_transaksi",model.id_transaksi);
                        startActivity(intent);
                    }
                });
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

    private Query getQuery(DatabaseReference mDatabase) {
        String getUserID = auth.getCurrentUser().getUid();
        Query query = mDatabase.child("Transaksi").orderByChild("id_pengepul").equalTo(getUserID);
        return query;
    }

}
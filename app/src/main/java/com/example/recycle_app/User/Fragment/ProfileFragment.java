package com.example.recycle_app.User.Fragment;



import androidx.fragment.app.Fragment;
import android.content.Intent;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.example.recycle_app.User.LoginActivity;
import com.example.recycle_app.R;
import com.google.firebase.auth.FirebaseAuth;


public class ProfileFragment extends Fragment {

    Button btnLogout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        btnLogout = view.findViewById(R.id.logout);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intToMain = new Intent(getContext(), LoginActivity.class);
                startActivity(intToMain);
            }
        });

        return view;
    }
}



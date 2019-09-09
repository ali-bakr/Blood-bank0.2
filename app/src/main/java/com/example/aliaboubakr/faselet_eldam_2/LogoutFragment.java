package com.example.aliaboubakr.faselet_eldam_2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aliaboubakr.faselet_eldam_2.newlogin.LogIn;

public class LogoutFragment extends Fragment {
Intent i;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.navv_fragment_log_out,container,false);
        super.onActivityCreated(savedInstanceState);
        v.findViewById(R.id.nav_logout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              i=new Intent(getActivity(), LogIn.class);
              startActivity(i);
            }
        });

   return v;

    }
}

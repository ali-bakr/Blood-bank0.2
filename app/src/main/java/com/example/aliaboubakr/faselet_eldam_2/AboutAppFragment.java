package com.example.aliaboubakr.faselet_eldam_2;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class AboutAppFragment extends Fragment {



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.navv_fragment_about_app,container,false);
    }

  /*  public void back(View view) {
        Intent intent = new Intent(AboutAppFragment.this,MyinfoFragment.class);
        startActivity(intent);

    }*/
}

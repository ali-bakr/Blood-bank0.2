package com.example.aliaboubakr.faselet_eldam_2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.aliaboubakr.faselet_eldam_2.newlogin.LogIn;

public class SecondActivitySlider extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_slider);

        ViewPager viewPager=findViewById(R.id.viewPager);
        ImageAdapter adapter=new ImageAdapter(this);
        viewPager.setAdapter(adapter);
    }

    public void skip(View view) {
        Intent intent =new Intent(SecondActivitySlider.this,LogIn.class);
        startActivity(intent);

    }
}

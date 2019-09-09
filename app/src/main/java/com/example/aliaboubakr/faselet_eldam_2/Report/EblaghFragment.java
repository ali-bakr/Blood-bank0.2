package com.example.aliaboubakr.faselet_eldam_2.Report;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.aliaboubakr.faselet_eldam_2.R;
import com.example.aliaboubakr.faselet_eldam_2.api.Api;
import com.example.aliaboubakr.faselet_eldam_2.api.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class EblaghFragment extends Fragment {
EditText reportmessage;




    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View V= inflater.inflate(R.layout.navv_fragment_eblagh,container,false);

        reportmessage=V.findViewById(R.id.textView13);
        V.findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ///////
                setReport();
            }
        });

        return  V;
    }


private void setReport(){
    final String messag=reportmessage.getText().toString().trim();

    Retrofit retrofit= RetrofitClient.getInstant();
    Api api=retrofit.create(Api.class);
    Call<ReportResponse> call=api.UserReport("Zz9HuAjCY4kw2Ma2XaA6x7T5O3UODws1UakXI9vgFVSoY3xUXYOarHX2VH27",messag);
    call.enqueue(new Callback<ReportResponse>() {
        @Override
        public void onResponse(Call<ReportResponse> call, Response<ReportResponse> response) {
            reportmessage.setText("yes");
        }

        @Override
        public void onFailure(Call<ReportResponse> call, Throwable t) {
            reportmessage.setText("yes");
        }
    });

}

}

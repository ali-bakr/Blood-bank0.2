package com.example.aliaboubakr.faselet_eldam_2.ContactWithUs;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aliaboubakr.faselet_eldam_2.R;
import com.example.aliaboubakr.faselet_eldam_2.api.Api;
import com.example.aliaboubakr.faselet_eldam_2.api.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class CommunicateWithUsFragment extends Fragment {
 private EditText _title , _message;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


    View view=inflater.inflate(R.layout.navv_fragment_cominicate_with_us,container,false);

        super.onActivityCreated(savedInstanceState);
  _title=view.findViewById(R.id.editText2);
  _message=view.findViewById(R.id.editText4);
view.findViewById(R.id.textView22).setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        userContactUs();
    }
});
     return view;
    }

    private void userContactUs(){

        final String title=_title.getText().toString().trim();
        String message=_message.getText().toString().trim();
        if (!TextUtils.isEmpty(title)&&!TextUtils.isEmpty(message)){

            Retrofit retrofit= RetrofitClient.getInstant();
            Api api=retrofit.create(Api.class);
            Call<CommunicateWithUsResponse> call=api
                    .UserContactWithUs("Zz9HuAjCY4kw2Ma2XaA6x7T5O3UODws1UakXI9vgFVSoY3xUXYOarHX2VH27",title,message);

            call.enqueue(new Callback<CommunicateWithUsResponse>() {
                @Override
                public void onResponse(Call<CommunicateWithUsResponse> call, Response<CommunicateWithUsResponse> response) {
                 _title.setText("yes");
                }

                @Override
                public void onFailure(Call<CommunicateWithUsResponse> call, Throwable t) {
                    _title.setText("no");
                }
            });

        }

    }

}

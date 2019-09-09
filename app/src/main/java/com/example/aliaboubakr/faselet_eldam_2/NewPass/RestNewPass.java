package com.example.aliaboubakr.faselet_eldam_2.NewPass;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aliaboubakr.faselet_eldam_2.R;
import com.example.aliaboubakr.faselet_eldam_2.RestPass.RestPassResponse;
import com.example.aliaboubakr.faselet_eldam_2.api.Api;
import com.example.aliaboubakr.faselet_eldam_2.api.RetrofitClient;
import com.example.aliaboubakr.faselet_eldam_2.newlogin.LogIn;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RestNewPass extends AppCompatActivity {
EditText EDpincood,EDnewpass,EDconfirmnewpass,EDphone;
Button BUconfirmPin,BUconfirmNewpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rest_pass);

       //  b=getIntent().getExtras();
EDphone=findViewById(R.id.tv_phone);
EDpincood=findViewById(R.id.tv_pinCod);
EDnewpass=findViewById(R.id.newpass);
EDconfirmnewpass=findViewById(R.id.confirm_newpass);
BUconfirmNewpass=findViewById(R.id.confirm_pass);



        /*
        BUconfirmPin=findViewById(R.id.bu_confirm_pinCode);

        BUconfirmNewpass.setVisibility(View.INVISIBLE);
        EDnewpass.setVisibility(View.INVISIBLE);
        EDconfirmnewpass.setVisibility(View.INVISIBLE);
        EDphone.setVisibility(View.INVISIBLE);

        BUconfirmPin.setVisibility(View.VISIBLE);
        EDpincood.setVisibility(View.VISIBLE);


 BUconfirmPin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConfirmPin();

            }
        });
*/

        BUconfirmNewpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConfirmNewPass();
            }
        });
        //b=getIntent().getExtras();
       // EDphone.setText(b.getString("phone"));
      //  EDpincood.setText(b.getInt("pin_code"));

    }



 /*   public  void ConfirmPin(){
    String pin=EDpincood.getText().toString().trim();
        if (TextUtils.isEmpty(pin)) {
            EDpincood.setError("Required");}

        else {
            Retrofit retrofit= RetrofitClient.getInstant();
            Api api=retrofit.create(Api.class);

            Call<RestPassResponse> restPassResponseCall =api.RsetPass(pin);
            restPassResponseCall.enqueue(new Callback<RestPassResponse>() {
                @Override
                public void onResponse(Call<RestPassResponse> call, Response<RestPassResponse> response) {

if(response.body().getStatus()==1) {
    BUconfirmPin.setVisibility(View.INVISIBLE);
    EDphone.setVisibility(View.VISIBLE);
    EDpincood.setVisibility(View.VISIBLE);
    BUconfirmNewpass.setVisibility(View.VISIBLE);
    EDnewpass.setVisibility(View.VISIBLE);
    EDconfirmnewpass.setVisibility(View.VISIBLE);


//EDpincood.setText(b.getInt("pin_code"));
    Toast.makeText(RestNewPass.this, response.body().getMsg(), Toast.LENGTH_SHORT).show();
}

else {
    Toast.makeText(RestNewPass.this, response.body().getMsg(), Toast.LENGTH_SHORT).show();
}
                }

                @Override
                public void onFailure(Call<RestPassResponse> call, Throwable t) {
                    Toast.makeText(RestNewPass.this, "fail pin", Toast.LENGTH_SHORT).show();
                }
            });




        }

    } */





    public  void ConfirmNewPass() {
        String newpass = EDnewpass.getText().toString().trim();
        String confirmnewpass = EDconfirmnewpass.getText().toString().trim();
        String pin = EDpincood.getText().toString().trim();
        String phone = EDphone.getText().toString().trim();

        if (TextUtils.isEmpty(newpass)) {
            EDnewpass.setError("Required");
        } else if (TextUtils.isEmpty(confirmnewpass)) {
            EDconfirmnewpass.setError("Required");
        }
        else if (TextUtils.isEmpty(pin)) {
            EDpincood.setError("Required");
        }
        else if (TextUtils.isEmpty(phone)) {
            EDphone.setError("Required");
        }

        else {

            Retrofit retrofit = RetrofitClient.getInstant();
            Api api = retrofit.create(Api.class);
            Call<NewPassResponse> newPassResponseCall = api.NewPass(newpass, confirmnewpass, pin, phone);

            newPassResponseCall.enqueue(new Callback<NewPassResponse>() {
                @Override
                public void onResponse(Call<NewPassResponse> call, Response<NewPassResponse> response) {
                    if (response.body().getStatus() == 1) {

                        Toast.makeText(RestNewPass.this, response.body().getMsg(), Toast.LENGTH_LONG).show();
                        //Toast.makeText(RestNewPass.this, "success", Toast.LENGTH_SHORT).show();
                       /* new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(RestNewPass.this, LogIn.class);
                                startActivity(intent);
                                finish();
                            }

                        }, 500);
*/

                        Intent intent = new Intent(RestNewPass.this, LogIn.class);
                        startActivity(intent);

                    }

                    else { Toast.makeText(RestNewPass.this, response.body().getMsg(), Toast.LENGTH_SHORT).show(); }

                }

                @Override
                public void onFailure(Call<NewPassResponse> call, Throwable t) {
                    Toast.makeText(RestNewPass.this, "fail", Toast.LENGTH_SHORT).show();
                }
            });

        }
    }

}

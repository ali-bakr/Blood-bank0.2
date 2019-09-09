package com.example.aliaboubakr.faselet_eldam_2.newlogin;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;

import com.example.aliaboubakr.faselet_eldam_2.R;
import com.example.aliaboubakr.faselet_eldam_2.NewPass.RestNewPass;
import com.example.aliaboubakr.faselet_eldam_2.RestPass.RestPassResponse;
import com.example.aliaboubakr.faselet_eldam_2.register.SignUp;
import com.example.aliaboubakr.faselet_eldam_2.api.Api;
import com.example.aliaboubakr.faselet_eldam_2.api.RetrofitClient;
import com.example.aliaboubakr.faselet_eldam_2.nav_drawer1;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;



public class LogIn extends AppCompatActivity  {
    EditText Uname_Etxt, Pword_Etxt;
    Button Login_But, Register_But;
ProgressBar plog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
plog=findViewById(R.id.progressBarlogin);
plog.setVisibility(View.INVISIBLE);
        Uname_Etxt = findViewById(R.id.UserName_E_txt_id);
        Pword_Etxt = findViewById(R.id.PassWord__E_txt_id);
       // Pword_Etxt.setText("");

        Register_But = findViewById(R.id.RegisterBut_id);
         Login_But = findViewById(R.id.LogBut_id);



         Uname_Etxt.setText("");
         Pword_Etxt.setText("");




            Login_But.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Login_user();
                }
            });





Register_But.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        signUp();
    }
});
        findViewById(R.id.forgpass).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               forgpass();

            }
        });

 }


public  void forgpass(){
        plog.setVisibility(View.VISIBLE);
        final String u_name=Uname_Etxt.getText().toString().trim();
    if (TextUtils.isEmpty(u_name)) {
        Uname_Etxt.setError("Required");}
                else{


                    Retrofit retrofit=RetrofitClient.getInstant();
                    Api api=retrofit.create(Api.class);
                    Call<RestPassResponse> restPassResponseCall =api.RsetPass(u_name);
                    restPassResponseCall.enqueue(new Callback<RestPassResponse>() {
                        @Override
                        public void onResponse(Call<RestPassResponse> call, Response<RestPassResponse> response) {
                            plog.setVisibility(View.GONE);
                       if ( response.body().getStatus()==1) {


                      // Toast.makeText(LogIn.this, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                           Intent intent = new Intent(LogIn.this, RestNewPass.class);
                           Toast.makeText(LogIn.this, response.body().getRestPassData().getPinCodeForTest().toString(), Toast.LENGTH_LONG).show();

                           sendNotification("PIN Code",response.body().getRestPassData().getPinCodeForTest().toString());
                       // Intent intent_pin = new Intent(getApplicationContext(), RestNewPass.class);
                         //  intent_pin.putExtra("pin_cod", response.body().getRestPassData().getPinCodeForTest());
                          // intent_pin.putExtra("phone", u_name);
                          // startActivity(intent_pin);



                           startActivity(intent);
                       }
                       else {
                           Toast.makeText(LogIn.this, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                       }
                        }

                        @Override
                        public void onFailure(Call<RestPassResponse> call, Throwable t) {

                            Toast.makeText(LogIn.this, "fail", Toast.LENGTH_SHORT).show();
                        }
                    });
    }


}

    private void sendNotification(String title, String body) {
        Intent i = new Intent(this, RestNewPass.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pi = PendingIntent.getActivity(this,
                0 /* Request code */,
                i,
                PendingIntent.FLAG_ONE_SHOT);

        Uri sound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,
               "chaneled")
                .setSmallIcon(R.drawable.logo_image_in_app)
                .setContentTitle(title)
                .setContentText(body)
                .setAutoCancel(true)
                .setSound(sound)
                .setContentIntent(pi);

        NotificationManager manager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        manager.notify(0, builder.build());
    }

    public void signUp() {
        Intent intent = new Intent(LogIn.this, SignUp.class);
        startActivity(intent);}

    //........................................................................
    /*public void GoSignUp(View view) {
        Intent intent = new Intent(LogIn.this, SignUp.class);
        startActivity(intent);

    }*/
//public void Login(View view) {
//}

    public void Login_user() {

        String phone, Pword_Etxt_string;
        phone = Uname_Etxt.getText().toString().trim();
        Pword_Etxt_string = Pword_Etxt.getText().toString().trim();

        if ( TextUtils.isEmpty(Uname_Etxt.getText().toString())){
            Uname_Etxt.setError("Required");}
        else if ( TextUtils.isEmpty(Pword_Etxt.getText().toString())){
            Pword_Etxt.setError("Required");}
        else {
            plog.setVisibility(View.VISIBLE);
            Retrofit retrofit = RetrofitClient.getInstant();
            Api api = retrofit.create(Api.class);
            Call<LoginModel> login_modleCall = api.UserLogin(phone, Pword_Etxt_string);
            login_modleCall.enqueue(new Callback<LoginModel>() {
                @Override
                public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {
                    plog.setVisibility(View.VISIBLE);
                    if (response.body().getStatus()==1) {
                        Toast.makeText(LogIn.this, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                       // Toast.makeText(LogIn.this, "success", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LogIn.this, nav_drawer1.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(LogIn.this, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<LoginModel> call, Throwable t) {
                    Toast.makeText(LogIn.this, "login_fail", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
Pword_Etxt.setText("");
plog.setVisibility(View.INVISIBLE);
    }
}

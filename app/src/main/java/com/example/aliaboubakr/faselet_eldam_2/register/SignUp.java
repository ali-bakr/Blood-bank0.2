package com.example.aliaboubakr.faselet_eldam_2.register;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.aliaboubakr.faselet_eldam_2.R;
import com.example.aliaboubakr.faselet_eldam_2.api.Api;
import com.example.aliaboubakr.faselet_eldam_2.api.RetrofitClient;
import com.example.aliaboubakr.faselet_eldam_2.nav_drawer1;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SignUp extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText name, email, birth_date, city_id, phone, donation_last_date, password, password_confirmation, blood_type;
    String S_name, S_email, S_birth_date, S_city_id, S_phone, S_donation_last_date, S_password, S_password_confirmation, S_blood_type;
    Button register;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Toolbar toolbar1 = findViewById(R.id.toolbar);
        toolbar1.setTitle("إنـشــاء حــســاب جــديــد               ");
        setSupportActionBar(toolbar1);





        Spinner spinner1 = findViewById(R.id.ProvincesSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Provinces, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(this);


        Spinner spinner2 = findViewById(R.id.CitiesSpinner);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.Cities, android.R.layout.simple_spinner_item);

        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //spinner2.setAdapter(adapter);
        //spinner2.setOnItemSelectedListener(this);

        name = findViewById(R.id.reg_name_Edt_ID);
        email = findViewById(R.id.reg_email_Edt_ID);
        birth_date = findViewById(R.id.reg_BirthDay_Edt_ID);
        phone = findViewById(R.id.reg_phone_Edt_ID);
        donation_last_date = findViewById(R.id.reg_donation_last_date_Edt_ID);
        password = findViewById(R.id.reg_password_Edt_ID);
        password_confirmation = findViewById(R.id.reg_confirm_password_Edt_ID);
        blood_type = findViewById(R.id.reg_blood_type_Edt_ID);
        register = findViewById(R.id.register_But_id);

register.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        CreatAccount();
    }
});

    }




    public void CreatAccount() {
        S_name = name.getText().toString().trim();
        S_city_id = city_id.getText().toString().trim();
        S_email = email.getText().toString().trim();
        S_birth_date = birth_date.getText().toString().trim();
        S_phone = phone.getText().toString().trim();
        S_donation_last_date = donation_last_date.getText().toString().trim();
        S_password = password.getText().toString().trim();
        S_password_confirmation = password_confirmation.getText().toString().trim();
        S_blood_type = blood_type.getText().toString().trim();
        city_id.setText("1");

        if (TextUtils.isEmpty(S_name)) {
            name.setError("Required");

        } else if (TextUtils.isEmpty(S_email)) {
            email.setError("Required");

        } else if (TextUtils.isEmpty(S_birth_date)) {
            birth_date.setError("Required");
        } else if (TextUtils.isEmpty(S_phone)) {
            phone.setError("Required");
        } else if (TextUtils.isEmpty(S_donation_last_date)) {
            donation_last_date.setError("Required");
        } else if (TextUtils.isEmpty(S_password)) {
            password.setError("Required");
        } else if (TextUtils.isEmpty(S_password_confirmation)) {
            password_confirmation.setError("Required");
        } else if (TextUtils.isEmpty(S_blood_type)) {
            blood_type.setError("Required");
        } else {
            Retrofit retrofit = RetrofitClient.getInstant();
            Api api = retrofit.create(Api.class);
            Call<RegisterResponse> registerResponseCall = api.UserRegister(S_name, S_email, S_birth_date,
                    "1", S_phone, S_donation_last_date, S_password, S_password_confirmation, S_blood_type);
            registerResponseCall.enqueue(new Callback<RegisterResponse>() {
                @Override
                public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                    if (response.body().getStatus() == 1) {
                       Toast.makeText(SignUp.this, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(SignUp.this, nav_drawer1.class);
                        startActivity(intent);
                    }
                    else {Toast.makeText(SignUp.this, response.body().getMsg(), Toast.LENGTH_SHORT).show();}

                }

                @Override
                public void onFailure(Call<RegisterResponse> call, Throwable t) {
                    Toast.makeText(SignUp.this, "bad", Toast.LENGTH_SHORT).show();
                    Log.e("hi", t.getMessage());
                }
            });


        }


    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String text = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(adapterView.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


}
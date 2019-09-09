package com.example.aliaboubakr.faselet_eldam_2.MyInformation;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.aliaboubakr.faselet_eldam_2.R;
import com.example.aliaboubakr.faselet_eldam_2.api.Api;
import com.example.aliaboubakr.faselet_eldam_2.api.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MyinfoFragment extends Fragment {
EditText name,email,birthdate,phone,donLastdate,isactive,password,confirmpassword,bloodtybe,city;
ProgressBar pinfo;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=  inflater.inflate(R.layout.navv_fragment_myinfo,container,false);


birthdate=v.findViewById(R.id.tvInfodate);
        name=v.findViewById(R.id.tvInfoname);
        email=v.findViewById(R.id.tvInfoemail);
        phone=v.findViewById(R.id.tvInfophone);
        donLastdate=v.findViewById(R.id.tvInfolastdate);
        password=v.findViewById(R.id.tv_password);
        confirmpassword=v.findViewById(R.id.tv_confirmpassword);
        bloodtybe=v.findViewById(R.id.tvInfobloodtype2);
        isactive=v.findViewById(R.id.tvIsactive);
        city=v.findViewById(R.id.tvcity);

        pinfo=v.findViewById(R.id.progressBarinfo);
        pinfo.setVisibility(View.INVISIBLE);
v.findViewById(R.id.buEditinfo).setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        password.setVisibility(View.VISIBLE);
        confirmpassword.setVisibility(View.VISIBLE);
        EditMyInfo();
    }
});

        GetInfo();

        return v;



    }





    public  void EditMyInfo (){

        String _name =name.getText().toString().trim();
        String _email =email.getText().toString().trim();
        String _birthdate =birthdate.getText().toString().trim();
        String _phone =phone.getText().toString().trim();
        String _donLastdate =donLastdate.getText().toString().trim();
        String _pass =password.getText().toString().trim();
        String _confirmpass =confirmpassword.getText().toString().trim();
        //String _isactive =isactive.getText().toString().trim();
       // String _pin =pin.getText().toString().trim();
      String _bloodtybe =bloodtybe.getText().toString().trim();

        if ( TextUtils.isEmpty(_name)){
            name.setError("Required");

        }else if (TextUtils.isEmpty(_email)){
            email.setError("Required");

        }
        else if (TextUtils.isEmpty(_birthdate)){
            birthdate.setError("Required");}

        else if (TextUtils.isEmpty(_phone)){
            phone.setError("Required");}

        else if (TextUtils.isEmpty(_donLastdate))
        { donLastdate.setError("Required");}

        else if (TextUtils.isEmpty(_pass))
        {password.setError("Required");}

        else if (TextUtils.isEmpty(_confirmpass))
        {   confirmpassword.setError("Required");}

        else if (TextUtils.isEmpty(_bloodtybe))
        {    bloodtybe.setError("Required");}

else{

            Retrofit retrofit= RetrofitClient.getInstant();
            Api api=retrofit.create(Api.class);
            Call <MyInfoModel> myInfoModelCall=api.myinfo(_name,_email,_birthdate,"1", _phone
                    ,_donLastdate,_pass,_confirmpass
                    ,"1","W4mx3VMIWetLcvEcyF554CfxjZHwdtQldbdlCl2XAaBTDIpNjKO1f7CHuwKl");

            myInfoModelCall.enqueue(new Callback<MyInfoModel>() {
                @Override
                public void onResponse(Call<MyInfoModel> call, Response<MyInfoModel> response) {

                   name.setText("success");
                }

                @Override
                public void onFailure(Call<MyInfoModel> call, Throwable t) {

                }
            });




        }



    }


    public void GetInfo(){

pinfo.setVisibility(View.VISIBLE);



            Retrofit retrofit= RetrofitClient.getInstant();
            Api api=retrofit.create(Api.class);
            Call <MyInfoModel> myInfoModelCall=api.myinfo("W4mx3VMIWetLcvEcyF554CfxjZHwdtQldbdlCl2XAaBTDIpNjKO1f7CHuwKl");

            myInfoModelCall.enqueue(new Callback<MyInfoModel>() {
                @Override
                public void onResponse(Call<MyInfoModel> call, Response<MyInfoModel> response) {
pinfo.setVisibility(View.GONE);
                  name.setText( "name : "+response.body().getMyInfoData().getClient().getName());

                    email.setText( "email : "+response.body().getMyInfoData().getClient().getEmail());
                    birthdate.setText("birthday date : "+ response.body().getMyInfoData().getClient().getBirthDate());
                    phone.setText( "phone : "+response.body().getMyInfoData().getClient().getPhone());
                    donLastdate.setText("last donation date : "+ response.body().getMyInfoData().getClient().getDonationLastDate());

                    isactive.setText("is active : "+ response.body().getMyInfoData().getClient().getIsActive());
                  //  pin.setText( response.body().getMyInfoData().getClient().getPinCode());
                    bloodtybe.setText( "blode type : "+response.body().getMyInfoData().getClient().getBloodType().getName());
                    city.setText("city : "+ response.body().getMyInfoData().getClient().getCity().getGovernorate().getName());

                    password.setVisibility(View.GONE);
                    confirmpassword.setVisibility(View.GONE);
                    //password.setText(response.body().getMyInfoData().getClient().g);
                    //  name.setText( response.body().getMyInfoData().getClient().getBirthDate());


                }

                @Override
                public void onFailure(Call<MyInfoModel> call, Throwable t) {

                }
            });








    }


}

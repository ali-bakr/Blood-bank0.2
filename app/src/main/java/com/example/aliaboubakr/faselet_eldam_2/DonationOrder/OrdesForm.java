package com.example.aliaboubakr.faselet_eldam_2.DonationOrder;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aliaboubakr.faselet_eldam_2.R;
import com.example.aliaboubakr.faselet_eldam_2.api.Api;
import com.example.aliaboubakr.faselet_eldam_2.api.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class OrdesForm extends Fragment  {

EditText _patient_name,_patient_age,_phone,_hospital_address,_hospital_name,_bags_num,_notes,_blood_type;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.order_form,container,false);
        super.onActivityCreated(savedInstanceState);



        _patient_name=v.findViewById(R.id.patient_name);
        _patient_age=v.findViewById(R.id.patient_age);
        _phone=v.findViewById(R.id.phone);
        _hospital_address=v.findViewById(R.id.hospital_address);
        _hospital_name=v.findViewById(R.id.hospital_name);
        _bags_num=v.findViewById(R.id.bags_num);
        _notes=v.findViewById(R.id.notes);
        _blood_type=v.findViewById(R.id.blood_type);


v.findViewById(R.id.SenOrder).setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        SendOrder();
    }
});

        return v;
    }

    private void SendOrder() {

        String patient_name=_patient_name.getText().toString().trim();
        String patient_age=_patient_age.getText().toString().trim();
        String phone=_phone.getText().toString().trim();
        String hospital_address=_hospital_address.getText().toString().trim();
        String hospital_name=_hospital_name.getText().toString().trim();
        String bags_num=_bags_num.getText().toString().trim();
        String notes=_notes.getText().toString().trim();
        String blood_type=_blood_type.getText().toString().trim();



        if ( TextUtils.isEmpty(patient_name)){
            _patient_name.setError("Required");

        }else if (TextUtils.isEmpty(patient_age)){
            _patient_age.setError("Required");
            if ( TextUtils.isEmpty(patient_name)){
                _patient_name.setError("Required");

            }else if (TextUtils.isEmpty(patient_age)){
                _patient_age.setError("Required");

            }
            else if (TextUtils.isEmpty(hospital_address)){
                _hospital_address.setError("Required");}

            else if (TextUtils.isEmpty(phone)){
                _phone.setError("Required");}

            else if (TextUtils.isEmpty(hospital_name))
            { _hospital_name.setError("Required");}

            else if (TextUtils.isEmpty(bags_num))
            {_bags_num.setError("Required");}

            else if (TextUtils.isEmpty(notes))
            {   _notes.setError("Required");}

            else if (TextUtils.isEmpty(blood_type))
            {    _blood_type.setError("Required");}
        }
        else if (TextUtils.isEmpty(hospital_address)){
            _hospital_address.setError("Required");}

        else if (TextUtils.isEmpty(phone)){
            _phone.setError("Required");}

        else if (TextUtils.isEmpty(hospital_name))
        { _hospital_name.setError("Required");}

        else if (TextUtils.isEmpty(bags_num))
        {_bags_num.setError("Required");}

        else if (TextUtils.isEmpty(notes))
        {   _notes.setError("Required");}

        else if (TextUtils.isEmpty(blood_type))
        {    _blood_type.setError("Required");}

else {


            Retrofit retrofit= RetrofitClient.getInstant();
            Api api=retrofit.create(Api.class);

            Call<OrderRrsponse> orderRrsponseCall=api.UserRequersDonation("Zz9HuAjCY4kw2Ma2XaA6x7T5O3UODws1UakXI9vgFVSoY3xUXYOarHX2VH27",patient_name,patient_age,blood_type,bags_num
                    ,hospital_name,hospital_address,"1",phone,notes,"30.7541","31.7655");
            orderRrsponseCall.enqueue(new Callback<OrderRrsponse>() {
                @Override
                public void onResponse(Call<OrderRrsponse> call, Response<OrderRrsponse> response) {

                    Toast.makeText(getActivity(), response.body().getMsg(), Toast.LENGTH_SHORT).show();

                }

                @Override
                public void onFailure(Call<OrderRrsponse> call, Throwable t) {
                    Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });




        }



    }

}

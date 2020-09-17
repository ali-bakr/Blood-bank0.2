package com.example.aliaboubakr.faselet_eldam_2.OrdersDetals;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aliaboubakr.faselet_eldam_2.R;
import com.example.aliaboubakr.faselet_eldam_2.api.Api;
import com.example.aliaboubakr.faselet_eldam_2.api.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class OrdersDetals extends Fragment {
    String phnum,apitokin="W4mx3VMIWetLcvEcyF554CfxjZHwdtQldbdlCl2XAaBTDIpNjKO1f7CHuwKl";
    public TextView name,age,bagsnom,notes,city,hosname,hosaddres,phone,type;
    Intent detals;
//   ProgressBar pDetals;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.donation_detals,container,false);

//pDetals=v.findViewById(R.id.progressBardetals);

        name=v.findViewById(R.id.detalsname);
        hosaddres=v.findViewById(R.id.detalshosadrees);
        hosname=v.findViewById(R.id.detalshosname);

        age=v.findViewById(R.id.detalsage);
        bagsnom=v.findViewById(R.id.detalsbugsnom);

        notes=v.findViewById(R.id.detalsnotes);
        city=v.findViewById(R.id.detalscity);

        // email=v.findViewById(R.id.detalsemal);
        phone=v.findViewById(R.id.detalsphone);
        type=v.findViewById(R.id.detalstype);

        v.findViewById(R.id.detalscalll).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    detals = new Intent(Intent.ACTION_CALL);
                    detals.setData(Uri.parse("tel:"+phnum));
                    //here the word 'tel' is important for making a call...
                    getActivity().startActivity(detals);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(getActivity(), "Error in your phone call"+e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });
        getOrderDetals();

        return v;
    }

    public void getOrderDetals(){
    //    pDetals.setVisibility(View.VISIBLE);
        Retrofit retrofit= RetrofitClient.getInstant();
        Api api=retrofit.create(Api.class);

        Call<OrdersDetalsModel> postDetalsModelCall=api.getallOrdersDetals(apitokin,661);


        postDetalsModelCall.enqueue(new Callback<OrdersDetalsModel>() {
            @Override
            public void onResponse(Call<OrdersDetalsModel> call, Response<OrdersDetalsModel> response) {
//pDetals.setVisibility(View.GONE);
                if (response.body().getStatus()==1)
                {
                    name.setText("اسـم المريض : "+response.body().getOrdersDetalsData().getPatientName());
                    hosaddres.setText("عنوان المـستـشفي : "+response.body().getOrdersDetalsData().getHospitalAddress());
                    hosname.setText("اسم المستشفي : "+response.body().getOrdersDetalsData().getHospitalName());
                    age.setText("السن : "+response.body().getOrdersDetalsData().getPatientAge());
                    bagsnom.setText("عدد الاكياس : "+response.body().getOrdersDetalsData().getBagsNum());
                    notes.setText("ملاحظات : "+response.body().getOrdersDetalsData().getNotes());
                    city.setText("المدينة : "+response.body().getOrdersDetalsData().getCity().getName());
                    type.setText("الفصيلة: "+response.body().getOrdersDetalsData().getBloodType().getName());
                    phone.setText("الهاتف : "+response.body().getOrdersDetalsData().getPhone());
                    phnum=response.body().getOrdersDetalsData().getPhone();


                    Toast.makeText(getActivity(),response.body().getMsg(), Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getActivity(),response.body().getMsg(), Toast.LENGTH_SHORT).show();
                }



            }

            @Override
            public void onFailure(Call<OrdersDetalsModel> call, Throwable t) {
                Toast.makeText(getActivity(),t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }


}

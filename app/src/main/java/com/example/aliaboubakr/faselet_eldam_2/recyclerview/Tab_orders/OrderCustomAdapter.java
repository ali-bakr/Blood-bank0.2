package com.example.aliaboubakr.faselet_eldam_2.recyclerview.Tab_orders;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aliaboubakr.faselet_eldam_2.OrdersDetals.OrdersDetals;
import com.example.aliaboubakr.faselet_eldam_2.R;

import java.util.ArrayList;
import java.util.List;


public class OrderCustomAdapter extends RecyclerView.Adapter<OrderCustomAdapter.OrderViewHolder> {
String num;
    Intent my_callIntent;
    private Context ordContext;


    ArrayList<OrdersModel.Datum> data;
    public OrderCustomAdapter(Context ordContext,ArrayList<OrdersModel.Datum> data) {
        this.data=data;
        this.ordContext=ordContext;
    }


    public static class OrderViewHolder extends RecyclerView.ViewHolder{

        public TextView name_Tv_orders_rv;
        public TextView hospital_Tv_orders_rv;
        public TextView city_Tv_orders_rv;
        public TextView type_shap_Tv_orders_rv;
        public Button call_Bu_orders_rv;
        public Button detalis_But_orders_rv;

        public OrderViewHolder(@NonNull View itemView) {
            super(itemView);
            name_Tv_orders_rv = itemView.findViewById(R.id.name_Tv_orders_rv);
            hospital_Tv_orders_rv =itemView.findViewById(R.id. hospital_Tv_orders_rv);
            city_Tv_orders_rv =itemView.findViewById(R.id. city_Tv_orders_rv);
            type_shap_Tv_orders_rv = itemView.findViewById(R.id.type_shap_Tv_orders_rv);
            call_Bu_orders_rv = itemView.findViewById(R.id.call_Bu_orders_rv);
            detalis_But_orders_rv = itemView.findViewById(R.id.detalis_But_orders_rv);

        }
    }


    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.order_item,viewGroup,false);
        OrderViewHolder orderViewHolder=new OrderViewHolder(v);
        return orderViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final OrderViewHolder orderViewHolder, int i) {
 OrdersModel.Datum ordersRecyclerView =data.get(i);

    orderViewHolder.name_Tv_orders_rv.setText(" الاسم : "+data.get(i).getPatientName());
    orderViewHolder.city_Tv_orders_rv.setText(" المدينة : "+data.get(i).getCity().getName());
    orderViewHolder.type_shap_Tv_orders_rv.setText(data.get(i).getBloodType().getName());
     orderViewHolder.hospital_Tv_orders_rv.setText(" المستشفي : "+data.get(i).getHospitalName());


        num=data.get(i).getClient().getPhone();

        orderViewHolder.detalis_But_orders_rv.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //call the get method that has been handeld in OrdersRecyclerView class ;
            AppCompatActivity activity = (AppCompatActivity) v.getContext();
            OrdersDetals ordersDetals=new OrdersDetals()
;            activity.getSupportFragmentManager().beginTransaction().replace(R.id.frag_container, ordersDetals).addToBackStack(null).commit();



        }
    });
    orderViewHolder.call_Bu_orders_rv.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
       //     call the get method that has been handeld in OrdersRecyclerView class ;
            try {
                 my_callIntent = new Intent(Intent.ACTION_CALL);
                my_callIntent.setData(Uri.parse("tel:"+num));
                //here the word 'tel' is important for making a call...
                ordContext.startActivity(my_callIntent);
            } catch (ActivityNotFoundException e) {
                Toast.makeText(ordContext.getApplicationContext(), "Error in your phone call"+e.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
    });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }






}

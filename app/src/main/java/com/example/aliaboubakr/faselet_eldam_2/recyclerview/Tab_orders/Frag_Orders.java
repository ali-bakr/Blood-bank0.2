package com.example.aliaboubakr.faselet_eldam_2.recyclerview.Tab_orders;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.aliaboubakr.faselet_eldam_2.R;
import com.example.aliaboubakr.faselet_eldam_2.api.Api;
import com.example.aliaboubakr.faselet_eldam_2.api.RetrofitClient;
import com.example.aliaboubakr.faselet_eldam_2.recyclerview.EndlessRecyclerViewScrollListener;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Frag_Orders extends Fragment {


int pages=1;
  String apitokin="W4mx3VMIWetLcvEcyF554CfxjZHwdtQldbdlCl2XAaBTDIpNjKO1f7CHuwKl";
    private RecyclerView rv_orders;
    private  OrderCustomAdapter order_adapter;
    private   LinearLayoutManager llm;
   private ArrayList<OrdersModel.Datum> arrayList;

private ProgressBar pOrders;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

       View v=inflater.inflate(R.layout.fragment_frag__orders,container,false);
        super.onActivityCreated(savedInstanceState);

        pOrders=v.findViewById(R.id.progressBarOrders);
        pOrders.setVisibility(View.INVISIBLE);
        rv_orders=v.findViewById(R.id.rv_orderss);
       rv_orders.setHasFixedSize(true);
        return  v;
    }

    public void getorders(int p){
pOrders.setVisibility(View.VISIBLE);
        Retrofit retrofit= RetrofitClient.getInstant();
        Api api=retrofit.create(Api.class);
        Call<OrdersModel> ordersModelCall=api.getallOrdersRequest(apitokin,p);
        ordersModelCall.enqueue(new Callback<OrdersModel>() {
            @Override
            public void onResponse(Call<OrdersModel> call, Response<OrdersModel> response) {
pOrders.setVisibility(View.GONE);
            if (response.body().getStatus()==1){

              //  pages=response.body().getOrdersData().getCurrentPage();
                arrayList.addAll(response.body().getOrdersData().getData());
                rv_orders.setAdapter(order_adapter);
                order_adapter.notifyItemRangeInserted( order_adapter.getItemCount(),arrayList.size());
                }
            }

            @Override
            public void onFailure(Call<OrdersModel> call, Throwable t) {
            }
        });

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        arrayList=new ArrayList<>();
        llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
       rv_orders.setItemAnimator(new DefaultItemAnimator());
        rv_orders.setLayoutManager(llm);
        order_adapter = new OrderCustomAdapter(getContext(), arrayList);
        //rv_orders.setAdapter( order_adapter );
        rv_orders.addOnScrollListener(new EndlessRecyclerViewScrollListener(llm) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                pages++;
                getorders(pages);
            }
        });
     getorders(pages);

    }
}
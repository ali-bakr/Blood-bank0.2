package com.example.aliaboubakr.faselet_eldam_2.PostDetals;

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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aliaboubakr.faselet_eldam_2.OrdersDetals.OrdersDetalsModel;
import com.example.aliaboubakr.faselet_eldam_2.R;
import com.example.aliaboubakr.faselet_eldam_2.api.Api;
import com.example.aliaboubakr.faselet_eldam_2.api.RetrofitClient;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class PostDtals extends Fragment {
String apitokin="Zz9HuAjCY4kw2Ma2XaA6x7T5O3UODws1UakXI9vgFVSoY3xUXYOarHX2VH27";
int pagepostid=22,page=1;
TextView title,caption;
  ImageView postimage;
   @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.post_detals, container, false);
        super.onActivityCreated(savedInstanceState);

        title=v.findViewById(R.id.postdetaltitle);
        caption=v.findViewById(R.id.postdetalcaption);
        postimage=v.findViewById(R.id.detalepostimage);
       getpostdetals();

        return v;

    }
 public  void getpostdetals(){

        Retrofit retrofit=RetrofitClient.getInstant();
        Api api =retrofit.create(Api.class);
        Call <PostDetalsModel> postDetalsModelCall=api.getallArticlesdetals(  apitokin,pagepostid,page);
postDetalsModelCall.enqueue(new Callback<PostDetalsModel>() {
    @Override
    public void onResponse(Call<PostDetalsModel> call, Response<PostDetalsModel> response) {
        if (response.body().getStatus()==1){
            title.setText(response.body().getPostDetalsData().getCategory().getName());
            caption.setText(response.body().getPostDetalsData().getContent());
            Picasso.get().load(response.body().getPostDetalsData().getThumbnailFullPath()).into(postimage);
        }
    }

    @Override
    public void onFailure(Call<PostDetalsModel> call, Throwable t) {

    }
});
 }

}
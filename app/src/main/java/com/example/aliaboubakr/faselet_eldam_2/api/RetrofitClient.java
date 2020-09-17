package com.example.aliaboubakr.faselet_eldam_2.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
/*
    private static
    private static RetrofitClient mInstance;
    private Retrofit retrofit;

    public RetrofitClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();
    }

    public static synchronized RetrofitClient getInstance() {
        if (mInstance == null) {
            mInstance = new RetrofitClient();
        }
        return mInstance;
    }

???????????????????????
public class RetrofitClient {
    public static Retrofit getInstant(){
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl("http://ipda3.com/blood-bank/api/v1/");
        builder.addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();

        return retrofit;
    }
}
????????????????????
    public Api getApi() {
        return retrofit.create(Api.class);
    }
}

public class RetrofitClient{

private  static  final  String url="http://ipda3.com/blood-bank/api/v1/";

private  static Retrofit retrofit=null;

    public static Retrofit getclient() {
        if (retrofit==null){
            retrofit=new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
            }
        return retrofit;
    }
    public static synchronized RetrofitClient getInstance() {
        if (retrofit == null) {
            mInstance = new RetrofitClient();
*/



        public static Retrofit getInstant(){
            Retrofit.Builder builder = new Retrofit.Builder();
            builder.baseUrl("http://ipda3-tech.com/blood-bank/api/v1/");
            builder.addConverterFactory(GsonConverterFactory.create());
            Retrofit retrofit = builder.build();

            return retrofit;
        }


}




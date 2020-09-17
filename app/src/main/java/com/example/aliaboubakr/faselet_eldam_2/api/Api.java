package com.example.aliaboubakr.faselet_eldam_2.api;

import com.example.aliaboubakr.faselet_eldam_2.ContactWithUs.CommunicateWithUsResponse;
import com.example.aliaboubakr.faselet_eldam_2.DonationOrder.OrderRrsponse;
import com.example.aliaboubakr.faselet_eldam_2.MyInformation.MyInfoModel;
import com.example.aliaboubakr.faselet_eldam_2.NewPass.NewPassResponse;
import com.example.aliaboubakr.faselet_eldam_2.OrdersDetals.OrdersDetalsModel;
import com.example.aliaboubakr.faselet_eldam_2.PostDetals.PostDetalsModel;
import com.example.aliaboubakr.faselet_eldam_2.Report.ReportResponse;
import com.example.aliaboubakr.faselet_eldam_2.RestPass.RestPassResponse;
import com.example.aliaboubakr.faselet_eldam_2.newlogin.LoginModel;
import com.example.aliaboubakr.faselet_eldam_2.recyclerview.Tab_articles.ArticlesModel;
import com.example.aliaboubakr.faselet_eldam_2.recyclerview.Tab_orders.OrdersModel;
import com.example.aliaboubakr.faselet_eldam_2.register.RegisterResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Api {

    @FormUrlEncoded
    @POST("login")
    Call<LoginModel> UserLogin(
            @Field("phone") String email,@Field("password") String password

    );


    @FormUrlEncoded
    @POST("signup")
    Call<RegisterResponse> UserRegister(
            @Field("name") String S_name,@Field("email") String S_email,
            @Field("birth_date") String S_birth_date,@Field("city_id") int S_city_id,
            @Field("phone") String S_phone,@Field("donation_last_date") String S_donation_last_date,
            @Field("password") String S_password,@Field("password_confirmation") String Spassword_confirmation,
            @Field("blood_type_id") int S_blood_type

    );

    @FormUrlEncoded
    @POST("contact")
    Call<CommunicateWithUsResponse> UserContactWithUs(
            @Field("api_token") String api_token ,@Field("title")String title,@Field("message") String message);


    @FormUrlEncoded
    @POST("report")
    Call<ReportResponse> UserReport(@Field("api_token") String api_token,@Field("message") String message);




    @FormUrlEncoded
    @POST("donation-request/create")
    Call<OrderRrsponse> UserRequersDonation( @Field("api_token") String api_token,@Field("patient_name") String patient_name,
                                          @Field("patient_age") String patient_age,@Field("blood_type") String blood_type,
                                          @Field("bags_num") String bags_num,@Field("hospital_name") String hospital_name,
                                          @Field("hospital_address") String hospital_address,@Field("city_id") String city_id,
                                          @Field("phone") String phone,@Field("notes") String notes ,
                                          @Field("longitude") String longitude,@Field("latitude")String latitude );


 @FormUrlEncoded
    @POST("reset-password")
    Call<RestPassResponse> RsetPass(@Field("phone")String phone);


 @FormUrlEncoded
    @POST("new-password")
    Call<NewPassResponse>NewPass(@Field("password") String password,@Field("password_confirmation") String password_confirmation,
                                 @Field("pin_code")String pin_code,@Field("phone")String phone);



//edit profil data
    @FormUrlEncoded
    @POST("profile")
    Call<MyInfoModel> myinfo(@Field("name") String name,@Field("email") String email, @Field("birth_date") String birth_date,
                             @Field("city_id") String city_id,@Field("phone") String _phone,
                             @Field("donation_last_date") String donation_last_date,@Field("password") String password,
                             @Field("password_confirmation") String password_confirmation,@Field("blood_type_id") String blood_type_id,
                             @Field("api_token") String api_token);
//get profile data
    @FormUrlEncoded
    @POST("profile")
    Call<MyInfoModel> myinfo(@Field("api_token") String api_token);




    @GET("posts")
    Call<ArticlesModel>getallArticles(@Query("api_token") String apitoken,@Query("page") int page);





    @GET("donation-requests")
    Call<OrdersModel>getallOrdersRequest(@Query("api_token") String apitoken, @Query("page") int page);



    @GET("donation-request")
    Call<OrdersDetalsModel>getallOrdersDetals(@Query("api_token") String apitoken, @Query("donation_id") int page);


    @GET("post")
    Call<PostDetalsModel>getallArticlesdetals(@Query("api_token") String apitoken,@Query("post_id") int pagepost_id, @Query("page") int page);



}

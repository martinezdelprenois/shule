package com.example.marto.my_school_revierwer_4;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

/**
 * Created by marto on 31-Mar-17.
 */

public interface RestAPI {

    @FormUrlEncoded
    @POST("/MY_SCHOOL_REVIEWER/Institutions_signup.php")
    public void register_school(

            @Field("Institution_Name") String institution,
            @Field("Personal_Email") String Email,
            @Field("Password") String pass,
            @Field("Website_Link") String website,
            @Field("Institution_Index_Number") String index,
            @Field("Education_level") String level,
            @Field("Category") String category,
            Callback<Response> callback

    );

    @FormUrlEncoded
    @POST("/MY_SCHOOL_REVIEWER/Individuals_signup.php")
    public void register_user(
            @Field("First_Name") String first_name,
            @Field("Last_Name") String last_name,
            @Field("User_Name") String user,
            @Field("Email") String Email,
            @Field("Password") String pass,
            Callback<Response>callback
    );

    @FormUrlEncoded
    @POST("/MY_SCHOOL_REVIEWER/individuals_login.php")
    public void individual_login(
            @Field("Email") String Email,
            @Field("Password")String pass,
            Callback<Response>callback

    );

    @FormUrlEncoded
    @POST("/MY_SCHOOL_REVIEWER/institutions_login.php")
    public void institutions_login(
            @Field("Personal_Email") String email,
            @Field("Password") String pass,
            @Field("Institution_Index_Number") String index,
            Callback<Response>callback
    );
}

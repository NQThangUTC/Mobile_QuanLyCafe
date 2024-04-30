package com.example.qlquancaffee.retrofit;

import com.example.qlquancaffee.Object.Account;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface AccountInterface {
    //login
//    @GET("/account/userlogin/{user}")
//    Call<Account> getAccount(@Path("user") String user);
//    @GET("account/getbyuser")
//    Call<Account> getInfoByUser(@Query("UserName") String UserName,@Query("PassWord")String passWord);
    @GET("/account/login")
    Call<Account> getAccountForLogin(@Query("UserName") String user,@Query("PassWord")String pass);
    //Dang ki
    @POST("/account/insert")
    Call<Account> createAcc(@Body HashMap<String,Object> request);
//    Call<Account> createAcc(@Query("User") String user,@Query("Display")String display,@Query("Pass")String pass,@Query("RePass")String repass,@Query("Type")int type);
}

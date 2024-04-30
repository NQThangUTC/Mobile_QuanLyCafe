package com.example.qlquancaffee.retrofit;

import com.example.qlquancaffee.Object.Account;

public class AccountUtils {
    public static final String BASE_URL="http://192.168.1.8:3333/";
    public static AccountInterface getAccountService(){
        return RetrofitClient.getClient(BASE_URL).create(AccountInterface.class);
    }
}

package com.example.qlquancaffee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.qlquancaffee.Object.Account;
import com.example.qlquancaffee.retrofit.AccountInterface;
import com.example.qlquancaffee.retrofit.AccountUtils;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {
    EditText textTK,textMK;
    Button btDN,btDK;
    AccountInterface accountInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitWidgets();
        getPermission();
        accountInterface = AccountUtils.getAccountService();
        btDN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = textTK.getText().toString();
                String pass = textMK.getText().toString();
                accountInterface.getAccountForLogin(textTK.getText().toString(),textMK.getText().toString()).enqueue(new Callback<Account>() {
                    @Override
                    public void onResponse(Call<Account> call, Response<Account> response) {
                        if (response.isSuccessful()){
                            Account account = response.body();
                            if (account != null && !account.getDisplayName().equals("")&&!account.getUserName().equals("")){
                                Intent intent = new Intent(Login.this,Main.class);
                                intent.putExtra("display",account.getDisplayName());
                                intent.putExtra("user",account.getUserName());
                                intent.putExtra("type",account.getType());
                                startActivity(intent);
                            }else{
                                Toast.makeText(Login.this,"Vui lòng kiểm tra lại tài khoản hoặc mật khẩu",Toast.LENGTH_SHORT).show();
                            }
                        }

                    }

                    @Override
                    public void onFailure(Call<Account> call, Throwable t) {
                        Toast.makeText(Login.this,t.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        btDK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this,SignIn.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        textTK.setText("");
        textMK.setText("");
    }

    private void getPermission() {
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.INTERNET},999);
        }
    }

    private void InitWidgets() {
        textTK = (EditText) findViewById(R.id.editTKdn);
        textMK = (EditText) findViewById(R.id.editMKdn);

        btDK = (Button) findViewById(R.id.buttonDKdn);
        btDN = (Button) findViewById(R.id.buttonDN);

    }
}
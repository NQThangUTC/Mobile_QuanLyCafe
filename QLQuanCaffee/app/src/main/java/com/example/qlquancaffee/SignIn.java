package com.example.qlquancaffee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.qlquancaffee.Object.Account;
import com.example.qlquancaffee.retrofit.AccountInterface;
import com.example.qlquancaffee.retrofit.AccountUtils;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignIn extends AppCompatActivity {
    AccountInterface accountInterface;
    EditText textDisplay,textUser,textPass,textRePass;
    RadioButton rdb1,rdb0;
    Button btSignin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        InitWidgets();
        accountInterface = AccountUtils.getAccountService();
        btSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String display = textDisplay.getText().toString();
                String user = textUser.getText().toString();
                String pass = textPass.getText().toString();
                String repass = textRePass.getText().toString();
                int type = 0;
                if (rdb1.isChecked()) {
                    type = 1;
                }
                if (display.equals("")){
                    Toast.makeText(SignIn.this,"Tên hiển thị không được trống",Toast.LENGTH_SHORT).show();
                } else if (user.equals("")) {
                    Toast.makeText(SignIn.this,"Tài khoản không được trống",Toast.LENGTH_SHORT).show();
                } else if (pass.equals("") || repass.equals("")) {
                    Toast.makeText(SignIn.this,"Mật khẩu không được trống",Toast.LENGTH_SHORT).show();
                }else if (!pass.equals(repass)) {
                    Toast.makeText(SignIn.this,"Mật khẩu và nhập lại mật khẩu không khớp",Toast.LENGTH_SHORT).show();
                }else {
                    HashMap<String, Object> requestBody = new HashMap<>();
                    requestBody.put("UserName",user);
                    requestBody.put("DisplayName",display);
                    requestBody.put("PassWord",pass);
                    requestBody.put("RePassWord",repass);
                    requestBody.put("Type",type);

                    accountInterface.createAcc(requestBody).enqueue(new Callback<Account>() {
                        @Override
                        public void onResponse(Call<Account> call, Response<Account> response) {
                            if (response.body() != null){
                                Toast.makeText(SignIn.this,"Đăng ký thành công",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(SignIn.this,Login.class);
                                startActivity(intent);
                            }else {
                                Toast.makeText(SignIn.this,"Đăng ký ko thành công",Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<Account> call, Throwable t) {
                            Toast.makeText(SignIn.this,t.getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });

    }

    private void InitWidgets() {
        textDisplay = (EditText) findViewById(R.id.editDisplay);
        textUser = (EditText) findViewById(R.id.editUser);
        textPass = (EditText) findViewById(R.id.editPass);
        textRePass = (EditText) findViewById(R.id.editRePass);

        rdb0 = (RadioButton) findViewById(R.id.Type0);
        rdb1 = (RadioButton) findViewById(R.id.Type1);

        btSignin = (Button) findViewById(R.id.buttonSignin);
    }
}
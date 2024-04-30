package com.example.qlquancaffee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UpdateInfor extends AppCompatActivity {
    EditText textDisplay,textUser,textPass,textRePass;
    Button btUpdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_infor);
        InitWidgets();
        Intent intent = getIntent();
        textDisplay.setText(intent.getStringExtra("display"));
        textUser.setText(intent.getStringExtra("user"));
        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void InitWidgets() {
        textDisplay=(EditText) findViewById(R.id.editDisplayUP);
        textUser=(EditText) findViewById(R.id.editUserUP);
        textPass=(EditText) findViewById(R.id.editPassUP);
        textRePass=(EditText) findViewById(R.id.editRePassUP);

        btUpdate=(Button) findViewById(R.id.buttonUpdateInfor);
    }
}
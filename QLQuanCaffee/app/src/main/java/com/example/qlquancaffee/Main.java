package com.example.qlquancaffee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.qlquancaffee.Object.Account;

public class Main extends AppCompatActivity {
//    Toolbar myToolBar;
    int type = 0;
    String display,user,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar myToolBar = (Toolbar)  findViewById(R.id.toolbarMenu);
        setSupportActionBar(myToolBar);
        InitWidgets();
        Intent intent = getIntent();
        display = intent.getStringExtra("display");
        user = intent.getStringExtra("user");
        type = intent.getIntExtra("type",0);

//        Bundle bundle = intent.getBundleExtra("myInfo");
//        Account acc = (Account) intent.getSerializableExtra("myInfo");
//        if (bundle != null){
//            display = bundle.getString("display");
//            user = bundle.getString("user");
//            pass = bundle.getString("pass");
//            type = bundle.getInt("type");
//        }
        Toast.makeText(Main.this,type+" "+display+" "+user,Toast.LENGTH_SHORT).show();

    }
    private void InitWidgets() {
//        myToolBar= (Toolbar) findViewById(R.id.toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu,menu);
        if (type == 1){
            menu.findItem(R.id.Admin).setVisible(true);
        }
        if (type == 0){
            menu.findItem(R.id.Admin).setVisible(false);
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.Admin){
            Intent intent = new Intent(Main.this,Admin.class);
            startActivity(intent);
        }
        if (item.getItemId()==R.id.UpdateInfor){
            Intent intent = new Intent(Main.this,UpdateInfor.class);
            intent.putExtra("display",display);
            intent.putExtra("user",user);
            startActivity(intent);
        }
        if (item.getItemId()==R.id.Signout){
            Intent intent = new Intent(Main.this,Login.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
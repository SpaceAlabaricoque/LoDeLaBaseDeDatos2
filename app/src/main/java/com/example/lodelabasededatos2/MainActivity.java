package com.example.lodelabasededatos2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lodelabasededatos2.db.db.DbHelper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button BTNCreateTable;
    Button btnRegister;
    TextView userName;
    TextView userPassword;
    static ArrayList<String> logData = new ArrayList<String>();
    static ArrayList<String> userData = new ArrayList<String>();


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BTNCreateTable = findViewById(R.id.logIn);
        BTNCreateTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DbHelper dbHelper = new DbHelper(MainActivity.this);
                SQLiteDatabase db = dbHelper.getWritableDatabase();

                if(db != null){
                    Toast.makeText(MainActivity.this, "BASE DE DATOS CREADA", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "ERROR: BASE DE DATOS NO CREADA", Toast.LENGTH_SHORT).show();
                }

                logIn();
            }
        });

        btnRegister = findViewById(R.id.btnRegistrer);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeAct2();
            }
        });

    }
//añadir un ver contraseña
    public void logIn(){
        userName = findViewById(R.id.userName);
        userPassword = findViewById(R.id.userPassword);
        logData.add(userName.getText().toString());
        logData.add(userPassword.getText().toString());

    }

    /*
    public boolean onCreateOptionsNew(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal, menu);
        return true;

    }*/
    /*
    public boolean onOptionsItemSelectd(MenuItem item){
        switch(item.getItemId()){
            case R.id.item:
                changeAct2();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }*/

    public void changeAct2(){
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        startActivity(intent);
    }

}
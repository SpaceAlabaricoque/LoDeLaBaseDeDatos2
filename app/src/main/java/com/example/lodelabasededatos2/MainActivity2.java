package com.example.lodelabasededatos2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lodelabasededatos2.db.db.DbHelper;
import com.example.lodelabasededatos2.db.db.UserData;

public class MainActivity2 extends AppCompatActivity {

    Button btnRegister;
    static TextView userName;
    TextView userSurname;
    TextView userPassword;
    TextView userConPassword;
    TextView email;
    static UserData userData;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnRegister = findViewById(R.id.RBtnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userData();
                DbHelper dbHelper = new DbHelper(MainActivity2.this);
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db = dbHelper.getReadableDatabase();

                dbHelper.onCreate(db);
                dbHelper.createTable(db);
                boolean bol = dbHelper.insert(userData.getUserName(), userData.getUserSurName(), userData.getPassword(), userData.geteMail());
                if (bol == true){
                    Toast.makeText(MainActivity2.this, "el insert fufa", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MainActivity2.this, "el insert nofufa2", Toast.LENGTH_LONG).show();
                }
                getData();

            }

        });
    }

    public void userData(){
        userName = findViewById(R.id.RUserName);
        userSurname = findViewById(R.id.RUserSurmane);
        userPassword = findViewById(R.id.RUserPassword);
        userConPassword = findViewById(R.id.RConContraseña);
        email = findViewById(R.id.REmail);

        if(userName.getText().toString().equals("") || userSurname.getText().toString().equals("") || userPassword.getText().toString().equals("") || userConPassword.getText().toString().equals("") || email.getText().toString().equals("") ){
            Toast.makeText(MainActivity2.this, "Algunos de los campos no esta relleno", Toast.LENGTH_LONG).show();
        }else if(userPassword.getText().toString().equals(userConPassword.getText().toString())){
            userData = new UserData(userName.getText().toString(),
                    userSurname.getText().toString(),
                    userPassword.getText().toString(),
                    userConPassword.getText().toString(),
                    email.getText().toString()
            );
        }else{
            Toast.makeText(MainActivity2.this, "Las contraseñas no coinciden", Toast.LENGTH_LONG).show();
        }


    }

    public void getData(){
        DbHelper dbHelper = new DbHelper(MainActivity2.this);
        Cursor cursor = dbHelper.getData();

        Log.d("Nombre: ", cursor.getString(0));
        Log.d("Apellidos: ", cursor.getString(1));
        Log.d("Contraseña: ", cursor.getString(2));
        Log.d("Email: ", cursor.getString(3));
        cursor.close();
    }



}
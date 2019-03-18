package com.example.carlmatch.RIGHTDOC;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class UserController extends AppCompatActivity {
    //DatabaseHelper myDB;
   // ArrayList<AdvRecController> userList;
   // ListView listView;
    //AdvRecController user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        TextView tvLogout = (TextView) findViewById(R.id.tvLogout);
        String username =getIntent().getStringExtra("Username");
        TextView tvUsername = (TextView) findViewById(R.id.tvUsername);
        tvUsername.setText(username + "!");

        Button btnDoctor = (Button) findViewById(R.id.btnDoctor);
        btnDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserController.this,AdivceController.class));
            }
        });

        Button btnHistory = (Button) findViewById(R.id.btnHistory);
        btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserController.this,ViewListContents.class));
            }
        });

       tvLogout.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity( new Intent(UserController.this, LoginController.class));
                 Toast.makeText(UserController.this, "Account logout", Toast.LENGTH_SHORT).show();
          }
       });
        Button btnMessage = (Button) findViewById(R.id.btnMessage);
        btnMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserController.this,Messaging.class));
            }
        });


    }
}

package com.example.carlmatch.RIGHTDOC;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class HomeController extends AppCompatActivity {

  
  //private static int SPLASH_TIME_OUT = 4000;
    @Override

    protected void onCreate(Bundle savedInstanceState) 
{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


   
     Button btnLogin = (Button) findViewById(R.id.btnLogin);
        TextView tvRegister = (TextView) findViewById(R.id.tvRegister);
    
    btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
 
               Intent proceedIntent = new Intent(HomeController.this, LoginController.class);
     
           HomeController.this.startActivity(proceedIntent);
            }
        });

 
       tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) 
{
                Intent registerIntent = new Intent(HomeController.this, RegisterController.class);
        
        HomeController.this.startActivity(registerIntent);
            }
        });
    }
}

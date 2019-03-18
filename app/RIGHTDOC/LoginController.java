package com.example.carlmatch.RIGHTDOC;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginController extends AppCompatActivity {

    DatabaseController helper = new DatabaseController(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView tvForgot = (TextView) findViewById(R.id.tvForgot);
        TextView tvRegister = (TextView) findViewById(R.id.tvRegister);
        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(LoginController.this, RegisterController.class);
                LoginController.this.startActivity(registerIntent);
            }
        });
        tvForgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent forgot = new Intent(LoginController.this, ForgotPasswordController.class);
                startActivity(forgot);
            }
        });



    }
    public void onButtonClick(View v){
        if(v.getId() == R.id.btnLogin)
        {
            EditText etUsername = (EditText) findViewById(R.id.etUsername);
            String user = etUsername.getText().toString();
            EditText etPassword = (EditText) findViewById(R.id.etPassword);
            String pass = etPassword.getText().toString();

            String password = helper.searchPass(user);


            if(pass.equals(password)){
                Intent welcome = new Intent(LoginController.this, UserController.class);
                welcome.putExtra("Username",user);


                startActivity(welcome);

            }else if(user.equals("")){
                Toast userEquals = Toast.makeText(LoginController.this, "Username empty", Toast.LENGTH_SHORT);
                userEquals.show();
            }else if(pass.equals("")){
                Toast passEquals = Toast.makeText(LoginController.this, "Password empty", Toast.LENGTH_SHORT);
                passEquals.show();
            }
            else{
                Toast login = Toast.makeText(LoginController.this, "Username and Password don't match!", Toast.LENGTH_SHORT);
                login.show();
            }

        }
    }
}

package com.example.carlmatch.RIGHTDOC;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ForgotPasswordController extends AppCompatActivity {

    //EditText email,password;
  //  Button changepass;
    DatabaseController help = new DatabaseController(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

      final EditText  email = (EditText)findViewById(R.id.etEmailRecover);
      final EditText  password =(EditText) findViewById(R.id.etConfirmPassword);
        Button btnBack = (Button) findViewById(R.id.btnBackLogin);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ForgotPasswordController.this,LoginController.class);
                startActivity(intent);

            }
        });
       Button changepass = (Button) findViewById(R.id.btnSubmit);

    changepass.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String em = email.getText().toString();
            String npass = password.getText().toString();
            boolean update = help.updateAccount(em,npass);

            if(update){
                Toast pass = Toast.makeText(ForgotPasswordController.this,"password successfully update",Toast.LENGTH_SHORT);pass.show();

            }
        }
    });
    }
}

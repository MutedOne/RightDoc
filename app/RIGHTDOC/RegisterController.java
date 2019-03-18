package com.example.carlmatch.RIGHTDOC;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterController extends AppCompatActivity {

    DatabaseController helper = new DatabaseController(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //db = new Database(this);

        final EditText etName = (EditText) findViewById(R.id.etName);
        final EditText etUsername = (EditText) findViewById(R.id.etUsername);
        final EditText etPassword = (EditText) findViewById(R.id.etPassword);
         final EditText etConfirmPassword = (EditText) findViewById(R.id.etConfirmPassword);
         final EditText etEmail = (EditText) findViewById(R.id.etEmail);
         final EditText etAge = (EditText) findViewById(R.id.etAge);

        //Button btnClear = (Button) findViewById(R.id.btnClear);
        Button btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent proceedIntent = new Intent(RegisterController.this, LoginController.class);
               RegisterController.this.startActivity(proceedIntent);
            }
        });


    }



    public void onRegisterClick(View v) {
        if (v.getId() == R.id.btnRegister) {
            EditText name = (EditText) findViewById(R.id.etName);
            EditText username = (EditText) findViewById(R.id.etUsername);
            EditText pass1 = (EditText) findViewById(R.id.etPassword);
            EditText pass2 = (EditText) findViewById(R.id.etConfirmPassword);
            EditText email = (EditText) findViewById(R.id.etEmail);
            EditText age = (EditText) findViewById(R.id.etAge);

            String n = name.getText().toString();
            String u = username.getText().toString();
            String p = pass1.getText().toString();
            String pass2str = pass2.getText().toString();
            String er = email.getText().toString();
            int a = (Integer.parseInt(age.getText().toString()));
            boolean userDuplicate = helper.sameUser(u);
            if (!p.equals(pass2str)) {
                Toast pass = Toast.makeText(RegisterController.this, "Password don't match!", Toast.LENGTH_SHORT);
                pass.show();

            } else if (userDuplicate) {
                Toast.makeText(RegisterController.this, "Username already taken", Toast.LENGTH_SHORT).show();
            } else if (n.equals("")) {
                Toast.makeText(RegisterController.this, "Name Field Empty", Toast.LENGTH_SHORT).show();
            } else if (u.equals("")) {
                Toast.makeText(RegisterController.this, "Username Field Empty", Toast.LENGTH_SHORT).show();
            } else if (er.equals("")) {
                Toast.makeText(RegisterController.this, "Email Field Empty", Toast.LENGTH_SHORT).show();
            } else {
                RegisteredController r = new RegisteredController();
                r.setName(n);
                r.setUsername(u);
                r.setPassword(p);
                r.setEmail(er);
                r.setAge(a);

                helper.addUser(r);
                Toast toast = Toast.makeText(RegisterController.this, "Successfully Registered.", Toast.LENGTH_SHORT);
                toast.show();

                name.setText("");
                username.setText("");
                pass1.setText("");
                pass2.setText("");
                email.setText("");
                age.setText("");

            }

        }

    }
}

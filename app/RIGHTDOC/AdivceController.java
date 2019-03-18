package com.example.carlmatch.RIGHTDOC;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdivceController extends AppCompatActivity {
    Button btnAdvice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adivce);

        Button btnAdvice = (Button) findViewById(R.id.btnAdvice);

        btnAdvice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdivceController.this,AdviceandReceiptController.class);
                startActivity(intent);
            }
        });

    }
}

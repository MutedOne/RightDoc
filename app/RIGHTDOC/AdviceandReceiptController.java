package com.example.carlmatch.RIGHTDOC;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class AdviceandReceiptController extends AppCompatActivity {
    //EditText new_name = new EditText(this);
    DatabaseHelper myDB;
    Button btnAdd,btnBack,btnDelete,btnUpdate;
    EditText etName,etClinic,etClinicAddress,etEmail,etAdvice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = (EditText) findViewById(R.id.etName);
        etClinic = (EditText) findViewById(R.id.etClinic);
        etClinicAddress= (EditText) findViewById(R.id.etClinicAddress);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etAdvice = (EditText) findViewById(R.id.etAdvice);
        btnAdd = (Button) findViewById(R.id.btnAdd);
     //   btnBack = (Button) findViewById(R.id.btnBack);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        myDB = new DatabaseHelper(this);


     //  btnBack.setOnClickListener(new View.OnClickListener() {
     //     @Override
     //      public void onClick(View v) {
     //         Intent intent = new Intent (AdviceandReceiptController.this,UserController.class);
      //          startActivity(intent);
      //     }
     //   });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                String clinic = etClinic.getText().toString();
                String clinicaddress = etClinicAddress.getText().toString();
                String email = etEmail.getText().toString();
                String advice = etAdvice.getText().toString();
                if (name.length() != 0 && clinic.length() !=0 && clinicaddress.length() !=0 && email.length() != 0 && advice.length() !=0)  {
                    AddData(name,clinic,clinicaddress,email,advice);
                    etName.setText("");
                    etClinic.setText("");
                    etClinicAddress.setText("");
                    etEmail.setText("");
                    etAdvice.setText("");
                } else {
                    Toast.makeText(AdviceandReceiptController.this, "You must put something", Toast.LENGTH_LONG).show();
                }

            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDB.deleteHistory(etName.getText().toString());

            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            final EditText new_advice = new EditText(AdviceandReceiptController.this);
         AlertDialog.Builder dialog = new AlertDialog.Builder(AdviceandReceiptController.this);
        dialog.setTitle("ENTER NEW ADVICE/RECEIPT");

        dialog.setView(new_advice);

         dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
           @Override
         public void onClick(DialogInterface dialog, int which) {
         myDB.updateHistory(etAdvice.getText().toString(),new_advice.getText().toString());
         }
          });
         dialog.show();
        }
        });

    }


    public void AddData(String name,String clinic, String clinicaddress,String email,String advice){

        boolean insertData = myDB.addData(name,clinic,clinicaddress,email,advice);
        if(insertData==true){
            Toast.makeText(AdviceandReceiptController.this, "Successfully entered data", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(AdviceandReceiptController.this, "Somethng wrong", Toast.LENGTH_LONG).show();
        }
    }
    //public void DeleteHistory(String name){
       //// boolean deleteData = myDB.deleteHistory(name);
       // if(deleteData==true){
          //  Toast.makeText(AdviceandReceiptController.this, "Successfully deleted data", Toast.LENGTH_LONG).show();
       // }else{
          //  Toast.makeText(AdviceandReceiptController.this, "Somethng wrong", Toast.LENGTH_LONG).show();
        //}
   // }

}

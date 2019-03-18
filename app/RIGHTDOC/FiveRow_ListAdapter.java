package com.example.carlmatch.RIGHTDOC;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Acer on 3/9/2017.
 */

public class FiveRow_ListAdapter extends ArrayAdapter<AdvRecController> {

    private LayoutInflater mInflater;
    private ArrayList<AdvRecController> users;
    private  int mViewResourceId;

    public  FiveRow_ListAdapter(Context context,int textViewResourceId,ArrayList<AdvRecController> users){
      super(context,textViewResourceId,users);
     this.users = users;
       mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
       mViewResourceId = textViewResourceId;
    }
    public View getView(int position,View convertView,ViewGroup parents){
        convertView = mInflater.inflate(mViewResourceId,null);

        AdvRecController user = users.get(position);

        if(user !=null) {
            TextView Name = (TextView) convertView.findViewById(R.id.textName);
            TextView Clinic = (TextView) convertView.findViewById(R.id.textClinic);
            TextView ClinicAddress = (TextView) convertView.findViewById(R.id.textClinicAddress);
            TextView Email = (TextView) convertView.findViewById(R.id.textEmail);
            TextView Advice = (TextView) convertView.findViewById(R.id.textAdvice);
            if (Name != null){
                Name.setText(user.getName());
            }  if (Clinic != null){
                Clinic.setText(user.getClinic());
            }  if (ClinicAddress != null){
                ClinicAddress.setText(user.getClinicAddress());
            }  if (Email != null){
                Email.setText(user.getEmail());
            }  if (Advice != null){
                Advice.setText(user.getAdvice());
            }
        }
        return convertView;
    }
}

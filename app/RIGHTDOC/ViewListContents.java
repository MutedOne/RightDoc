package com.example.carlmatch.RIGHTDOC;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * Created by CarlMatch on 08/03/2017.
 */

public class ViewListContents extends AppCompatActivity {
    DatabaseHelper myDB;
    ArrayList<AdvRecController> userList;
    ListView listView;
    AdvRecController user;

    //CustomListViewAdapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewcontents_layout);

        ListView listView = (ListView)findViewById(R.id.ListView);
        myDB = new DatabaseHelper(this);

        userList = new ArrayList<>();
        Cursor data = myDB.getListContents();
        int numRows = data.getCount();

        if(numRows == 0){
            Toast.makeText(ViewListContents.this, "Empty", Toast.LENGTH_LONG).show();
        }else
        {

            while(data.moveToNext()){
                user = new AdvRecController(data.getString(1),data.getString(2),data.getString(3),data.getString(4),data.getString(5));
                userList.add(user);
            }
            FiveRow_ListAdapter adapter = new FiveRow_ListAdapter(this,R.layout.list_adapter_view,userList);
            listView = (ListView) findViewById(R.id.ListView);
            listView.setAdapter(adapter);
        }

    }


}

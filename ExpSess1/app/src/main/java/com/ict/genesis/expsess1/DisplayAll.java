package com.ict.genesis.expsess1;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Genesis on 12/09/2017.
 */

public class DisplayAll extends AppCompatActivity{


    ArrayList<String> listItems=new ArrayList<String>();
    ArrayAdapter<String> adapter;
    ListView myListView;
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_all);

        myListView=(ListView)findViewById(R.id.lview);
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listItems);
        myListView.setAdapter(adapter);

        SharedPreferences sharedpref=getSharedPreferences("register",MODE_PRIVATE);
        Map<String, ?> stringMap = sharedpref.getAll();
        for(String s : stringMap.keySet()){
            listItems.add(s);
            adapter.notifyDataSetChanged();
        }
    }
}

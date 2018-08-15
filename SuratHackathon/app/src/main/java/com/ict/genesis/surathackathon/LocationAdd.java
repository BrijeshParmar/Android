package com.ict.genesis.surathackathon;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.util.ArraySet;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Genesis on 24/09/2017.
 */

public class LocationAdd extends AppCompatActivity {
    ArrayList<String> listItems;
    ArrayAdapter<String> adapter;
    Spinner myspin;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addloc);
        listItems=new ArrayList<String>(Arrays.asList("Cinema","Mall","Swimming Pool","Library","Mall","Park","Washroom"));
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listItems);
        myspin.setAdapter(adapter);



    }
}

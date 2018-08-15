package com.ict.genesis.exampract;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

/**
 * Created by Genesis on 30/08/2017.
 */

public class Admin_Q extends AppCompatActivity {
    ArrayList<String> listItems=new ArrayList<String>();
    ArrayAdapter<String> adapter;
    Spinner mySpinner;
    Button myButton;
    EditText myText;
    AlertDialog.Builder build;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adminq);
        mySpinner=(Spinner)findViewById(R.id.spinner);
        myButton=(Button)findViewById(R.id.button);
        myText=(EditText)findViewById(R.id.editText);
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listItems);
        mySpinner.setAdapter(adapter);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=myText.getText().toString();
                if(myText.getText().toString().trim().length()>0){
                    listItems.add(s1);
                    adapter.notifyDataSetChanged();
                }
                else{
                    build=new AlertDialog.Builder(Admin_Q.this,android.R.style.Theme_Material_Dialog_Alert);
                    build.setTitle("Incorrect Data").setMessage("You have entered incorrect data").show();
                }
            }
        });

    }
}

package com.ict.genesis.practical7;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> listItems=new ArrayList<String>();
    ArrayAdapter<String> adapter;
    EditText myText;
    ListView myListView;
    Button myButton;
    String str;
    AlertDialog.Builder build;
    Spinner mySpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myText=(EditText) findViewById(R.id.listText);
        myButton=(Button)findViewById(R.id.myButton);
        myListView=(ListView)findViewById(R.id.myView);
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listItems);
        myListView.setAdapter(adapter);

        mySpinner=(Spinner)findViewById(R.id.mySpinner);
        mySpinner.setAdapter(adapter);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str=myText.getText().toString();
                if(myText.getText().toString().trim().length()>0){
                    listItems.add(str);
                    adapter.notifyDataSetChanged();
                }
                else{
                    build=new AlertDialog.Builder(MainActivity.this,android.R.style.Theme_Material_Dialog_Alert);
                    build.setTitle("Incorrect Data").setMessage("You have entered incorrect data").show();
                }
            }
        });
    }
}

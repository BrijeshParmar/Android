package com.ict.genesis.expsess1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Genesis on 06/09/2017.
 */

public class RegisterMain extends AppCompatActivity {

    private EditText name;
    private EditText emid;
    private EditText mno;
    private EditText gen;
    private EditText address;
    private EditText pass;
    private Button subm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.regmain);

        name=(EditText)findViewById(R.id.name);
        emid=(EditText)findViewById(R.id.emid);
        mno=(EditText)findViewById(R.id.mno);
        gen=(EditText)findViewById(R.id.gen);
        address=(EditText)findViewById(R.id.address);
        pass=(EditText)findViewById(R.id.pass);
        subm=(Button)findViewById(R.id.form_submit);

        subm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPref = getSharedPreferences("register",MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPref.edit();
                String n=emid.getText().toString();
                editor.putString(n,name.getText().toString()).apply();
                editor.putString(n,mno.getText().toString()).apply();
                editor.putString(n,gen.getText().toString()).apply();
                editor.putString(n,address.getText().toString()).apply();
                editor.putString(n,pass.getText().toString()).apply();
                gotologin();
            }
        });
    }

    private void gotologin() {
        Intent intent =new Intent(this,Login_Main.class);
        startActivity(intent);
    }
}

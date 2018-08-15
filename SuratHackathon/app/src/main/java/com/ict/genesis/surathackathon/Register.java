package com.ict.genesis.surathackathon;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Genesis on 23/09/2017.
 */

public class Register extends AppCompatActivity {

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
        setContentView(R.layout.activity_register);

        name=(EditText)findViewById(R.id.name);
        emid=(EditText)findViewById(R.id.emid);
        mno=(EditText)findViewById(R.id.sub);
        gen=(EditText)findViewById(R.id.gen);
        address=(EditText)findViewById(R.id.address);
        pass=(EditText)findViewById(R.id.pass);
        subm=(Button)findViewById(R.id.form_submit);


        subm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user=new User();
                user.set_name(name.getText().toString());
                user.set_email(emid.getText().toString());
                user.set_mno(mno.getText().toString());
                user.set_gender(gen.getText().toString());
                user.set_adr(address.getText().toString());
                user.set_pass(pass.getText().toString());
                UserDataHandler udb=new UserDataHandler(getApplicationContext());
                udb.addUser(user);
                gotologin();
            }
        });
    }
    private void gotologin() {
        Intent intent=new Intent(this,Login.class);
        startActivity(intent);
    }
}

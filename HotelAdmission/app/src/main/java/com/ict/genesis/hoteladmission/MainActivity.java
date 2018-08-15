package com.ict.genesis.hoteladmission;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private EditText name;
    private EditText email;
    private EditText mobno;
    private EditText nop;
    private EditText datef;
    private Button subm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=(EditText)findViewById(R.id.name);
        email=(EditText)findViewById(R.id.email);
        mobno=(EditText)findViewById(R.id.mobno);
        nop=(EditText)findViewById(R.id.nop);
        datef=(EditText)findViewById(R.id.datef);
        subm=(Button)findViewById(R.id.subm);

        subm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n=name.getText().toString();
                String e=email.getText().toString();
                String m=mobno.getText().toString();
                String no=nop.getText().toString();
                String d=datef.getText().toString();

                if(n.equals("")){
                    Toast.makeText(MainActivity.this, "Name can't be empty", Toast.LENGTH_SHORT).show();
                }
                else if(!n.matches("[a-zA-z]+")){
                    Toast.makeText(MainActivity.this,"Name can only contain Alphabets",Toast.LENGTH_SHORT).show();
                }
                else if(e.equals("")){
                    Toast.makeText(MainActivity.this,"Email can't be empty",Toast.LENGTH_SHORT).show();
                }
                else if(!e.matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")){
                    Toast.makeText(MainActivity.this,"Invalid Email",Toast.LENGTH_SHORT).show();
                }
                else if(m.equals("")){
                    Toast.makeText(MainActivity.this,"Mobile No. can't be empty",Toast.LENGTH_SHORT).show();
                }
                else if(m.length()!=10){
                    Toast.makeText(MainActivity.this,"Mobile No. should be 10 digit",Toast.LENGTH_SHORT);
                }
                else if(m.matches("[0-9]")){
                    Toast.makeText(MainActivity.this,"Mobile No. can contain only numbers",Toast.LENGTH_SHORT);
                }
                else if(no.equals("")){
                    Toast.makeText(MainActivity.this, "Number of people can't be 0", Toast.LENGTH_SHORT).show();
                }
                else if(no.matches("[0-9]")){
                    Toast.makeText(MainActivity.this, "Number of people filed can only contain numbers", Toast.LENGTH_SHORT).show();

                }

                else{
                    Intent intent =new Intent(getApplicationContext(),DisplayResult.class);
                    intent.putExtra("Name",n);
                    intent.putExtra("Email",e);
                    intent.putExtra("mob",m);
                    intent.putExtra("nop",no);
                    intent.putExtra("date",d);

                    SharedPreferences sharedpref=getSharedPreferences("Mypref",MODE_PRIVATE);
                    SharedPreferences.Editor editor=sharedpref.edit();
                    editor.putString("Name",n).apply();
                    editor.putString("Email",e).apply();
                    editor.putString("Mob",m).apply();
                    editor.putString("nop",no).apply();
                    editor.putString("date",d).apply();
                    startActivity(intent);
                }
            }
        });
    }
}

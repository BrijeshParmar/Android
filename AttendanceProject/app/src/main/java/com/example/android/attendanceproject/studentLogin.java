package com.example.android.attendanceproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class studentLogin extends AppCompatActivity {

    EditText enrol,pass;
    Button signIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);
        enrol = (EditText) findViewById(R.id.enrol);
        pass = (EditText) findViewById(R.id.pass);
        signIn=(Button) findViewById(R.id.signIN);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();
            }
        });
    }

    public void signIn(){
        String enrolment = enrol.getText().toString();
        String password = pass.getText().toString();

        if((enrolment.equals("15012111010")) && (password.equals("abhishek"))){
            Intent i = new Intent(getApplicationContext(), MyLocationUsingLocationAPI.class);
            startActivity(i);
            Toast.makeText(getApplicationContext(),"Login successful",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(getApplicationContext(),"Invalid information",Toast.LENGTH_SHORT).show();
        }
    }
}

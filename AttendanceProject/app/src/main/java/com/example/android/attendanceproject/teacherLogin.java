package com.example.android.attendanceproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class teacherLogin extends AppCompatActivity {

    EditText name,pass;
    Button signIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_login);
        name = (EditText) findViewById(R.id.name);
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
        String enrolment = name.getText().toString();
        String password = pass.getText().toString();

        if((enrolment.equals("brijesh")) && (password.equals("bp"))){
            Intent i = new Intent(getApplicationContext(), showAttendance.class);
            startActivity(i);
            Toast.makeText(getApplicationContext(),"Login successful",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(getApplicationContext(),"Invalid information",Toast.LENGTH_SHORT).show();
        }

    }
}

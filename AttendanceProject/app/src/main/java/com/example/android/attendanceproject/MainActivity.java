package com.example.android.attendanceproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void teacherLogin(View view) {
        Intent i = new Intent(getApplicationContext(), teacherLogin.class);
        startActivity(i);
    }

    public void studentLogin(View view) {
        Intent i = new Intent(getApplicationContext(), studentLogin.class);
        startActivity(i);
    }
}

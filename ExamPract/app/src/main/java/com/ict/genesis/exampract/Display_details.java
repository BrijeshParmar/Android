package com.ict.genesis.exampract;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Genesis on 30/08/2017.
 */

public class Display_details extends AppCompatActivity{
    private TextView name;
    private TextView roll;
    private TextView email;
    private TextView branch;
    private TextView course;
    private Button next;
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);
        Intent intent=getIntent();
        name=(TextView)findViewById(R.id.name);
        roll=(TextView) findViewById(R.id.rollno);
        email=(TextView)findViewById(R.id.email);
        branch=(TextView)findViewById(R.id.branch);
        course=(TextView)findViewById(R.id.course);
        next=(Button)findViewById(R.id.next);
        String s1=intent.getStringExtra("name").toString();
        name.setText(s1);

        String s3=intent.getStringExtra("email").toString();
        email.setText(s3);
        String s4=intent.getStringExtra("branch").toString();
        branch.setText(s4);
        String s5=intent.getStringExtra("course").toString();
        course.setText(s5);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotonextac();
            }
        });
        //roll.setText(intent.getStringExtra("roll").toString());
        //email.setText(intent.getStringExtra("email").toString());
        //branch.setText(intent.getStringExtra("branch").toString());
        //course.setText(intent.getStringExtra("course").toString());
    }

    private void gotonextac() {
        Intent intent1=new Intent(this,Admin_Q.class);
        startActivity(intent1);
    }
}

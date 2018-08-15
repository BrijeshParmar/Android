package com.ict.genesis.exampract;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText name;
    private EditText roll;
    private EditText email;
    private EditText branch;
    private EditText course;
    private Button subm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=(EditText)findViewById(R.id.name);
        roll=(EditText)findViewById(R.id.rollno);
        email=(EditText)findViewById(R.id.email);
        branch=(EditText)findViewById(R.id.branch);
        course=(EditText)findViewById(R.id.course);
        subm=(Button)findViewById(R.id.subm);


        subm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotonext(name.getText().toString(),roll.getText().toString(),email.getText().toString(),branch.getText().toString(),course.getText().toString());
            }
        });
    }

    private void gotonext(String s, String s1, String s2, String s3, String s4) {
        Intent intent=new Intent(this,Display_details.class);
        intent.putExtra("name",s);
        intent.putExtra("roll",s1);
        intent.putExtra("email",s2);
        intent.putExtra("branch",s3);
        intent.putExtra("course",s4);
        startActivity(intent);
    }
}

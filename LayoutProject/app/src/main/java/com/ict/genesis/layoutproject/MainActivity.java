package com.ict.genesis.layoutproject;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1=(Button)findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotointent();
            }
        });
    }

    private void gotointent() {
        Intent i= new Intent(this,TeacherLogin.class);
        startActivity(i);
    }

    @Override
    public void setActionBar(@Nullable Toolbar toolbar) {
        getActionBar().setTitle("Teacher Registration");
        getSupportActionBar().setTitle("Hello world App");  // provide compatibility to all the versions
    }
}


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

public class FeedBack extends AppCompatActivity {
    private EditText name;
    private EditText emid;
    private EditText Sub;
    private EditText Comment;
    private Button button;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        name=(EditText)findViewById(R.id.name);
        emid=(EditText)findViewById(R.id.emid);
        Sub=(EditText)findViewById(R.id.sub);
        Comment=(EditText)findViewById(R.id.cmtedit);
        button=(Button)findViewById(R.id.form_submit);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(FeedBack.this,Mainscreen.class);
                startActivity(intent);
            }
        });
    }
}

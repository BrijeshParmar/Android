package com.ict.genesis.hoteladmission;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class DisplayResult extends AppCompatActivity {

    private TextView name;
    private TextView email;
    private TextView mobno;
    private TextView nop;
    private TextView datef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_result);

        name=(TextView)findViewById(R.id.name);
        email=(TextView)findViewById(R.id.email);
        mobno=(TextView)findViewById(R.id.mobno);
        nop=(TextView)findViewById(R.id.nop);
        datef=(TextView)findViewById(R.id.datef);

        Intent intent=getIntent();
        name.setText(intent.getStringExtra("Name"));
        email.setText(intent.getStringExtra("Email"));
        mobno.setText(intent.getStringExtra("mob"));
        nop.setText(intent.getStringExtra("nop"));
        datef.setText(intent.getStringExtra("date"));
    }
}

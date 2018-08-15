package com.ict.genesis.admissionenquiry;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Genesis on 20/07/2017.
 */

public class ViewResult extends AppCompatActivity {

    private TextView name;
    private TextView id;
    private TextView mno;
    private TextView type;
    private TextView course;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_result);
        String n=getIntent().getStringExtra("sname");
        String i=getIntent().getStringExtra("sid");
        String m=getIntent().getStringExtra("sno");
        String t=getIntent().getStringExtra("stype");
        String c=getIntent().getStringExtra("scname");
        name=(TextView)findViewById(R.id.name);
        id=(TextView)findViewById(R.id.id);
        mno=(TextView)findViewById(R.id.mno);
        type=(TextView)findViewById(R.id.adm);
        course=(TextView)findViewById(R.id.cname);
        name.setText(n);
        id.setText(i);
        mno.setText(m);
        type.setText(t);
        course.setText(c);


    }
}

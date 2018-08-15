package com.ict.genesis.jvamanip;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.Button;
import android.graphics.Color;
import android.widget.EditText;
import android.content.res.Resources;
import android.util.TypedValue;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        RelativeLayout genesis_Layout=new RelativeLayout(this);
        genesis_Layout.setBackgroundColor(Color.DKGRAY);

        RelativeLayout.LayoutParams buttondetails=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);

        buttondetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        buttondetails.addRule(RelativeLayout.CENTER_VERTICAL);
        Resources r=getResources();
        int px =(int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,200,r.getDisplayMetrics());

        Button bluebutton=new Button(this);
        bluebutton.setText("Click me BOSS!");
        bluebutton.setBackgroundColor(Color.BLUE);
        bluebutton.setId(1);

        super.onCreate(savedInstanceState);
        genesis_Layout.addView(bluebutton,buttondetails);
        setContentView(genesis_Layout);

        EditText username=new EditText(this);
        username.setId(2);
        username.setWidth(px);

        RelativeLayout.LayoutParams userdetails=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        userdetails.addRule(RelativeLayout.ABOVE,bluebutton.getId());
        userdetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        userdetails.setMargins(0,0,0,50);

        genesis_Layout.addView(username,userdetails);
    }
}

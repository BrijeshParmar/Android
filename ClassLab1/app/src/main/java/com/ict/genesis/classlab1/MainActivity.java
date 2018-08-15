package com.ict.genesis.classlab1;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout mylayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Button mybutton=new Button(this);
        mybutton.setText("ClickMe");
        mylayout=new ConstraintLayout(this);
        mylayout.addView(mybutton);
        setContentView(mylayout);
        mybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mybutton.setText("You Clicked it");
            }
        });
    }
}

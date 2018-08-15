package com.ict.genesis.practical7;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

/**
 * Created by Genesis on 13/09/2017.
 */

public class RotateImage extends AppCompatActivity {

    ImageView myView;
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imagerotate);
        myView=(ImageView)findViewById(R.id.imageView2);

        myView.setPivotX(myView.getWidth()/2);
        myView.setPivotY(myView.getHeight()/2);
        myView.setRotation(90);

    }
}

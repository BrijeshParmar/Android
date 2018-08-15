package com.ict.genesis.fragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements topsectionfragment.TopSectionListener {

    @Override
//Called on button Click
    public void createMeme(String top,String Bottom){
        bottomsectionfragment bottomfragment=(bottomsectionfragment)getSupportFragmentManager().findFragmentById(R.id.fragment3);
        bottomfragment.setMemeText(top,Bottom);
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

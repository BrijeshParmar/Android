package com.ict.genesis.surathackathon;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Genesis on 23/09/2017.
 */

public class Mainscreen extends AppCompatActivity {
    private ImageView attraction;
    private ImageView citizen;
    private ImageView feedback;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainscreen);


        attraction=(ImageView)findViewById(R.id.attr);
        citizen=(ImageView)findViewById(R.id.citizen);
        feedback=(ImageView)findViewById(R.id.feed);


        attraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoattr();
            }
        });
        
        citizen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotocitz();
            }
        });

        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotofeed();
            }
        });
        UserDataHandler udb=new UserDataHandler(getApplicationContext());
        List<User> userList=udb.getAllUsers();

        for(User un: userList){
            String str=un.get_name();
            Toast.makeText(this,str,Toast.LENGTH_SHORT).show();
        }

    }

    private void gotofeed() {
        Intent intent=new Intent(this,FeedBack.class);
        startActivity(intent);
    }

    private void gotoattr() {
        Intent intent =new Intent(this,Attraction.class);
        startActivity(intent);
    }

    private void gotocitz() {
        Intent intent=new Intent(this,Citizen.class);
        startActivity(intent);
    }


}

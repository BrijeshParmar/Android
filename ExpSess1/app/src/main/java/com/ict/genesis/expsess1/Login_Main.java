package com.ict.genesis.expsess1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Genesis on 06/09/2017.
 */

public class Login_Main extends AppCompatActivity {

    TextView gotoreg;
    private Button subm;
    private EditText eid;
    private EditText pass;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainlogin);

        eid=(EditText)findViewById(R.id.email);
        pass=(EditText)findViewById(R.id.pass);
        subm=(Button)findViewById(R.id.sub_login);
        gotoreg=(TextView)findViewById(R.id.newreg);

        gotoreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotonext();
            }
        });

        subm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String e=eid.getText().toString();
                SharedPreferences sharedPref = getSharedPreferences("register",MODE_PRIVATE);
                String sp=sharedPref.getString(e,null);
                if(e.trim().length()==0){
                    showtext("nodata");
                }
                else if(sp==null){
                    showtext("error");
                }
                else{
                    showtext("success");
                    gotodisp();
                }
            }
        });




    }

    private void gotodisp() {
        Intent intent=new Intent(this,DisplayAll.class);
        startActivity(intent);
    }

    public void showtext(String e) {
        if(e=="error"){
            Toast.makeText(this,"No such email id exists",Toast.LENGTH_SHORT).show();
        }
        else if(e=="nodata")
            Toast.makeText(this,"Empty Fields",Toast.LENGTH_SHORT).show();
        else if(e=="success")
            Toast.makeText(this,"Success",Toast.LENGTH_SHORT).show();
        else{
            Toast.makeText(this,"Unknown Error",Toast.LENGTH_SHORT).show();
        }
    }

    private void gotonext() {
        Intent intent =new Intent(this,RegisterMain.class);
        startActivity(intent);
    }
}

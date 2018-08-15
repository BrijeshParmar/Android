package com.ict.genesis.surathackathon;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Genesis on 23/09/2017.
 */

public class Login extends AppCompatActivity {

    TextView gotoreg;
    private Button subm;
    private EditText eid;
    private EditText pass;


    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        eid = (EditText) findViewById(R.id.email);
        pass = (EditText) findViewById(R.id.pass);
        subm = (Button) findViewById(R.id.sub_login);
        gotoreg = (TextView) findViewById(R.id.newreg);


        gotoreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotonext();
            }
        });

        subm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String e = eid.getText().toString();
                String p= pass.getText().toString();
                if (e.trim().length() == 0) {
                    showtext("nodata");
                } else {
                    UserDataHandler udb=new UserDataHandler(getApplicationContext());
                    User user=udb.getUser(e);
                    if(e.equals(user.get_email())){
                        if(p.equals(user.get_pass())){
                            showtext("success");
                            gotodisp();
                        }
                        else {
                            showtext("pwrong");
                        }
                    }
                    else{
                        showtext("error");
                    }

                }
            }
        });
    }

    private void gotodisp() {
        Intent intent=new Intent(this,Mainscreen.class);
        startActivity(intent);
    }

    public void showtext(String e) {
        if(e.equals("error")){
            Toast.makeText(this,"No such email id exists",Toast.LENGTH_SHORT).show();
        }
        else if(e.equals("nodata"))
            Toast.makeText(this,"Empty Fields",Toast.LENGTH_SHORT).show();
        else if(e.equals("success"))
            Toast.makeText(this,"Success",Toast.LENGTH_SHORT).show();
        else if(e.equals("pwrong"))
            Toast.makeText(this,"Password Wrong",Toast.LENGTH_SHORT).show();
        else{
            Toast.makeText(this,"Unknown",Toast.LENGTH_SHORT).show();
        }
    }
    private void gotonext() {
        Intent intent =new Intent(this,Register.class);
        startActivity(intent);
    }
}



package com.ict.genesis.admissionenquiry;

import android.content.Intent;
import android.media.MediaCodec;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private EditText name;
    private EditText id;
    private EditText num;
    private EditText adm;
    private EditText cname;
    private Button sub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=(EditText)findViewById(R.id.sname);
        id=(EditText)findViewById(R.id.sid);
        num=(EditText)findViewById(R.id.sno);
        adm=(EditText)findViewById(R.id.admtype);
        cname=(EditText)findViewById(R.id.cname);
        sub=(Button)findViewById(R.id.form_submit);

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n=name.getText().toString();
                String i=id.getText().toString();
                String mno=num.getText().toString();
                String type=adm.getText().toString();
                String c=cname.getText().toString();
                if(n=="")
                {
                    showError("Please Enter name");
                }
                else if(!n.matches("[a-zA-Z ]+"))
                {
                    showError("Name can only contain alphabets");
                }
                else if(n.length()>10)
                {
                    showError("Name can't be more than 10 characters");
                }
                else if(!i.matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"))
                {
                    showError("Invalid Email Address");
                }
                else if(mno.length()!=10)
                {
                    showError("Mobile Number should be 10 digits");
                }
                else if(mno.matches("[0-9]"))
                {
                    showError("Mobile numbers should only contain number");
                }
                else if(type=="")
                {
                    showError("Please Enter Admission Type");
                }
                else if(!type.matches("[a-zA-z]+"))
                {
                    showError("Admission Type can only contain characters");
                }
                else if(c=="")
                {
                    showError("Please Enter Course Type");
                }
                else if(!c.matches("[a-zA-z]+"))
                {
                    showError("Course name can only contain characters");
                }
                else
                {
                    gotodisplay(n,i,mno,type,c);
                }
            }
        });
    }
    public void showError(String tex)
    {
        Toast.makeText(this,tex,Toast.LENGTH_SHORT).show();
    }
    public void gotodisplay(String n,String i,String m,String t,String c)
    {
        Intent gotonext=new Intent(this,ViewResult.class);
        gotonext.putExtra("sname",n);
        gotonext.putExtra("sid",i);
        gotonext.putExtra("sno",m);
        gotonext.putExtra("stype",t);
        gotonext.putExtra("scname",c);
        startActivity(gotonext);
    }
}

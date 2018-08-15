package com.ict.genesis.cloudconnect;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.Calendar;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private Button sendData;
    private EditText textfield;
    private EditText textfield1;
    private Button cactivity;
    Calendar C;
    //Get FireBase DataBase Reference
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textfield=(EditText)findViewById(R.id.addValue);
        textfield1=(EditText)findViewById(R.id.addKey);
        sendData=(Button)findViewById(R.id.add_data);
        cactivity=(Button)findViewById(R.id.retbutton);

        sendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value=textfield.getText().toString();
                String value1=textfield1.getText().toString();
                //Create Child of a Child
                myRef= database.getReference(value1).child("Message");
                myRef.setValue(value);
            }

        });

        cactivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoretrive();
            }

        });
    }
    public void gotoretrive()
    {
        Intent retrieve=new Intent(this, retrive_data.class);
        startActivity(retrieve);
    }
}

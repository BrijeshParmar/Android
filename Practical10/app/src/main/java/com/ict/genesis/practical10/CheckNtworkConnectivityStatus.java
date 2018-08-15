package com.ict.genesis.practical10;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class CheckNtworkConnectivityStatus extends AppCompatActivity {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_ntwork_connectivity_status);

        button = (Button) findViewById(R.id.button);
        button.setText("Load Data");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //System.out.println("CheckNtworkConnectivityStatus.onClick==" + checkConnectivity());
            }
        });
    }
}

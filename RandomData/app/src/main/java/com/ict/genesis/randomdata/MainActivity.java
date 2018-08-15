package com.ict.genesis.randomdata;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements SensorEventListener{

    private Calendar C;
    private FirebaseDatabase database=FirebaseDatabase.getInstance();
    private DatabaseReference sRef;

    private Sensor acc;
    private SensorManager sm;

    private TextView xp;
    private TextView yp;
    private TextView zp;

    private long lastUpdate=0;
    private float last_x,last_y,last_z;
    private static final int SHAKE_THRESHOLD=600;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        xp=(TextView)findViewById(R.id.xpos);
        yp=(TextView)findViewById(R.id.ypos);
        zp=(TextView)findViewById(R.id.zpos);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sm=(SensorManager)getSystemService(Context.SENSOR_SERVICE);
        acc=sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sm.registerListener(this,acc,SensorManager.SENSOR_DELAY_NORMAL);

    }

    public void senddata(float x,float y,float z){
            SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String time=s.format(new Date());

            String time2=String.valueOf(x)+' '+String.valueOf(y)+' '+String.valueOf(z);
            sRef=database.getReference(time);
            sRef.setValue(time2);

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        Sensor mySensor=sensorEvent.sensor;
        if(mySensor.getType()==Sensor.TYPE_ACCELEROMETER){
            float x=sensorEvent.values[0];
            float y=sensorEvent.values[1];
            float z=sensorEvent.values[2];
            
            last_x=x;
            last_y=y;
            last_z=z;

            senddata(last_x,last_y,last_z);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    protected void onPause(){
        super.onPause();
        sm.unregisterListener(this);
    }

    @Override
    protected void onResume(){
        super.onResume();
        sm.registerListener(this,acc,SensorManager.SENSOR_DELAY_NORMAL);
    }
}

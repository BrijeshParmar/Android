package com.example.genesis.watermeter;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GridLabelRenderer;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.DataPointInterface;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.OnDataPointTapListener;
import com.jjoe64.graphview.series.Series;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class UserDashboard extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    String month;
    FirebaseDatabase fdatabase;
    DatabaseReference mydb;
    Date d1;
    DataPoint dp;
    TextView cost_disp,vol_disp,nav_email;
    LineGraphSeries<DataPoint> series;
    GraphView graph;
    DateFormat format = new SimpleDateFormat("MMM-dd-yyyy",Locale.ENGLISH);
    SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard);

        cost_disp=(TextView)findViewById(R.id.cost_value);
        vol_disp=(TextView)findViewById(R.id.vol_value);
        graph = (GraphView) findViewById(R.id.graph);
        fdatabase=FirebaseDatabase.getInstance();
        mydb=fdatabase.getReference();
        month="January";
        DatabaseReference child = mydb.child("Users").child("bparmar360").child(month);
        DatabaseReference total = mydb.child("Users").child("bparmar360");
        total.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String cost;
                String volume;
                for(DataSnapshot ds : dataSnapshot.getChildren()){

                    String str = ds.getKey();
                    if(str.equals("Cost")){
                        cost=ds.getValue().toString();
                        cost_disp.setText(cost);

                    }
                    else if(str.equals("TotalVolume")){
                        volume=ds.getValue().toString();
                        vol_disp.setText(volume);
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        child.addValueEventListener(new ValueEventListener() {
            DataPoint[] data;
            int npts;
            int count_data=0;
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                npts=(int)dataSnapshot.getChildrenCount();
                data = new DataPoint[npts];

                for(DataSnapshot ds : dataSnapshot.getChildren()){
                    String dkey = ds.getKey();
                    long cvalue = (long)ds.getValue();

                    try {
                        d1 = format.parse(dkey);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    //Log.d("dataMessagX",d1.toString());
                    dp = new DataPoint(d1,cvalue);
                    data[count_data]=dp;
                    count_data++;
                }
                series = new LineGraphSeries<>(data);
                graph.addSeries(series);

                graph.getGridLabelRenderer().setGridStyle(GridLabelRenderer.GridStyle.NONE);// It will remove the background grids

                series.setDrawBackground(true);
                graph.setBackgroundColor(getResources().getColor(android.R.color.darker_gray));
                graph.getGridLabelRenderer().setHorizontalLabelsVisible(false);// remove horizontal x labels and line
                graph.getGridLabelRenderer().setVerticalLabelsVisible(true); // enables vertical zooming and scrolling
                graph.setTitle("Water Consumption for : "+month);
                graph.setTitleTextSize(50);
                graph.getGridLabelRenderer().setHorizontalAxisTitle("Date");
                graph.getGridLabelRenderer().setVerticalAxisTitle("Consumption in litre");
                series.setOnDataPointTapListener(new OnDataPointTapListener() {
                    @Override
                    public void onTap(Series series, DataPointInterface dataPoint) {
                        Date d = new java.sql.Date((long) dataPoint.getX());
                        SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-YYYY");
                        String formatted = format1.format(d.getTime());
                        Toast.makeText(getApplicationContext(), "Data: "+formatted+" \nWater Consumed: "+dataPoint.getY()+" ltr", Toast.LENGTH_SHORT).show();
                    }
                });

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }


        });


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Application by: Brijesh Parmar", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View headerView = navigationView.getHeaderView(0);
        TextView navUsername = (TextView) headerView.findViewById(R.id.nav_display_id);
        navUsername.setText(getIntent().getStringExtra("E-mail"));
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.user_dashboard, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        month=item.getTitle().toString();
        LoadAgain();
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void LoadAgain(){
        DatabaseReference child = mydb.child("Users").child("bparmar360").child(month);
        DatabaseReference total = mydb.child("Users").child("bparmar360");
        total.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String cost;
                String volume;
                for(DataSnapshot ds : dataSnapshot.getChildren()){

                    String str = ds.getKey();
                    if(str.equals("Cost")){
                        cost=ds.getValue().toString();
                        cost_disp.setText(cost);

                    }
                    else if(str.equals("TotalVolume")){
                        volume=ds.getValue().toString();
                        vol_disp.setText(volume);
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        child.addValueEventListener(new ValueEventListener() {
            DataPoint[] data;
            int npts;
            int count_data=0;
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                npts=(int)dataSnapshot.getChildrenCount();
                data = new DataPoint[npts];

                for(DataSnapshot ds : dataSnapshot.getChildren()){
                    String dkey = ds.getKey();
                    long cvalue = (long)ds.getValue();

                    try {
                        d1 = format.parse(dkey);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    //Log.d("dataMessagX",d1.toString());
                    dp = new DataPoint(d1,cvalue);
                    data[count_data]=dp;
                    count_data++;
                }
                series = new LineGraphSeries<>(data);
                graph.removeAllSeries();
                graph.addSeries(series);

                graph.getGridLabelRenderer().setGridStyle(GridLabelRenderer.GridStyle.NONE);// It will remove the background grids

                series.setDrawBackground(true);
                graph.setBackgroundColor(getResources().getColor(android.R.color.darker_gray));
                graph.getGridLabelRenderer().setHorizontalLabelsVisible(false);// remove horizontal x labels and line
                graph.getGridLabelRenderer().setVerticalLabelsVisible(true); // enables vertical zooming and scrolling
                graph.setTitle("Water Consumption for : "+month);
                graph.setTitleTextSize(50);
                graph.getGridLabelRenderer().setHorizontalAxisTitle("Date");
                graph.getGridLabelRenderer().setVerticalAxisTitle("Consumption in litre");

                series.setOnDataPointTapListener(new OnDataPointTapListener() {
                    @Override
                    public void onTap(Series series, DataPointInterface dataPoint) {
                        Date d = new java.sql.Date((long) dataPoint.getX());
                        SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-YYYY");
                        String formatted = format1.format(d.getTime());
                        Toast.makeText(getApplicationContext(), "Data: "+formatted+" \nWater Consumed: "+dataPoint.getY()+" ltr", Toast.LENGTH_SHORT).show();
                    }
                });

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }


        });
    }
}

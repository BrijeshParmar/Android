package com.ict.genesis.classtutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add :
                Toast.makeText(this,"ADD ITEM",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.about :
                Toast.makeText(this,"ABOUT ITEM",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.exit :
                Toast.makeText(this,"BYE BYE",Toast.LENGTH_SHORT).show();
                finish();
                return true;
            case R.id.reset:
                Toast.makeText(this,"RESET ITEM",Toast.LENGTH_SHORT).show();
                return true;
        }
        return true;
    }

}

package com.ict.genesis.navigationlearning;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private SectionPagerAdapter mSecAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSecAdapter=new SectionPagerAdapter(getSupportFragmentManager());
        mViewPager=(ViewPager)findViewById(R.id.container);
        setupViewPager(mViewPager);
        TabLayout tabLayout=(TabLayout)findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_arrow_back_black_24dp);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_android_black_24dp);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_arrow_forward_black_24dp);

    }

    private void setupViewPager(ViewPager viewPager){
        SectionPagerAdapter adapter=new SectionPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new BackFragment());
        adapter.addFragment(new HomeFragment());
        adapter.addFragment(new ForwardFragment());
        viewPager.setAdapter(adapter);
    }
}

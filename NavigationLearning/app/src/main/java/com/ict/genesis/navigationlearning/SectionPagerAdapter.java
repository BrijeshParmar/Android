package com.ict.genesis.navigationlearning;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Genesis on 10/08/2017.
 */

public class SectionPagerAdapter extends FragmentPagerAdapter {

    private final List<Fragment> frags=new ArrayList<>();
    public SectionPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return frags.get(position);
    }

    @Override
    public int getCount() {
        return frags.size();
    }

    public void addFragment(Fragment frag){
        frags.add(frag);
    }
}

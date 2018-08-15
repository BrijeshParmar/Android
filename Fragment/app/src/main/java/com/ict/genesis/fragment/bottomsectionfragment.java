package com.ict.genesis.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class bottomsectionfragment extends Fragment {
    private static TextView toptext;
    private static TextView bottomtext;
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_section_fragment, container, false);
        toptext=(TextView)view.findViewById(R.id.toptext);
        bottomtext=(TextView)view.findViewById(R.id.bottomtext);
        return view;
    }

    public void setMemeText(String top,String bottom){
        toptext.setText(top);
        bottomtext.setText(bottom);
    }
}
package com.ict.genesis.fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringDef;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;
/**
 * Created by Genesis on 6/27/2017.
 */

public class topsectionfragment extends Fragment {
    public interface TopSectionListener{
        public void createMeme(String top,String Bottom);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            activityCommander=(TopSectionListener)context;
        }catch (ClassCastException e){
            throw new ClassCastException(context.toString());
        }
    }

    TopSectionListener activityCommander;

    private static EditText toptextinput;
    private static EditText bottomtextinput;
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.top_section_fragment,container,false);
        toptextinput=(EditText)view.findViewById(R.id.toptextinput);
        bottomtextinput=(EditText)view.findViewById(R.id.bottomtextinput);
        final Button button=(Button)view.findViewById(R.id.button);

        button.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v) {
                        buttonClicked(v);
                    }}
        );
        return view;
    }
    public void buttonClicked(View V){
        activityCommander.createMeme(toptextinput.getText().toString(),bottomtextinput.getText().toString());
    }
}

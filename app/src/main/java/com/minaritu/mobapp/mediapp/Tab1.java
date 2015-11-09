package com.minaritu.mobapp.mediapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;


public class Tab1 extends Fragment implements OnClickListener{

    public Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.tab_1, container, false);
        Button b1 = (Button)v.findViewById(R.id.button_edit1);
        Button b2 = (Button)v.findViewById(R.id.button_edit2);
        Button b3 = (Button)v.findViewById(R.id.button_edit3);
        Button b4 = (Button)v.findViewById(R.id.button_edit4);
        Button b5 = (Button)v.findViewById(R.id.button_edit5);
        b1.setOnClickListener(new OnClickListener()
        {
            public void onClick(View v)
            {
                Intent intent = new Intent(getActivity(), Edit1.class);
                startActivity(intent);
            }

        });

        b2.setOnClickListener(new OnClickListener()
        {
            public void onClick(View v)
            {
                Intent intent = new Intent(getActivity(), Edit1.class);
                startActivity(intent);
            }

        });

        b3.setOnClickListener(new OnClickListener()
        {
            public void onClick(View v)
            {
                Intent intent = new Intent(getActivity(), Edit1.class);
                startActivity(intent);
            }

        });

        b4.setOnClickListener(new OnClickListener()
        {
            public void onClick(View v)
            {
                Intent intent = new Intent(getActivity(), Edit1.class);
                startActivity(intent);
            }

        });

        b5.setOnClickListener(new OnClickListener()
        {
            public void onClick(View v)
            {
                Intent intent = new Intent(getActivity(), Edit1.class);
                startActivity(intent);
            }

        });
        return v;
    }

    @Override
    public void onClick(View v) {

    }
}

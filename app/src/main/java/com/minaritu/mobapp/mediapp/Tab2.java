package com.minaritu.mobapp.mediapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Tab2 extends Fragment implements View.OnClickListener{
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab_2,container,false);
        Button ar = (Button)v.findViewById(R.id.addremarks);
        ar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AddRemarks.class);
                startActivity(intent);
            }

        });
        return v;
    }

    @Override
    public void onClick(View v) {

    }
}

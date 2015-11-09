package com.minaritu.mobapp.mediapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.support.v4.app.FragmentManager;

/**
 * Created by Lenovo on 10/21/2015.
 */
public class AddRemarks extends Activity{

    Button bBack;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_remarks);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*0.9),(int)(height*0.5));

        /*bBack = (Button) findViewById(R.id.back_remark);
        bBack.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getFragment(), Tab1.class);
                startActivity(intent);

            }
        });*/
    }
}

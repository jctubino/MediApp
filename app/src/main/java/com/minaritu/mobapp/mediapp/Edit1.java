package com.minaritu.mobapp.mediapp;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class Edit1 extends Activity implements OnClickListener {

    TimePicker myTimePicker;
    Button buttonstartSetDialog;
    TextView textAlarmPrompt;
    Button addAlarm1_edit1;
    Button save_edit;
    EditText edit1_name, med_desc1,pillnum;
    public Button btn[] = new Button[10];
    LinearLayout rl_edit1;
    public int i = 0;


    TimePickerDialog timePickerDialog;
    final static int RQS_1 = 1;

    SQLiteDatabase db;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit1);
        rl_edit1 = (LinearLayout)findViewById(R.id.rellay_edit1);
        addAlarm1_edit1 = (Button)findViewById(R.id.addAlarm_edit1);
        addAlarm1_edit1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("BUTTON FOR ADD BUTTS", "   " + btn[i]);

                rl_edit1.addView(createNewAlarm());
            }
        });

        pillnum = (EditText)findViewById(R.id.pillnum);
        med_desc1 = (EditText)findViewById(R.id.med_desc1);
        edit1_name = (EditText)findViewById(R.id.edit1_name);
        save_edit = (Button)findViewById(R.id.save_edit);
        save_edit.setOnClickListener(this);

        db=openOrCreateDatabase("MedLogs", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS logs(medName VARCHAR,medDesc VARCHAR,remarks VARCHAR,status VARCHAR,pillNum INTEGER);");

    }

    public void onClick(View view) {
        if(view==save_edit)
        {
            db.execSQL("INSERT INTO logs VALUES('"+edit1_name.getText()+"','"+med_desc1.getText()+
                    "','"+med_desc1.getText()+"',"+pillnum.getText()+"');");
            showMessage("Success", "Record added");
            clearText();
        }



    }

    public Button createNewAlarm(){
        final LinearLayout.LayoutParams lparams = new LinearLayout.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        Button newAlarm1_edit1;
        newAlarm1_edit1 = new Button(this);
        lparams.setMargins(5, 5, 5, 5);
        newAlarm1_edit1.setPadding(2, 2, 2, 2);
        newAlarm1_edit1.setBackgroundColor(Color.parseColor("#009688"));
        newAlarm1_edit1.setTextColor(Color.WHITE);
        newAlarm1_edit1.setTextSize(10);
        newAlarm1_edit1.setLayoutParams(lparams);
        openTimePickerDialog(false);
        btn[i] = newAlarm1_edit1;
        i++;

        return newAlarm1_edit1;
    }

    private void openTimePickerDialog(boolean is24r){
        Calendar calendar = Calendar.getInstance();

        timePickerDialog = new TimePickerDialog(
                Edit1.this,
                onTimeSetListener,
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE),
                is24r);
        timePickerDialog.setTitle("Set Alarm Time: ");

        timePickerDialog.show();

    }



    OnTimeSetListener onTimeSetListener
            = new OnTimeSetListener(){

        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

            Calendar calNow = Calendar.getInstance();
            Calendar calSet = (Calendar) calNow.clone();

            calSet.set(Calendar.HOUR_OF_DAY, hourOfDay);
            calSet.set(Calendar.MINUTE, minute);
            calSet.set(Calendar.SECOND, 0);
            calSet.set(Calendar.MILLISECOND, 0);

            if(calSet.compareTo(calNow) <= 0){
                calSet.add(Calendar.DATE, 1);
            }

            setAlarm(calSet);
            setToButton(calSet);

        }};

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void setAlarm(Calendar targetCal){
        /*
        textAlarmPrompt.setText(
                "\n\n***\n"
                        + "Alarm is set@ " + targetCal.getTime() + "\n"
                        + "***\n");
        */
        Intent intent = new Intent(getBaseContext(), AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getBaseContext(), RQS_1, intent, 0);
        AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, targetCal.getTimeInMillis(), pendingIntent);
        //alarmManager.getNextAlarmClock();
    }

    private void setToButton(Calendar targetCal) {
        Log.d("CHECK CHECK!", "  " + i);
        int ii = i--;
        Log.d("CHECK AGAIN!", "  " + i);
        btn[i].setText("" + targetCal.getTime());
    }

    public void showMessage(String title,String message)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    public void clearText()
    {
        pillnum.setText("");
        med_desc1.setText("");
        edit1_name.setText("");
    }


}
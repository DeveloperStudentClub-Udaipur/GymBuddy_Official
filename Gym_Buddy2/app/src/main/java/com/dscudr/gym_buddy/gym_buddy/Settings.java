package com.dscudr.gym_buddy.gym_buddy;


import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;




/**
 * A simple {@link Fragment} subclass.
 */
public class Settings extends Fragment {


    public Settings() {
        // Required empty public constructor
    }
    SharedPreferences sharedPreferences;
    Switch switch_1;
    AlarmManager alarmManager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        sharedPreferences = this.getActivity().getSharedPreferences("reminder_settings", Context.MODE_PRIVATE);
        int ch = sharedPreferences.getInt("Notification",0);
        switch_1 = (Switch)view.findViewById(R.id.sw_setting);
        final AlarmManager alarmManager = (AlarmManager)getActivity().getSystemService(Context.ALARM_SERVICE);

        if(ch==1)
        {
            switch_1.setChecked(true);
        }
        else
        {
            switch_1.setChecked(false);
        }
        switch_1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if(isChecked==true)
                {
                    Toast.makeText(getContext(),"function called gymbuddy",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent();
                    intent.setAction("com.dscudpr.gymbuddy");
                    intent.addCategory("android.intent.category.DEFAULT");
                    PendingIntent pendingIntent = PendingIntent.getBroadcast(getContext(),0,intent,0);
                    alarmManager.setRepeating(alarmManager.RTC_WAKEUP,System.currentTimeMillis(),1000 * 3600,pendingIntent);
                    Toast.makeText(getContext(),"Alarm set ",Toast.LENGTH_SHORT).show();
                    SharedPreferences sharedPreferences = getContext().getSharedPreferences("reminder_settings",Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("Notification",1);
                    editor.commit();
                }
                else
                {
                    Intent intent = new Intent();
                    intent.setAction("com.dscudpr.gymbuddy");
                    intent.addCategory("android.intent.category.DEFAULT");
                    PendingIntent pendingIntent = PendingIntent.getBroadcast(getContext(),0,intent,0);
                    alarmManager.cancel(pendingIntent);
                    Toast.makeText(getContext(),"Alarm unset gymbuddy",Toast.LENGTH_SHORT).show();
                    SharedPreferences sharedPreferences = getActivity().getSharedPreferences("reminder_settings",Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("Notification",0);
                    editor.commit();
                }
            }
        });

        return view;

    }

}

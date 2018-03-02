package com.dscudr.gym_buddy.gym_buddy;


import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import com.dscudr.gym_buddy.gym_buddy.activity.MainActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class Settings extends Fragment {


    @BindView(R.id.sw_setting)
    Switch swSetting;
    @BindView(R.id.click)
    TextView click;
    Unbinder unbinder;

    public Settings() {
        // Required empty public constructor
    }

    SharedPreferences sharedPreferences;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        unbinder = ButterKnife.bind(this, view);
        sharedPreferences = this.getActivity().getSharedPreferences("reminder_settings", Context.MODE_PRIVATE);
        int ch = sharedPreferences.getInt("Notification", 0);
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri sound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(getContext());
                NotificationCompat.Builder noti = new NotificationCompat.Builder(getContext());
                noti.setContentText("It's Time to Get Hidrated");
                noti.setContentTitle("Drink Water");
                noti.setSound(sound);
                noti.setSmallIcon(R.mipmap.ic_launcher);
                noti.setAutoCancel(true);
                Intent i = new Intent(getContext(), MainActivity.class);
                PendingIntent pd = PendingIntent.getActivity(getContext(), 1, i, 0);
                noti.setContentIntent(pd);
                managerCompat.notify(1, noti.build());
            }
        });
        final AlarmManager alarmManager = (AlarmManager) getActivity().getSystemService(Context.ALARM_SERVICE);

        if (ch == 1) {
            swSetting.setChecked(true);
        } else {
            swSetting.setChecked(false);

        }
        swSetting.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Intent intent = new Intent();
                    intent.setAction("com.dscudpr.gymbuddy");
                    intent.addCategory("android.intent.category.DEFAULT");
                    PendingIntent pendingIntent = PendingIntent.getBroadcast(getContext(), 0, intent, 0);
                    alarmManager.setRepeating(alarmManager.RTC_WAKEUP, System.currentTimeMillis(), 1000 * 3600, pendingIntent);
                    SharedPreferences sharedPreferences = getContext().getSharedPreferences("reminder_settings", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("Notification", 1);
                    editor.commit();
                } else {
                    Intent intent = new Intent();
                    intent.setAction("com.dscudpr.gymbuddy");
                    intent.addCategory("android.intent.category.DEFAULT");
                    PendingIntent pendingIntent = PendingIntent.getBroadcast(getContext(), 0, intent, 0);
                    alarmManager.cancel(pendingIntent);
                    SharedPreferences sharedPreferences = getActivity().getSharedPreferences("reminder_settings", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("Notification", 0);
                    editor.commit();
                }
            }
        });
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri sound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(getContext());
                NotificationCompat.Builder noti = new NotificationCompat.Builder(getContext());
                noti.setContentText("It's Time to Get Hidrated");
                noti.setContentTitle("Drink Water");
                noti.setSound(sound);
                noti.setSmallIcon(R.mipmap.ic_launcher);
                Intent i = new Intent(getContext(), MainActivity.class);
                PendingIntent pd = PendingIntent.getActivity(getContext(), 1, i, 0);
                noti.setContentIntent(pd);
                noti.setAutoCancel(true);
                managerCompat.notify(1, noti.build());

            }
        });


        return view;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}

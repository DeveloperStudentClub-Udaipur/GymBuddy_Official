package com.dscudr.gym_buddy.gym_buddy;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.widget.Toast;

public class NotificationReminder extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Uri sound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(context);
        NotificationCompat.Builder noti = new NotificationCompat.Builder(context);
        noti.setContentText("It's Time to Get Hidrated");
        noti.setContentTitle("Drink Water");
        noti.setSound(sound);
        noti.setSmallIcon(R.mipmap.ic_launcher);
        Intent i = new Intent(context, MainActivity.class);
        PendingIntent pd = PendingIntent.getActivity(context, 1, i, 0);
        noti.setContentIntent(pd);
        noti.setAutoCancel(true);
        managerCompat.notify(1, noti.build());
        Toast.makeText(context,"inside reciver Gymbuddy ",Toast.LENGTH_SHORT).show();
    }
}

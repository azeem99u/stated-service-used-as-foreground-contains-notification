package com.dmp.foregroundservice;


import static com.dmp.foregroundservice.App.CHANNEL_ID;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

public class ExampleService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Intent notificationIntent = new Intent(this,MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,notificationIntent,0);

        String text = intent.getStringExtra("et1");
        Notification notification = new NotificationCompat.Builder(this,CHANNEL_ID)
                .setContentTitle("My Service")
                .setContentText(text)
                .setSmallIcon(R.drawable.ic_baseline_textsms_24)
                .setContentIntent(pendingIntent)
                .build();
        startForeground(1,notification);
        //stopSelf();
        return START_NOT_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}

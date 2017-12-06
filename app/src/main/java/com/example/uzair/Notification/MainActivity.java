package com.example.uzair.Notification;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

//    Context context = this.getApplicationContext();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edittext = (EditText) findViewById(R.id.editText);
        final Button notify = (Button) findViewById(R.id.notify);

        notify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                PendingIntent pIntent = PendingIntent.getActivity(getApplicationContext(),
                        (int) System.currentTimeMillis(), intent, 0);

                NotificationCompat.Builder mBuilder =
                        new NotificationCompat.Builder(getApplicationContext())
                                .setSmallIcon(R.drawable.notification_icon)
                                .setContentTitle("EJAZ SAHAB")
                                .setContentText("Darmiyan Main Dalen!")
                                .setContentIntent(pIntent);

                NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.notify(0, mBuilder.build());
            }
        });
    }
}


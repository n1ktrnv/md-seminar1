package com.example.services;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onStartButtonClick(View view) {
        startService(new Intent(this, MyService.class));
    }

    public void onBindButtonClick(View view) {
        ServiceConnection serviceConnection = new ServiceConnection() {
            public void onServiceConnected(ComponentName name, IBinder binder) {
            }

            public void onServiceDisconnected(ComponentName name) {
            }
        };
        bindService(new Intent(this, MyService.class), serviceConnection, BIND_AUTO_CREATE);
        unbindService(serviceConnection);
    }
}
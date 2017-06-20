package com.werwolfkill;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.werwolfkill.service.NetService;
import com.werwolfkill.service.NetServiceConnection;

public class MainActivity extends AppCompatActivity {

    private NetServiceConnection netServiceConnection = new NetServiceConnection();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //启动net服务
        Intent intent = new Intent(this, NetService.class);
//        startService(intent);
//        bindService(intent, netServiceConnection, BIND_AUTO_CREATE);
        setContentView(R.layout.activity_main);
        //去掉actionBar
        getSupportActionBar().hide();
    }
}

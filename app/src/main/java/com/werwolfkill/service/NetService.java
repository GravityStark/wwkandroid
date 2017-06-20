package com.werwolfkill.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.werwolfkill.net.NetManager;

/**
 * Created by liuwei on 2017/6/19.
 */

public class NetService extends Service {
    private NetServiceBinder binder = new NetServiceBinder();

    @Override
    public void onCreate() {
        super.onCreate();
        //启动网络线程
        NetManager.getinstance().init();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }
}

package com.werwolfkill.service;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;


/**
 * Created by liuwei on 2017/6/19.
 */

public class NetServiceConnection implements ServiceConnection {
    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {

    }
}

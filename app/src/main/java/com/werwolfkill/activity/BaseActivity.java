package com.werwolfkill.activity;

import android.os.Message;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by liuwei on 2017/7/5.
 */

public abstract class BaseActivity extends AppCompatActivity {
    public abstract void handleMessage(Message msg) throws Exception;
}

package com.werwolfkill.activity.handler;

import android.os.Handler;
import android.os.Message;

import com.werwolfkill.activity.BaseActivity;

import java.lang.ref.WeakReference;

/**
 * Created by liuwei on 2017/7/5.
 */

public class ActMsgHandler extends Handler {

    //对Activity的弱引用
    private final WeakReference<BaseActivity> mActivity;

    public ActMsgHandler(BaseActivity activity){
        mActivity = new WeakReference<BaseActivity>(activity);
    }

    @Override
    public void handleMessage(Message msg) {
        BaseActivity activity = mActivity.get();
        if(activity==null){
            super.handleMessage(msg);
            return;
        }
        try {
            activity.handleMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

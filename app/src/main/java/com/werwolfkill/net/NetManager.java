package com.werwolfkill.net;

import android.os.Bundle;
import android.os.Message;

import com.werwolfkill.MainActivity;

import message.core.ClientActionProto;
import message.core.PBMessageProto;

/**
 * Created by Administrator on 2017/6/15.
 */

public class NetManager {

    private static SocketClient socketClient = null;
    private MainActivity.MyHandler mHandler;//游戏界面
    private NetManager() {
    }

    /**
     * 枚举单例
     */
    enum Singleton {
        INSTANCE;
        NetManager instance;

        Singleton() {
            instance = new NetManager();
        }

        NetManager getInstance() {
            return instance;
        }
    }

    /**
     * 获取实例
     *
     * @return
     */
    public static NetManager getinstance() {
        return Singleton.INSTANCE.getInstance();
    }

    public void init() {
        socketClient = new SocketClient();
        socketClient.connet();

        heartBeat();
    }

    public static void sendMessage(PBMessageProto.PBMessage.Builder msg) {
        socketClient.send(msg);
    }

    private void heartBeat() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (; ; ) {
                    try {
                        Thread.sleep(5 * 1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    PBMessageProto.PBMessage.Builder builder = PBMessageProto.PBMessage.newBuilder();
                    builder.setCode(ClientActionProto.ClientAction.ACTION_HEARTBEAT_VALUE);
                    sendMessage(builder);
                }
            }
        }).start();
    }

    public void setmHandler(MainActivity.MyHandler mHandler) {
        this.mHandler = mHandler;
    }

    /**
     * 发送系统数据到主界面
     */
    public void sendSystemMsgToMainActivity(String content){
        StringBuilder senderBuilder = new StringBuilder();
        senderBuilder.append("系统消息-->");

        StringBuilder contentBuilder = new StringBuilder(content);


        Message message = Message.obtain();
        message.what = 1;
        Bundle bundle = new Bundle();
        bundle.putString("sender",senderBuilder.toString());
        bundle.putString("content",contentBuilder.toString());
        message.setData(bundle);
        mHandler.sendMessage(message);

    }
    /**
     * 发送玩家数据到主界面
     */
    public void sendPlayerMsgToMainActivity(String sender,String content){
        StringBuilder senderBuilder = new StringBuilder(sender);
        senderBuilder.append(" 说:");

        StringBuilder contentBuilder = new StringBuilder(content);


        Message message = Message.obtain();
        Bundle bundle = new Bundle();
        bundle.putString("sender",senderBuilder.toString());
        bundle.putString("content",contentBuilder.toString());
        message.setData(bundle);
        mHandler.sendMessage(message);
    }
}

package com.werwolfkill.net;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.google.protobuf.ByteString;
import com.werwolfkill.data.DataManager;

import message.AccountProto;
import message.RoomMsgProto;
import message.core.ClientActionProto;
import message.core.PBMessageProto;

/**
 * Created by Administrator on 2017/6/15.
 */

public class NetManager {

    private static SocketClient socketClient = null;
    private Handler mHandler;//当前界面
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
    public static NetManager getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    public void init() {
        socketClient = new SocketClient();
        socketClient.connet();

        heartBeat();
    }

    public  void sendMessage(PBMessageProto.PBMessage.Builder msg) {
        socketClient.send(msg);
    }

    public void setmHandler(Handler mHandler) {
        this.mHandler = mHandler;
    }

    /**
     * 发送系统数据到主界面
     */
    public void sendMsgToActivity(ByteString msg,int actionCode){
        Message message = Message.obtain();
        message.what = actionCode;
        Bundle bundle = new Bundle();
        bundle.putByteArray("rsp",msg.toByteArray());
        message.setData(bundle);
        mHandler.sendMessage(message);

    }

    //********************************请求响应处理******************************************************

    /**
     * 发送消息到服务器
     * @param msg
     * @param actionCode
     */
    public void sendMsgToServer(ByteString msg,int actionCode){
        PBMessageProto.PBMessage.Builder builder = PBMessageProto.PBMessage.newBuilder();
        builder.setCode(actionCode);
        builder.setData(msg);
        sendMessage(builder);
    }

    /**
     * 心跳包
     */
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

    /**
     *登录
     * @param type
     * @param accountName
     * @param pwd
     */
    public void loginReq(int type,String accountName ,String pwd){
        AccountProto.LoginReq.Builder builder = AccountProto.LoginReq.newBuilder();
        builder.setType(type);
        builder.setAccountName(accountName);
        builder.setPassword(pwd);
        sendMsgToServer(builder.build().toByteString(), ClientActionProto.ClientAction.ACTION_LOGIN_VALUE);
    }
    public void loginRsp(ByteString msg,int actionCode) throws  Exception{
        AccountProto.LoginRsp rsp = AccountProto.LoginRsp.parseFrom(msg);
        //登录成功
        if(rsp.getResult() == AccountProto.LOGIN_RESULT_TYPE.SUCCESS_VALUE){
            DataManager.getInstance().setPlayer(rsp.getPlayer());
        }
        sendMsgToActivity(msg,actionCode);
    }

    /**
     * 创建房间
     */
    public void creatRoomReq(){
        PBMessageProto.PBMessage.Builder builder = PBMessageProto.PBMessage.newBuilder();
        RoomMsgProto.CreatRoomReq.Builder builder1 = RoomMsgProto.CreatRoomReq.newBuilder();
        builder.setPlayerId(DataManager.getInstance().getPlayer().getId());
        builder.setCode(ClientActionProto.ClientAction.ACTION_CREAT_ROOM_VALUE);
        builder.setData(builder1.build().toByteString());
        sendMessage(builder);
    }
    public void creatRoomRsp(ByteString msg,int actionCode) throws  Exception{
        //
        sendMsgToActivity(msg,actionCode);
    }


}

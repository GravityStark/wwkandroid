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
     *
     * rspOrpush  :  0 -->push      ;1 --->rsp
     */
    public void sendMsgToActivity(int rspOrpush,ByteString msg,int actionCode){
        Message message = Message.obtain();
        message.what = actionCode;
        message.arg1 = rspOrpush;
        Bundle bundle = new Bundle();
        bundle.putByteArray("data",msg.toByteArray());
        message.setData(bundle);
        mHandler.sendMessage(message);

    }

    //********************************请求响应处理******************************************************


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
        PBMessageProto.PBMessage.Builder builder = PBMessageProto.PBMessage.newBuilder();
        AccountProto.LoginReq.Builder rebuilder = AccountProto.LoginReq.newBuilder();
        rebuilder.setType(type);
        rebuilder.setAccountName(accountName);
        rebuilder.setPassword(pwd);
        builder.setCode(ClientActionProto.ClientAction.ACTION_LOGIN_VALUE);
        builder.setData(rebuilder.build().toByteString());
        sendMessage(builder);
    }

    /**
     * 创建房间
     */
    public void creatRoomReq(){
        PBMessageProto.PBMessage.Builder builder = PBMessageProto.PBMessage.newBuilder();
        RoomMsgProto.CreatRoomReq.Builder reqBuilder = RoomMsgProto.CreatRoomReq.newBuilder();
        builder.setPlayerId(DataManager.getInstance().getPlayer().getId());
        builder.setCode(ClientActionProto.ClientAction.ACTION_CREAT_ROOM_VALUE);
        builder.setData(reqBuilder.build().toByteString());
        sendMessage(builder);
    }

    /**
     * 加入房间
     */
    public void joinRoomReq(){
        PBMessageProto.PBMessage.Builder builder = PBMessageProto.PBMessage.newBuilder();
        RoomMsgProto.JoinRoomReq.Builder reqBuilder = RoomMsgProto.JoinRoomReq.newBuilder();
        builder.setPlayerId(DataManager.getInstance().getPlayer().getId());
        builder.setCode(ClientActionProto.ClientAction.ACTION_JOIN_ROOM_VALUE);
        builder.setData(reqBuilder.build().toByteString());
        sendMessage(builder);
    }

    /**
     * 退出房间
     * @param id
     */
    public void quitRoomReq(String id){
        PBMessageProto.PBMessage.Builder builder = PBMessageProto.PBMessage.newBuilder();
        RoomMsgProto.QuitRoomReq.Builder reqBuilder = RoomMsgProto.QuitRoomReq.newBuilder();
        reqBuilder.setId(id);

        builder.setPlayerId(DataManager.getInstance().getPlayer().getId());
        builder.setCode(ClientActionProto.ClientAction.ACTION_QUIT_ROOM_VALUE);
        builder.setData(reqBuilder.build().toByteString());
        sendMessage(builder);
    }

    /**
     * 发送消息
     * @param content
     */
    public void sendTxtMsgToRoomReq(String content){
        PBMessageProto.PBMessage.Builder builder = PBMessageProto.PBMessage.newBuilder();
        RoomMsgProto.SendTxtMsgReq.Builder reqBuilder = RoomMsgProto.SendTxtMsgReq.newBuilder();
        reqBuilder.setId(DataManager.getInstance().getRoom().getId());
        reqBuilder.setContent(content);
        builder.setPlayerId(DataManager.getInstance().getPlayer().getId());
        builder.setCode(ClientActionProto.ClientAction.ACTION_SEND_TXT_MSG_VALUE);
        builder.setData(reqBuilder.build().toByteString());
        sendMessage(builder);
    }
}

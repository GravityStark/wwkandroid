package com.werwolfkill.net;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.google.protobuf.ByteString;

import message.AccountProto;
import message.PlayerProto;
import message.RoomMsgProto;
import message.core.ClientActionProto;
import message.core.PBMessageProto;

/**
 * Created by Administrator on 2017/6/15.
 */

public class NetManager {

    private static SocketClient socketClient = null;
    private Handler mHandler;//当前界面
    private PlayerProto.PlayerMsg player;
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

    public void setmHandler(Handler mHandler) {
        this.mHandler = mHandler;
    }

    /**
     * 发送系统数据到主界面
     */
    public void sendSystemMsgToMainActivity(String content,int result){
        StringBuilder senderBuilder = new StringBuilder();
        senderBuilder.append("系统消息-->");

        StringBuilder contentBuilder = new StringBuilder(content);


        Message message = Message.obtain();
        message.what = result;
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

    /**
     * 发送登录界面
     */
    public void sendLoginActivity(int result){
        Message message = Message.obtain();
        message.what = result;
        mHandler.sendMessage(message);
    }

    public void loginReq(int type,String accountName ,String pwd){
        AccountProto.LoginReq.Builder builder = AccountProto.LoginReq.newBuilder();
        builder.setType(type);
        builder.setAccountName(accountName);
        builder.setPassword(pwd);
        sendMsgToServer(builder.build().toByteString(), ClientActionProto.ClientAction.ACTION_LOGIN_VALUE);
    }
    public void loginRsp(ByteString msg) throws  Exception{
        AccountProto.LoginRsp rsp = AccountProto.LoginRsp.parseFrom(msg);
        player = rsp.getPlayer();

        sendLoginActivity(rsp.getResult());
    }
    public void creatRoomReq(){
        PBMessageProto.PBMessage.Builder builder = PBMessageProto.PBMessage.newBuilder();
        RoomMsgProto.CreatRoomReq.Builder builder1 = RoomMsgProto.CreatRoomReq.newBuilder();
        builder.setPlayerId(player.getId());
        builder.setCode(ClientActionProto.ClientAction.ACTION_CREAT_ROOM_VALUE);
        builder.setData(builder1.build().toByteString());
        sendMessage(builder);
    }
    public void creatRoomRsp(ByteString msg) throws  Exception{
        RoomMsgProto.CreatRoomRsp rsp = RoomMsgProto.CreatRoomRsp.parseFrom(msg);
        RoomMsgProto.RoomMsg room = rsp.getRoom();
        //

        sendSystemMsgToMainActivity(player.getName()+"加入游戏",1);

    }
    public void sendMsgToServer(ByteString msg,int actionCode){
        PBMessageProto.PBMessage.Builder builder = PBMessageProto.PBMessage.newBuilder();
        builder.setCode(actionCode);
        builder.setData(msg);
        sendMessage(builder);
    }
}

package com.werwolfkill.net;


import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import message.core.ClientActionProto;
import message.core.PBMessageProto;

/**
 * Created by liuwei on 2017/6/15.
 */

public class SocketClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        super.channelRead(ctx, msg);
        //解析消息
        PBMessageProto.PBMessage pbMessage = (PBMessageProto.PBMessage)msg;
        if(pbMessage.hasCode()){
            int actionCode = pbMessage.getCode();
            switch(actionCode){
                case ClientActionProto.ClientAction.ACTION_LOGIN_VALUE:
                    NetManager.getInstance().loginRsp(pbMessage.getData());
                    break;
                case ClientActionProto.ClientAction.ACTION_CREAT_ROOM_VALUE:
                    NetManager.getInstance().creatRoomRsp(pbMessage.getData());
                    break;
            }
        }else if(pbMessage.hasPushCode()){

        }
    }
}

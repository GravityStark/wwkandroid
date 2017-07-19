package com.werwolfkill.net;


import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
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
            NetManager.getInstance().sendMsgToActivity(1,pbMessage.getData(),pbMessage.getCode());
        }else if(pbMessage.hasPushCode()){
            NetManager.getInstance().sendMsgToActivity(0,pbMessage.getData(),pbMessage.getPushCode());
        }
    }
}

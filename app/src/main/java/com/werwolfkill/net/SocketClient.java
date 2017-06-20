package com.werwolfkill.net;


import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import message.core.PBMessageProto;

/**
 * Created by Administrator on 2017/6/15.
 */

public class SocketClient {
    private Bootstrap bootstrap = null;
    private NioEventLoopGroup group = null;
    private String host = "192.168.0.222";// 服务器ip
    private int port = 28000;// 服务器端口
    private Channel channel = null; // 客戶端連接

    /**
     * 连接服务器
     * @return
     */
    public boolean connet() {
        group = new NioEventLoopGroup();
        bootstrap = new Bootstrap();

        bootstrap.group(group).channel(NioSocketChannel.class).handler(new SocketClientInitializer());
        ChannelFuture f = null;
        try {
            f = bootstrap.connect(host, port).sync();
        } catch (InterruptedException e) {
            return false;
        }
        channel = f.channel();
        return true;
    }

    public void send(PBMessageProto.PBMessage.Builder msg){
        channel.writeAndFlush(msg);
    }
}

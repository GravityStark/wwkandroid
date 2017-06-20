package com.werwolfkill.net;


import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.SocketChannelConfig;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import message.core.PBMessageProto;

public class SocketClientInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        SocketChannelConfig config = ch.config();
        config.setOption(ChannelOption.SO_KEEPALIVE, true);
        config.setOption(ChannelOption.SO_REUSEADDR, true);
        config.setOption(ChannelOption.SO_BACKLOG, 128);
        config.setOption(ChannelOption.SO_TIMEOUT, 30000);
        config.setOption(ChannelOption.ALLOW_HALF_CLOSURE, true);
        config.setOption(ChannelOption.TCP_NODELAY,true);
        config.setOption(ChannelOption.CONNECT_TIMEOUT_MILLIS,3000);

        ChannelPipeline pipeline = ch.pipeline();
//        pipeline.addLast("inboundHandler", new InboundServerHandler());
//        pipeline.addLast("outboundHandler", new OutboundServerHandler());
        pipeline.addLast(new ProtobufVarint32FrameDecoder());
        pipeline.addLast(new ProtobufDecoder(PBMessageProto.PBMessage.getDefaultInstance()));
        pipeline.addLast(new ProtobufVarint32LengthFieldPrepender());
        pipeline.addLast(new ProtobufEncoder());
        pipeline.addLast(new SocketClientHandler());
    }
}

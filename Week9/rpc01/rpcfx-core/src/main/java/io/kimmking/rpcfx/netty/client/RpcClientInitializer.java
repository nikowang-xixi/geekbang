package io.kimmking.rpcfx.netty.client;

import io.kimmking.rpcfx.netty.common.RpcDecoder;
import io.kimmking.rpcfx.netty.common.RpcEncoder;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/**
 * @author xixi
 */
public class RpcClientInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast("Message Encoder", new RpcEncoder());
        pipeline.addLast("Message Decoder", new RpcDecoder());
        pipeline.addLast("clientHandler", new RpcClientSyncHandler());
    }
}

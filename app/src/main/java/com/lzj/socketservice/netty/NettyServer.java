package com.lzj.socketservice.netty;

import com.lzj.socketservice.constants.Constants;
import com.lzj.socketservice.entity.EventBean;
import com.lzj.socketservice.utils.MLog;

import org.greenrobot.eventbus.EventBus;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Description: 作用描述
 * Author: Lzj
 * CreateDate: 2020/4/22
 */
public class NettyServer {

    private static NettyServer INSTANCE;
    private NettyServer() {
    }
    public static NettyServer getInstance() {
        if (INSTANCE == null) {
            synchronized (NettyServer.class) {
                if (INSTANCE == null) {
                    INSTANCE = new NettyServer();
                }
            }
        }
        return INSTANCE;
    }

    public  void start() throws InterruptedException{
        EventLoopGroup mBoss = new NioEventLoopGroup();
        EventLoopGroup mWorkerGroup = new NioEventLoopGroup();
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(mBoss, mWorkerGroup)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 128)
                .childOption(ChannelOption.TCP_NODELAY, true)
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        ChannelPipeline pipeline = socketChannel.pipeline();
                        pipeline.addLast(new NettyServerHandler());
                    }
                });
        ChannelFuture future=bootstrap.bind(Constants.SOCKET_PORT).sync();
        if(future.isSuccess()){
            MLog.e("test","--------------服务器启动成功");
            EventBus.getDefault().post(new EventBean(1, "启动成功"));
        }
    }

}

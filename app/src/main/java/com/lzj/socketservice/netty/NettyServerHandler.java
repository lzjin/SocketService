package com.lzj.socketservice.netty;

import android.util.Log;

import com.lzj.socketservice.entity.EventBean;
import com.lzj.socketservice.utils.MLog;

import org.greenrobot.eventbus.EventBus;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

/**
 * Description: 作用描述
 * Author: Lzj
 * CreateDate: 2020/4/22
 */
public class NettyServerHandler extends SimpleChannelInboundHandler<Object> {
    /**
     * 连接成功时触发
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        EventBus.getDefault().post(new EventBean(2, "成员登陆成功"));
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
        Log.e("test", "-------检测客服端疑似掉线-----");
        EventBus.getDefault().post(new EventBean(2, "检测到成员疑似掉线"));
    }
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
        Log.e("test", "-----服务器出现异常!");
        EventBus.getDefault().post(new EventBean(1, "服务器出现异常,马上重启"));
        NettyServer.getInstance().start();
    }
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Object objMsg) throws Exception {
        String msg=((ByteBuf)objMsg).toString(CharsetUtil.UTF_8).trim();
        Log.e("test","--------------我是服务器收到客服消息："+msg);
        ByteBuf byf= Unpooled.wrappedBuffer(("我是服务器:"+msg+",回复了").getBytes((CharsetUtil.UTF_8)));
        channelHandlerContext.writeAndFlush(byf);
    }
}

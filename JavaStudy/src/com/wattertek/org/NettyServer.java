package com.wattertek.org;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ChannelBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;

public class NettyServer
{
    public static void main(String[] args)
    {
        ServerBootstrap serverBootstrap = new ServerBootstrap();

        NioEventLoopGroup boos = new NioEventLoopGroup();
        NioEventLoopGroup worker = new NioEventLoopGroup();

        serverBootstrap
                .group(boos, worker)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<NioServerSocketChannel>() {
                    protected void initChannel(NioSocketChannel ch) {
                        ch.pipeline().addLast(new StringDecoder());
                        ch.pipeline().addLast(new ChannelInboundHandler() {
                            @Override
                            public ChannelBuf newInboundBuffer(ChannelHandlerContext channelHandlerContext) throws Exception {
                                return null;
                            }

                            @Override
                            public void freeInboundBuffer(ChannelHandlerContext channelHandlerContext, ChannelBuf channelBuf) throws Exception {

                            }

                            @Override
                            public void channelRegistered(ChannelHandlerContext channelHandlerContext) throws Exception {

                            }

                            @Override
                            public void channelUnregistered(ChannelHandlerContext channelHandlerContext) throws Exception {

                            }

                            @Override
                            public void channelActive(ChannelHandlerContext channelHandlerContext) throws Exception {

                            }

                            @Override
                            public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {

                            }

                            @Override
                            public void inboundBufferUpdated(ChannelHandlerContext channelHandlerContext) throws Exception {

                            }

                            @Override
                            public void beforeAdd(ChannelHandlerContext channelHandlerContext) throws Exception {

                            }

                            @Override
                            public void afterAdd(ChannelHandlerContext channelHandlerContext) throws Exception {

                            }

                            @Override
                            public void beforeRemove(ChannelHandlerContext channelHandlerContext) throws Exception {

                            }

                            @Override
                            public void afterRemove(ChannelHandlerContext channelHandlerContext) throws Exception {

                            }

                            @Override
                            public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable throwable) throws Exception {

                            }

                            @Override
                            public void userEventTriggered(ChannelHandlerContext channelHandlerContext, Object o) throws Exception {

                            }
                        });
                    }
                }).bind(8080);
    }
}


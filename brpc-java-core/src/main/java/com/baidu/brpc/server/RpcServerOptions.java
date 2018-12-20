/*
 * Copyright (c) 2018 Baidu, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.baidu.brpc.server;

import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by wenweihu86 on 2017/4/24.
 */
@Setter
@Getter
@ToString
public class RpcServerOptions {
    // if http server, isHttp should be true.
    private boolean isHttp = false;

    // The keep alive
    private boolean keepAlive = true;

    private boolean tcpNoDelay = true;

    // so linger
    private int soLinger = 5;

    // backlog
    private int backlog = 1024;

    // receive buffer size
    private int receiveBufferSize = 1024 * 64;

    // send buffer size
    private int sendBufferSize = 1024 * 64;

    /**
     * an {@link IdleStateEvent} whose state is {@link IdleState#READER_IDLE}
     * will be triggered when no read was performed for the specified period of time.
     * Specify {@code 0} to disable.
     */
    private int readerIdleTime = 60;

    /**
     * an {@link IdleStateEvent} whose state is {@link IdleState#WRITER_IDLE}
     * will be triggered when no write was performed for the specified period of time.
     * Specify {@code 0} to disable.
     */
    private int writerIdleTime = 60;

    // keepAlive时间（second）
    private int keepAliveTime = 5;

    // acceptor threads, default use Netty default value
    private int acceptorThreadNum = 1;

    // io threads, default use Netty default value
    private int ioThreadNum = Runtime.getRuntime().availableProcessors();

    // real work threads
    private int workThreadNum = Runtime.getRuntime().availableProcessors();

    // The max size
    private int maxSize = Integer.MAX_VALUE;

    // server protocol type
    private Integer protocolType;

    private String encoding = "utf-8";

    // bns port name when deploys on Jarvis environment
    private String jarvisPortName;

    // naming service url
    private String namingServiceUrl = "";

    // service group
    private String namingServiceGroup = "";

    // service version
    private String namingServiceVersion = "";

    /**
     * if metaHttpPort > 0, brpc will open meta info function.
     * if metaHttpPort > 0 && isHttp = false, brpc will start tcp server and http server,
     * tcp port is from the parameter of RpcServer, and http port is from metaHttpPort.
     * if metaHttpPort > 0 && isHttp = true, brpc will start one http server only,
     * the http port will use the parameter of RpcServer, NOT the metaHttpPort.
     */
    private int metaHttpPort = 0;
}

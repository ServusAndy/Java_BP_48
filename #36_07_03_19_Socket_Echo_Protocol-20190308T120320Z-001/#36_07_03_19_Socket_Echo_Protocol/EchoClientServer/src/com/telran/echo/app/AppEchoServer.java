package com.telran.echo.app;

import com.telran.echo.core.EchoApi;
import com.telran.echo.core.EchoProtocol;
import com.telran.net.server.TcpServer;

import java.io.IOException;

public class AppEchoServer {
    public static void main(String[] args) throws IOException {
        TcpServer server = new TcpServer(EchoApi.PORT,new EchoProtocol());
        server.run();
    }
}

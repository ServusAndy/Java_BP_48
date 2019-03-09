package com.telran.net.server;

import com.telran.protocol.Protocol;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
    int port;
    Protocol protocol;
    ServerSocket serverSocket;

    public TcpServer(int port, Protocol protocol) throws IOException {
        this.port = port;
        this.protocol = protocol;
        serverSocket = new ServerSocket(port);
    }

    public void run(){
        System.out.println("server listening port " + port);
        try {
            while (true) {
                Socket socket = serverSocket.accept();
                SessionHandler handler = new SessionHandler(protocol,socket);
                handler.run();
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
}

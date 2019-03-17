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
        this.serverSocket = new ServerSocket(port);
    }

    public void run(){
        System.out.println("Server listening port " + port);
        try{
            while(true){
                System.out.println("Waiting client!");
                Socket socket = serverSocket.accept();
                System.out.println("Client: " + socket.getRemoteSocketAddress());
                HttpSessionHandler handler = new HttpSessionHandler(protocol,socket);
                handler.run();
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
}

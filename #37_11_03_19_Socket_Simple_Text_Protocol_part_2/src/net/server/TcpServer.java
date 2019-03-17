package net.server;

import protocol.Protocol;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
    ServerSocket serverSocket;
    int port;
    Protocol protocol;

    public TcpServer(int port, Protocol protocol) throws IOException {
        this.port = port;
        serverSocket = new ServerSocket(port);
        this.protocol = protocol;
    }

    public void run() {
        System.out.println("Server running on port: " + port);
        try {
            while(true){
                Socket socket = serverSocket.accept();
                SessionHandler handler = new SessionHandler(socket,protocol);
                handler.run();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}














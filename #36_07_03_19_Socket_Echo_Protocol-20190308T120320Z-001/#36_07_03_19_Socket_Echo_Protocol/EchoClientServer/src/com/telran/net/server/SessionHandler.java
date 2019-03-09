package com.telran.net.server;

import com.telran.protocol.Protocol;
import com.telran.protocol.ProtocolRequest;
import com.telran.protocol.ProtocolResponse;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;

public class SessionHandler {
    Protocol protocol;
    Socket socket;

    public SessionHandler(Protocol protocol, Socket socket) {
        this.protocol = protocol;
        this.socket = socket;
    }

    public void run() {
        try (Socket socket = this.socket;
             ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
             ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream())) {
            while (true){
                ProtocolRequest request = (ProtocolRequest) input.readObject();
                System.out.println("Client: " + socket.getRemoteSocketAddress() + "\n\t" + request);
                ProtocolResponse response = protocol.getResponse(request);
                System.out.println("\t" + response);
                output.writeObject(response);
                output.reset();
            }
        } catch (SocketException ex) {
            System.out.println("Client closed connection");
        } catch (IOException e) {
            System.out.println("error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

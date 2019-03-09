package com.telran.net.client;

import com.telran.protocol.ProtocolRequest;
import com.telran.protocol.ProtocolResponse;

import java.io.*;
import java.net.Socket;

public class TcpClient implements Closeable {
    Socket socket;
    protected ObjectOutputStream output;
    protected ObjectInputStream input;

    public TcpClient(String host, int port) throws IOException {
        socket = new Socket(host, port);
        System.out.println("Client starting on port " + socket.getLocalPort());
        output = new ObjectOutputStream(socket.getOutputStream());
        input = new ObjectInputStream(socket.getInputStream());
    }

    protected <T> T sendRequest(String type, Serializable data){
        ProtocolRequest request = new ProtocolRequest(type, data);
        try{
            output.writeObject(request);
            ProtocolResponse response = (ProtocolResponse) input.readObject();
            if (response.code != ProtocolResponse.Code.OK){
                throw new RuntimeException(response.code.toString());
            }
            return (T) response.data;
        }catch (Exception ex){
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public void close() throws IOException {
        socket.close();
    }
}

package com.telran.echo.core;

import com.telran.net.client.TcpClient;

import java.io.IOException;

public class EchoClient extends TcpClient {

    public EchoClient(String host) throws IOException {
        super(host, EchoApi.PORT);
    }

    public String sendEchoRequest(String data){
        String response = sendRequest(EchoApi.RequestType.ECHO,data);
        return response;
    }

    public Integer sendLengthRequest(String data){
        Integer response = sendRequest(EchoApi.RequestType.LENGTH,data);
        return response;
    }
}

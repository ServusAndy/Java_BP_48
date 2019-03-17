package com.telran.echo.core;

import com.telran.net.client.HttpClient;
import com.telran.protocol.HttpRequest;
import com.telran.protocol.HttpResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class EchoHttpClient extends HttpClient {

    Map<String,String> headers;
    public EchoHttpClient(String host) throws IOException {
        super(host, EchoApi.PORT);
        headers = new HashMap<>();
        headers.put("Host",host);
    }

    public String sendEchoRequest(String string) {
        HttpResponse response = sendRequest(HttpRequest.Method.POST,EchoApi.RequestPath.ECHO, headers,string);
        return response.body;
    }
}

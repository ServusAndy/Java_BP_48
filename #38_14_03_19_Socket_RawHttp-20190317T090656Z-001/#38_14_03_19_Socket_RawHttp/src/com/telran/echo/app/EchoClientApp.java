package com.telran.echo.app;

import com.telran.echo.core.EchoHttpClient;

import java.io.IOException;

public class EchoClientApp {
    public static void main(String[] args) throws IOException {
        try(EchoHttpClient client = new EchoHttpClient("localhost")){
            client.sendEchoRequest("Hello World");
        }
    }
}

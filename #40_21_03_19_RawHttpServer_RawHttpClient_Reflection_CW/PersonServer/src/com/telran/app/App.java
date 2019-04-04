package com.telran.app;

import com.telran.controllers.PersonController;
import com.telran.net.TcpServer;
import com.telran.protocol.Protocol;
import com.telran.services.PersonService;
import com.telran.services.PersonServiceImpl;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        PersonService service = new PersonServiceImpl();
        Protocol protocol = new PersonController(service);
        TcpServer server = new TcpServer(2000,protocol);
        server.run();
    }
}

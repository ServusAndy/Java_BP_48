package com.telran.echo.app;

import com.telran.echo.core.EchoClient;
import com.telran.view.ConsoleInputOutput;
import com.telran.view.InputOutput;
import com.telran.view.Item;
import com.telran.view.Menu;

import java.io.IOException;

public class AppEchoClient {
    public static void main(String[] args) throws IOException {
        try(EchoClient client = new EchoClient("localhost")){
            InputOutput cio = new ConsoleInputOutput();
            Menu menu = new Menu("Main",
                    Item.of("Echo",io ->{
                        String str = io.readString("Type text");
                        String response = client.sendEchoRequest(str);
                        System.out.println(response);
                    }),
                    Item.of("Length",io->{
                        String str = io.readString("Type text");
                        Integer response = client.sendLengthRequest(str);
                        System.out.println("Length: " + response);
                    }),
                    Item.exit());
            menu.perform(cio);
        }
    }
}

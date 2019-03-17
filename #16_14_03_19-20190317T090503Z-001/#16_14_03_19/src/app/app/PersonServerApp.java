package app.app;

import app.core.PersonApi;
import app.core.SimpleTextPersonProtocol;
import net.server.TcpServer;

import java.io.IOException;

public class PersonServerApp {
    public static void main(String[] args) throws IOException {
        TcpServer server = new TcpServer(PersonApi.PORT, new SimpleTextPersonProtocol());
        server.run();
    }
}

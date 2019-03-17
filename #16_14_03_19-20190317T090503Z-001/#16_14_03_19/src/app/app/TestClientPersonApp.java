package app.app;

import app.core.Person;
import app.core.PersonApi;
import protocol.Protocol;
import protocol.ProtocolRequest;

import java.io.*;
import java.net.Socket;

public class TestClientPersonApp {
    public static void main(String[] args) throws IOException {
        testAddsPersonFirst();
        testAddPersonSecond();
        testGetPerson();
        testRemove();
        testGetPerson();
    }

    public static void testAddsPersonFirst() throws IOException {
        Person p = new Person(123,"Vasya","Pupkin","1234567");
        Socket socket = new Socket("localhost", PersonApi.PORT);
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        ProtocolRequest request = ProtocolRequest.of(PersonApi.RequestType.ADD,p.toString());
        bw.write(request.getType());
        bw.newLine();
        bw.write(request.getData());
        bw.newLine();
        bw.flush();
        String code = br.readLine();
        String data = br.readLine();
        bw.close();
        br.close();
        socket.close();
        System.out.println(code + " " + data);
    }

    public static void testGetPerson() throws IOException {
        Socket socket = new Socket("localhost", PersonApi.PORT);
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        ProtocolRequest request = ProtocolRequest.of(PersonApi.RequestType.GET_BY_ID,"321");

        bw.write(request.getType());
        bw.newLine();
        bw.write(request.getData());
        bw.newLine();
        bw.flush();

        String code = br.readLine();
        String data = br.readLine();
        bw.close();
        br.close();
        socket.close();
        System.out.println(code + " " + data);
    }
    public static void testAddPersonSecond() throws IOException {
        Person p = new Person(321,"Petya","Ivanov","7654321");
        Socket socket = new Socket("localhost", PersonApi.PORT);
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        ProtocolRequest request = ProtocolRequest.of(PersonApi.RequestType.ADD,p.toString());
        bw.write(request.getType());
        bw.newLine();
        bw.write(request.getData());
        bw.newLine();
        bw.flush();
        String code = br.readLine();
        String data = br.readLine();
        bw.close();
        br.close();
        socket.close();
        System.out.println(code + " " + data);
    }

    public static void testRemove() throws IOException {
        Socket socket = new Socket("localhost", PersonApi.PORT);
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        ProtocolRequest request = ProtocolRequest.of(PersonApi.RequestType.DELETE,"321");
        bw.write(request.getType());
        bw.newLine();
        bw.write(request.getData());
        bw.newLine();
        bw.flush();
        String code = br.readLine();
        String data = br.readLine();
        bw.close();
        br.close();
        socket.close();
        System.out.println(code + " " + data);
    }
}

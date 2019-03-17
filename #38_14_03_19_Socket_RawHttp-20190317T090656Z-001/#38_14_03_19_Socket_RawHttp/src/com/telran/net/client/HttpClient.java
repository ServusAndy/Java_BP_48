package com.telran.net.client;

import com.telran.protocol.HttpRequest;
import com.telran.protocol.HttpResponse;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class HttpClient implements Closeable{
    Socket socket;
    protected BufferedWriter bw;
    protected BufferedReader br;

    public HttpClient(String host, int port) throws IOException {
        socket = new Socket(host,port);
        System.out.println("Client starting on port " + socket.getLocalPort());
        bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public HttpResponse sendRequest(HttpRequest.Method method, String path, Map<String, String> headers, String body){
        HttpRequest request = new HttpRequest(method, path, headers, body);
        System.out.println("-------------");
        System.out.println("<<<Request>>>");
        System.out.println(request);
        try {
            bw.write(request.toString());
            bw.flush();
            HttpResponse response = readResponse(br);
            System.out.println("-------------");
            System.out.println("<<<Response>>>");
            System.out.println(response);
            return response;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private HttpResponse readResponse(BufferedReader br) {
        try {
            //Read startLine and parse
            String startingLine = br.readLine();
            String[] startLineArgs = startingLine.split(" ");
            int code = Integer.parseInt(startLineArgs[1]);
            String reasonPhrase = null;
            if(startLineArgs.length == 3){
                reasonPhrase = startLineArgs[2];
            }

            //Read headers and parse
            Map<String, String> headers = new HashMap<>();
            String header = br.readLine();
            while (!header.isEmpty()) {
                String[] arr = header.split(":");
                headers.put(arr[0], arr[1]);
                header = br.readLine();
            }

            //Read body and parse
            StringBuilder bodyBuilder = new StringBuilder();
            try {
                int totalLength = 1;
                if(headers.containsKey("Content-Length")){
                    totalLength = Integer.parseInt(headers.get("Content-Length"));
                }
                if(totalLength > 0){
                    String bodyLine = br.readLine();
                    bodyBuilder.append(bodyLine);
                    int readCount = bodyLine.length();
                    while(readCount < totalLength){
                        bodyLine = br.readLine();
                        if (bodyLine == null){
                            break;
                        }
                        readCount += bodyLine.length();
                    }
                }
            }catch (IOException ex){
                System.out.println("Server closed input");
            }
            return new HttpResponse(code,reasonPhrase,headers,bodyBuilder.toString());
        }catch (Exception ex){
            throw new RuntimeException("Wrong http protocol format!");
        }
    }

    @Override
    public void close() throws IOException {
        socket.close();
    }
}

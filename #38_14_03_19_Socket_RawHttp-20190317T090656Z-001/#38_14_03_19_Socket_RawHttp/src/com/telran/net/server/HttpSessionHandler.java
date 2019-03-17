package com.telran.net.server;

import com.telran.protocol.HttpRequest;
import com.telran.protocol.HttpResponse;
import com.telran.protocol.Protocol;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;

public class HttpSessionHandler {
    Protocol protocol;
    Socket socket;

    public HttpSessionHandler(Protocol protocol, Socket socket) {
        this.protocol = protocol;
        this.socket = socket;
    }

    public void run(){
        try (Socket socket = this.socket;
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
             BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            HttpResponse response;
            try {
                HttpRequest request = readRequest(br);
                System.out.println("----------");
                System.out.println("Request: \n" + request);
                response = protocol.getResponse(request);

            }catch (Exception ex){
                response = protocol.getErrorResponse(HttpResponse.ResponseCode.BAD_REQUEST,"Bad_Request",ex.getMessage());
            }
            System.out.println("-------------");
            System.out.println("Request");
            System.out.println(response);
            bw.write(response.toString());
            bw.flush();
        } catch (SocketException ex) {
            System.out.println("Client closed connection");
        }catch (IOException ex){
            System.out.println("Error: " + ex.getMessage());
        }
    }

    private HttpRequest readRequest(BufferedReader br) throws IOException {
        try {
            //Read startLine and parse
            String startingLine = br.readLine();
            String[] startLineArgs = startingLine.split(" ");
            HttpRequest.Method method = HttpRequest.Method.valueOf(startLineArgs[0]);
            String path = startLineArgs[1];

            //Read headers and parse
            Map<String, String> headers = new HashMap<>();
            String header = br.readLine();
            while (header.length() > 0) {
                String[] arr = header.split(":");
                headers.put(arr[0].trim(), arr[1].trim());
                header = br.readLine();
            }

            //Read body and parse
            StringBuilder bodyBuilder = new StringBuilder();
            try {
                int totalLength = 1;
                if(headers.containsKey("Content-Length")){
                    totalLength = Integer.parseInt(headers.get("Content-Length"));
                }
                if(method != HttpRequest.Method.GET && totalLength > 0){
                    String bodyLine = br.readLine();
                    bodyBuilder.append(bodyLine);
                    int readCount = bodyLine.length();
                    System.out.println(readCount);
                    while(readCount < totalLength){
                        bodyLine = br.readLine();
                        if (bodyLine == null){
                            break;
                        }
                        readCount += bodyLine.length();
                    }
                }
            }catch (IOException ex){
                System.out.println("Client closed input!");
            }

            return new HttpRequest(method,path,headers,bodyBuilder.toString());

        }catch (Exception ex){
            ex.printStackTrace();
            throw new HttpFormatException("Wrong http protocol format!" + ex.getMessage());
        }
    }
}

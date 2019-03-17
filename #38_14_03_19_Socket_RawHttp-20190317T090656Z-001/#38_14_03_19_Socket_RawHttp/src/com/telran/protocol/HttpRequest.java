package com.telran.protocol;

import java.util.Map;

public class HttpRequest {
    public static enum Method{
        GET,POST,PUT,DELETE
    }
    public Method method;
    public String path;
    public Map<String,String> headers;
    public String body;

    public HttpRequest(Method method, String path, Map<String, String> headers, String body) {
        this.method = method;
        this.path = path;
        this.headers = headers;
        this.body = body;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(method + " " + path + " HTTP/1.1" + "\r\n");
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            builder.append(entry.getKey() + ":" + entry.getValue() + "\r\n");
        }
        builder.append("\r\n");
        if(body!=null) {
            builder.append(body + "\r\n");
        }
        return builder.toString();
    }
}

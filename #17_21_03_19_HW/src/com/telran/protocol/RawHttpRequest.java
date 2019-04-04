package com.telran.protocol;

import java.net.URI;
import java.util.Map;

public class RawHttpRequest {
    public static enum Method {
        GET, POST, PUT, DELETE
    }

    public Method method;
    public URI uri;
    public Map<String, String> headers;
    public String body;

    public RawHttpRequest(Method method, URI uri, Map<String, String> headers, String body) {
        this.method = method;
        this.uri = uri;
        this.headers = headers;
        this.body = body;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(method + " " + uri.toString() + " HTTP/1.1\r\n");
        for (Map.Entry<String, String> header : headers.entrySet()) {
            builder.append(header.getKey())
                    .append(":")
                    .append(header.getValue())
                    .append("\r\n");
        }
        builder.append("\r\n");
        if(body!=null){
            builder.append(body);
        }
        return builder.toString();
    }
}
















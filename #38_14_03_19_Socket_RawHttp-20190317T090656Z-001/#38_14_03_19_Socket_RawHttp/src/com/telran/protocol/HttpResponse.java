package com.telran.protocol;

import java.util.Map;

public class HttpResponse {
    public static class ResponseCode{
        public static final int OK = 200;
        public static final int CREATED = 201;
        public static final int NO_CONTENT = 204;
        public static final int BAD_REQUEST = 400;
        public static final int FORBIDDEN = 403;
        public static final int NOT_FOUND = 404;
        public static final int CONFLICT = 409;
        public static final int SERVER_ERROR = 500;
    }
    public int code;
    public String reasonPhrase;
    public Map<String,String> headers;
    public String body;

    public HttpResponse(int code, String reasonPhrase, Map<String, String> headers, String body) {
        this.code = code;
        this.reasonPhrase = reasonPhrase;
        this.headers = headers;
        this.body = body;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("HTTP/1.1 " + code);
        if (reasonPhrase != null) {
            builder.append(" " + reasonPhrase);
        }
        builder.append("\r\n");
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            builder.append(entry.getKey() + ":" + entry.getValue() + "\r\n");
        }
        builder.append("\r\n");
        if(body!=null) {
            builder.append(body);
        }
        return builder.toString();
    }
}

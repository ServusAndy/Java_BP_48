package com.telran.echo.core;

import com.telran.protocol.HttpRequest;
import com.telran.protocol.HttpResponse;
import com.telran.protocol.Protocol;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class EchoHttpProtocol implements Protocol {
    private HashMap<String, String> headers;
    private Map<String, Function<HttpRequest,HttpResponse>> mappings;

    public EchoHttpProtocol() {
        headers = new HashMap<>();
        mappings = new HashMap<>();
        headers.put("Server","TelRan Echo Server");
        mappings.put(EchoApi.RequestPath.ECHO,this::echo);
    }

    @Override
    public HttpResponse getResponse(HttpRequest request) {
        try {
            String requestType = request.path;
            var mappedFunc = mappings.get(requestType);
            if (mappedFunc == null)
                throw new Exception("Wrong path " + request.path);
            return mappedFunc.apply(request);
        } catch (Exception e) {
            return getErrorResponse(HttpResponse.ResponseCode.NOT_FOUND,"NOT_FOUND",e.getMessage());
        }
    }

    @Override
    public HttpResponse getErrorResponse(int code, String reasonPhrase, String errorBody) {
        headers.put("Date", LocalDateTime.now().toString());
        return new HttpResponse(code,reasonPhrase,headers,errorBody);
    }

    private HttpResponse echo(HttpRequest request){
        headers.put("Date", LocalDateTime.now().toString());
        return new HttpResponse(HttpResponse.ResponseCode.OK,"OK",headers, "Echo: " + request.body);
    }
}

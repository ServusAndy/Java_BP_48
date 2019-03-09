package com.telran.echo.core;

import com.telran.protocol.Protocol;
import com.telran.protocol.ProtocolRequest;
import com.telran.protocol.ProtocolResponse;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class EchoProtocol implements Protocol {
    private Map<String, Function<ProtocolRequest,ProtocolResponse>> mapper;

    public EchoProtocol() {
        mapper = new HashMap<>();
        mapper.put(EchoApi.RequestType.ECHO,this::echo);
        mapper.put(EchoApi.RequestType.LENGTH, this::length);
    }

    @Override
    public ProtocolResponse getResponse(ProtocolRequest request) {
        try{
            String type = request.type;
            Function<ProtocolRequest,ProtocolResponse> mappedFunc = mapper.get(type);
            if(mappedFunc == null){
                throw new Exception("Unsupported requestType: " + type);
            }
            return mappedFunc.apply(request);
        }catch (Exception ex){
            return new ProtocolResponse(ProtocolResponse.Code.WRONG_REQUEST, ex.getMessage());
        }
    }

    public ProtocolResponse echo(ProtocolRequest request){
        String data = (String) request.data;
        return new ProtocolResponse(ProtocolResponse.Code.OK, "echo: " + data);
    }

    public ProtocolResponse length(ProtocolRequest request){
        String data = (String) request.data;
        int length = data.length();
        return new ProtocolResponse(ProtocolResponse.Code.OK, length);
    }
}

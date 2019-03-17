package app.core;

import protocol.Protocol;
import protocol.ProtocolRequest;
import protocol.ProtocolResponse;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class SimpleTextPersonProtocol implements Protocol {
    private Map<Integer, Person> persons;
    private Map<String, Function<ProtocolRequest,ProtocolResponse>> mapper;

    public SimpleTextPersonProtocol() {
        persons = new HashMap<>();
        mapper = new HashMap<>();
        mapper.put(PersonApi.RequestType.ADD,this::addPerson);
        mapper.put(PersonApi.RequestType.DELETE, this::removeById);
        mapper.put(PersonApi.RequestType.GET_BY_ID, this::getById);
    }

    @Override
    public ProtocolResponse getResponse(ProtocolRequest request) {
        try{
            String type = request.getType();
            Function<ProtocolRequest,ProtocolResponse> mapFunc = mapper.get(type);
            if(mapFunc == null){
                throw new Exception("Unsupported request type: " + type);
            }
            return mapFunc.apply(request);
        }catch (Exception ex){
            return ProtocolResponse.of(ProtocolResponse.Code.BAD_REQUEST.toString(), ex.getMessage());
        }
    }

    private ProtocolResponse getById(ProtocolRequest protocolRequest) {
        //ToDo implement method
        return null;
    }

    private ProtocolResponse removeById(ProtocolRequest protocolRequest) {
        //ToDo implement method
        return null;
    }

    private ProtocolResponse addPerson(ProtocolRequest protocolRequest) {
        //ToDo implement method
        return null;
    }
}

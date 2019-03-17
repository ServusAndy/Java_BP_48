package app.core;

import protocol.Protocol;
import protocol.ProtocolRequest;
import protocol.ProtocolResponse;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class SimpleTextPersonProtocol implements Protocol {
    private Map<Integer, Person> persons;
    private Map<String, Function<ProtocolRequest, ProtocolResponse>> mapper;

    public SimpleTextPersonProtocol() {
        persons = new HashMap<>();
        mapper = new HashMap<>();
        mapper.put(PersonApi.RequestType.ADD, this::addPerson);
        mapper.put(PersonApi.RequestType.DELETE, this::removeById);
        mapper.put(PersonApi.RequestType.GET_BY_ID, this::getById);
    }

    @Override
    public ProtocolResponse getResponse(ProtocolRequest request) {
        try {
            String type = request.getType();
            Function<ProtocolRequest, ProtocolResponse> mapFunc = mapper.get(type);
            if (mapFunc == null) {
                throw new Exception("Unsupported request type: " + type);
            }
            return mapFunc.apply(request);
        } catch (Exception ex) {
            return ProtocolResponse.of(ProtocolResponse.Code.BAD_REQUEST.toString(), ex.getMessage());
        }
    }

    private ProtocolResponse getById(ProtocolRequest protocolRequest) {
        int id = Integer.parseInt(protocolRequest.getData());
        if (!persons.containsKey(id)) {
            return ProtocolResponse.of(ProtocolResponse.Code.NOT_FOUND.toString(),"Person with id: " + id + " don't exist!");
        }
        return ProtocolResponse.of(ProtocolResponse.Code.OK.toString(),persons.get(id).toString());
    }

    private ProtocolResponse removeById(ProtocolRequest protocolRequest) {
        int id = Integer.parseInt(protocolRequest.getData());
        if(persons.remove(id) == null){
            return ProtocolResponse.of(ProtocolResponse.Code.NOT_FOUND.toString(),"Person with id: " + id + " don't exist!");
        }
        return ProtocolResponse.of(ProtocolResponse.Code.OK.toString(),"Person removed!");
    }

    private ProtocolResponse addPerson(ProtocolRequest protocolRequest) {
        Person p = Person.fromString(protocolRequest.getData());
        persons.put(p.id, p);
        return ProtocolResponse.of(ProtocolResponse.Code.OK.toString(), "Person added");
    }
}













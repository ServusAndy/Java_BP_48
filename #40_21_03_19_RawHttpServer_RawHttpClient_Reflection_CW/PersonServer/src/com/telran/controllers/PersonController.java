package com.telran.controllers;

import com.telran.dto.PersonDto;
import com.telran.protocol.Protocol;
import com.telran.protocol.RawHttpRequest;
import com.telran.protocol.RawHttpResponse;
import com.telran.services.PersonService;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class PersonController implements Protocol {
    private static final String HEADER_LENGTH = "Content-Length";
    private static final String HEADER_TYPE = "Content-Type";
    private static final String HEADER_SERVER = "Server";
    private static final String HEADER_DATE = "Date";

    private static final String CONTENT_TYPE_TEXT = "*/*; charset=UTF-8";

    private Map<String, Function<RawHttpRequest, RawHttpResponse>> mapper;
    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
        mapper = new HashMap<>();
        mapper.put("/person",this::person);
    }

    @Override
    public RawHttpResponse getResponse(RawHttpRequest request) {
        try{
            String path = request.uri.getPath();
            Function<RawHttpRequest,RawHttpResponse> mappedFunc = mapper.get(path);
            if(mappedFunc == null){
                throw new RuntimeException("Wrong path: " + path);
            }
            return mappedFunc.apply(request);
        }catch (Exception ex){
           return getErrorResponse(RawHttpResponse.ResponseCode.NOT_FOUND,"Not Found",ex.getMessage());
        }
    }

    @Override
    public RawHttpResponse getErrorResponse(int code, String reasonPhrase, String errorBody) {
        Map<String,String> headers = new HashMap<>();
        headers.put(HEADER_DATE, LocalDateTime.now().toString());
        headers.put(HEADER_TYPE,CONTENT_TYPE_TEXT);
        headers.put(HEADER_SERVER, "TelRan Java Server");
        headers.put(HEADER_LENGTH,String.valueOf(errorBody.length()));

        return new RawHttpResponse(code,reasonPhrase,headers,errorBody);
    }

    private RawHttpResponse person(RawHttpRequest request) {
        RawHttpResponse response;
        switch (request.method){
            case GET:
                response = getPersonResponse(request);
                break;
            case POST:
                PersonDto person = parseTextData(request.body,PersonDto.class);
                if(personService.add(person)){
                    response = createResponse(RawHttpResponse.ResponseCode.OK,"Ok","person added");
                }else{
                    response = getErrorResponse(RawHttpResponse.ResponseCode.BAD_REQUEST,"Bad Request","Person not added");
                }
                break;
            case PUT:
                //Todo Implements logic for update person
                //    int request body need by person as string
                response = getErrorResponse(RawHttpResponse.ResponseCode.BAD_REQUEST,"Bad request","Unsupported method:" + request.method);
                break;
            case DELETE:
                //Todo implements logic for delete person
                //    request body empty, person id for delete in query params
                response = getErrorResponse(RawHttpResponse.ResponseCode.BAD_REQUEST,"Bad request","Unsupported method:" + request.method);
                break;
            default:
                response = getErrorResponse(RawHttpResponse.ResponseCode.BAD_REQUEST,"Bad request","Unsupported request method: " + request.method);
        }
        return response;
    }


    private <T> T parseTextData(String data, Class<T> clazz){
        T result = null;
        try {
            Constructor<T> constructor = clazz.getConstructor();
            result = constructor.newInstance();
            String[] params = data.split("&");
            for (String param : params){
                try {
                    String[] keyValue = param.split("=");
                    Field field = clazz.getDeclaredField(keyValue[0]);
                    field.setAccessible(true);
                    if (field.getName().equals("id")) {
                        field.set(result, Integer.parseInt(keyValue[1]));
                    } else {
                        field.set(result, keyValue[1]);
                    }
                }catch (Exception ex){

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private RawHttpResponse getPersonResponse(RawHttpRequest request) {
        RawHttpResponse response;
        String params = request.uri.getQuery();
        if(params!=null){
            String[] arr = params.split("&");
            for(String param : arr){
                String[] keyValue = param.split("=");
                if(keyValue[0].equals("id")){
                    int id = Integer.parseInt(keyValue[1]);
                    PersonDto person = personService.getById(id);
                    if(person != null){
                        String body = person.toString();
                        return createResponse(RawHttpResponse.ResponseCode.OK,"OK",body);
                    }
                }
            }
            response = getErrorResponse(RawHttpResponse.ResponseCode.BAD_REQUEST,"Bad Request","Wrong query params");
        }else {
            List<PersonDto> list = personService.getAll();
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                builder.append(list.get(i).toString());
                if(i < list.size()-1){
                    builder.append(",");
                }
            }
            response = createResponse(RawHttpResponse.ResponseCode.OK,"Ok",builder.toString());
        }
        return response;
    }

    private RawHttpResponse createResponse(int code, String reasonPhrase, String body) {
        Map<String,String> headers = new HashMap<>();
        headers.put(HEADER_DATE, LocalDateTime.now().toString());
        headers.put(HEADER_TYPE,CONTENT_TYPE_TEXT);
        headers.put(HEADER_SERVER, "TelRan Java Server");
        if(body!= null) {
            headers.put(HEADER_LENGTH, String.valueOf(body.length()));
        }else{
            headers.put(HEADER_LENGTH,"0");
        }

        return new RawHttpResponse(code,reasonPhrase,headers,body);
    }
}

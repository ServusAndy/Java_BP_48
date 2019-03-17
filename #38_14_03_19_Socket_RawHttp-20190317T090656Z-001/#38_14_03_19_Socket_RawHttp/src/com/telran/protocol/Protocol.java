package com.telran.protocol;

public interface Protocol {
    HttpResponse getResponse(HttpRequest request);
    HttpResponse getErrorResponse(int code, String reasonPhrase, String errorBody);
}

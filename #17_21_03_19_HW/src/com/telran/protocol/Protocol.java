package com.telran.protocol;

public interface Protocol {
    RawHttpResponse getResponse(RawHttpRequest request);
    RawHttpResponse getErrorResponse(int code, String reasonPhrase, String errorBody);
}

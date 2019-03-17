package app.core;

public class PersonApi {
    public static final int PORT = 7000;
    public static class RequestType{
        public static final String ADD = "/addPerson";
        public static final String DELETE = "/removePerson";
        public static final String GET_BY_ID = "/getById";
    }
}

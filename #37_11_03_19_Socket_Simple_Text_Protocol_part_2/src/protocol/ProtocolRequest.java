package protocol;

public class ProtocolRequest {
    String type;
    String data;
    public static ProtocolRequest of(String type, String data){
        ProtocolRequest res = new ProtocolRequest();
        res.type = type;
        res.data = data;
        return res;
    }

    public String getType() {
        return type;
    }

    public String getData() {
        return data;
    }
}

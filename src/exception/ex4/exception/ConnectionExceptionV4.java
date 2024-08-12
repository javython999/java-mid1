package exception.ex4.exception;

public class ConnectionExceptionV4 extends NetworkClientExceptionV4 {

    private final String address;

    public ConnectionExceptionV4(String address, String message) {
        super(message);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}

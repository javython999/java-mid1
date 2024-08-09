package exception.basic.checked;

public class CheckedThrowMain {

    public static void main(String[] args) throws MyCheckedException {

        Service service = new Service();
        service.catchThrow();
    }
}

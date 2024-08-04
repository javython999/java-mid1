package nested.nested.ex0;

public class NetworkMessage {

    private String content;

    NetworkMessage(String content) {
        this.content = content;
    }

    public void print() {
        System.out.println(content);
    }
}

package exception.ex3;


import exception.ex3.exception.ConnectionExceptionV3;
import exception.ex3.exception.SendExceptionV3;

import java.sql.SQLOutput;

public class NetworkServiceV3_2 {

    public void sendMessage(String data) {
        String address = "https://example.com";
        NetworkClientV3 client = new NetworkClientV3(address);

        client.initError(data);

        try {
            client.connect();
            client.send(data);
        } catch (ConnectionExceptionV3 e) {
            System.out.println("[연결 오류] 주소: " + e.getAddress() + ", 메세지: " + e.getMessage());
        } catch (SendExceptionV3 e) {
            System.out.println("[네트워크 오류] 메세지: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("[알 수 없는 오류] 메세지: " + e.getMessage());
        } finally {
            client.disconnect();
        }



    }
}

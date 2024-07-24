package enumeration.test.http;

import java.util.Scanner;

public class HttpMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("HTTP CODE: ");
        int code = scanner.nextInt();

        HttpStatus status = HttpStatus.findByCode(code);

        if (status == null) {
            System.out.println("Unknown HTTP CODE: " + code);
        } else {
            System.out.println(status.getCode() + " " + status.getMessage());
            System.out.println("isSuccess = " + status.isSuccess());
        }

    }
}

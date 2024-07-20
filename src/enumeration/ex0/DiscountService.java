package enumeration.ex0;

public class DiscountService {

    public int discount(String grade, int price) {
        int discountPercent = 0;

        if ("BASIC".equals(grade)) {
            discountPercent = 10;
        } else if ("GOLD".equals(grade)) {
            discountPercent = 20;
        } else if ("DIAMOND".equals(grade)) {
            discountPercent = 30;
        } else {
            System.out.println(grade + " is not a valid discount");
        }

        return price * discountPercent / 100;
    }
}

package enumeration.ex0;

public class StringGradeEx02 {

    public static void main(String[] args) {
        int price = 10_000;

        DiscountService discountService = new DiscountService();

        // 존재하지 않는 등급
        int vipDiscount = discountService.discount("VIP", price);

        System.out.println("vipDiscount: " + vipDiscount);

        // 오타
        int diamondDiscount = discountService.discount("DIAMONDD", price);
        int goldDiscount = discountService.discount("gold", price);
        System.out.println("diamondDiscount: " + diamondDiscount);
        System.out.println("goldDiscount: " + goldDiscount);


    }
}

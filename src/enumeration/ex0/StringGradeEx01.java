package enumeration.ex0;

public class StringGradeEx01 {

    public static void main(String[] args) {
        int price = 10_000;

        DiscountService discountService = new DiscountService();
        int basicDiscount = discountService.discount("BASIC", price);
        int goldDiscount = discountService.discount("GOLD", price);
        int diamondDiscount = discountService.discount("DIAMOND", price);

        System.out.println("BASIC: " + basicDiscount);
        System.out.println("GOLD: " + goldDiscount);
        System.out.println("DIAMOND: " + diamondDiscount);
    }
}

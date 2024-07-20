package enumeration.ex1;

public class StringGradeEx03 {

    public static void main(String[] args) {
        int price = 10_000;

        DiscountService discountService = new DiscountService();
        int basicDiscount = discountService.discount(StringGrade.BASIC, price);
        int goldDiscount = discountService.discount(StringGrade.GOLD, price);
        int diamondDiscount = discountService.discount(StringGrade.DIAMOND, price);

        System.out.println("BASIC: " + basicDiscount);
        System.out.println("GOLD: " + goldDiscount);
        System.out.println("DIAMOND: " + diamondDiscount);
    }
}

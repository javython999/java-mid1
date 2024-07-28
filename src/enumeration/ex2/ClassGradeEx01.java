package enumeration.ex2;

public class ClassGradeEx01 {

    public static void main(String[] args) {
        int price = 10_000;
        DiscountService discountService = new DiscountService();
        int basicDiscount = discountService.discount(ClassGrade.BASIC, price);
        int goldDiscount = discountService.discount(ClassGrade.GOLD, price);
        int diamondDiscount = discountService.discount(ClassGrade.DIAMOND, price);

        System.out.println("Basic: " + basicDiscount);
        System.out.println("Gold: " + goldDiscount);
        System.out.println("Diamond: " + diamondDiscount);
    }
}

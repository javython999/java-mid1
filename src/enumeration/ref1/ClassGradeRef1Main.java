package enumeration.ref1;

public class ClassGradeRef1Main {

    public static void main(String[] args) {
        int price = 10_000;

        DiscountService discountService = new DiscountService();
        int basicDiscount = discountService.discount(Grade.BASIC, price);
        int goldDiscount = discountService.discount(Grade.GOLD, price);
        int diamondDiscount = discountService.discount(Grade.DIAMOND, price);

        System.out.println("Basic: " + basicDiscount);
        System.out.println("Gold: " + goldDiscount);
        System.out.println("Diamond: " + diamondDiscount);
    }
}

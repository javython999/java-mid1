package enumeration.ref0;

public class DiscountService {

    public int discount(ClassGrade grade, int price) {
        return price * grade.getDiscountPercent() / 100;
    }
}

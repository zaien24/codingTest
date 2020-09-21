package codility;

public class Coupon {
    int price;

    public Coupon(int price) {
        this.price = price;
    }

    public static void main(String[] args) {
        Coupon coupon = new Coupon(1000);
        int dp= coupon.getDiscountPrice();
        coupon.order(dp);
    }

    public final void order(int discountPrice) {
        validate(discountPrice);
        pay(discountPrice);
    }

    private final void pay(int discountPrice) {
        // do something
    }

    private final void validate(int discountPrice) {
        // do something
    }

    protected int getDiscountPrice() {
        return 500;
    }
}

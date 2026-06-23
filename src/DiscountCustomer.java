public class DiscountCustomer extends Customer {

    public DiscountCustomer(String name) {
        super(name);
    }

    @Override
    public double calculatePrice() {
        return 20;
    }
}
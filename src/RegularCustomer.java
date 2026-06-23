public class RegularCustomer extends Customer {

    public RegularCustomer(String name) {
        super(name);
    }

    @Override
    public double calculatePrice() {
        if (totalSessions >= 5) {
            return 20; // loyalty discount
        }
        return 25;
    }
}
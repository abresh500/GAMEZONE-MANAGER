public class Session {
    private Customer customer;
    private Station station;
    private double price;

    public static double totalRevenue = 0;

    public Session(Customer customer, Station station) {
        this.customer = customer;
        this.station = station;
        customer.incrementSessions();
    }

    public void setPrice(double price) {
        this.price = price;
        totalRevenue += price;
    }

    public double getPrice() {
        return price;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Station getStation() {
        return station;
    }
}
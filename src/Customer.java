public abstract class Customer {
    protected String name;
    protected int totalSessions;

    public Customer(String name) {
        this.name = name;
        this.totalSessions = 0;
    }

    public String getName() {
        return name;
    }

    public int getTotalSessions() {
        return totalSessions;
    }

    public void incrementSessions() {
        totalSessions++;
    }

    public abstract double calculatePrice();
}
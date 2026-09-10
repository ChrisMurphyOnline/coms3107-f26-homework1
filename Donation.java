public class Donation {
    protected String user;
    protected double amount;

    public Donation(String user, double amount) {
        this.user = user;
        this.amount = amount;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Donation{user='" + user + "', amount=" + amount + "}";
    }
}
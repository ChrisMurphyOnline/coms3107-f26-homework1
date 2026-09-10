import java.util.Objects;

public class TotalDonation extends Donation {
    private int count;

    public TotalDonation(String user, double amount, int count) {
        super(user, amount);
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "TotalDonation{user='" + getUser() + "', totalAmount=" + getAmount() + ", count=" + count + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TotalDonation that = (TotalDonation) o;
        return count == that.count && amount == that.amount && user.equals(that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(count);
    }
}
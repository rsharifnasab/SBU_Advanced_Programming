import java.util.Objects;

public class CityMonthInformation {

	private String city;
	private int month;
	private long sum;

    public CityMonthInformation(String city, int month, long sum) {
        this.city = city;
        this.month = month;
        this.sum = sum;
    }

    public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public long getSum() {
		return sum;
	}

	public void setSum(long sum) {
		this.sum = sum;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityMonthInformation that = (CityMonthInformation) o;
        return month == that.month &&
                sum == that.sum &&
                Objects.equals(city, that.city);
    }
}

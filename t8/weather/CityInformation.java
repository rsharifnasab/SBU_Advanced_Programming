import java.util.Objects;

public class CityInformation {

	private String city;
	private long sum;

	public CityInformation(String city, long sum) {
		this.city = city;
		this.sum = sum;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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
        CityInformation that = (CityInformation) o;
        return sum == that.sum &&
                Objects.equals(city, that.city);
    }
}

public class Information {

	private final String city;
	private final String date;
	private final long amount;
	
	public Information(String city, String date, long amount) {
		this.city = city;
		this.date = date;
		this.amount = amount;
	}

	public String getCity() {
		return city;
	}

	public String getDate() {
		return date;
	}

	public long getAmount() {
		return amount;
	}

}

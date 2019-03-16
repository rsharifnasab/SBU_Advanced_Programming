public class TripHandler {
	private static TripHandler onlyInstance = new TripHandler();

	public static  TripHandler getInstance(){
		return onlyInstance;
	}

	private TripHandler(){}

	public int calcPrice(String type, TripParam params) {
			if(type.equals("vip")) return (new VIPTripMethod().calcPrice(params));
			//if(type.equals("economic")) return (new EconomicTripMethod().calcPrice(params));
			//TODO
			if(type.equals("bike")) return (new BikeTripMethod().calcPrice(params));
			return 0;
	}



}

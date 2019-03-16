
public class TripHandler {
	private static TripHandler onlyInstance = new TripHandler();

	public static  TripHandler getInstance(){
		return onlyInstance;
	}

	private TripHandler(){}

	private int type2base(String type){
		if(type.equals("vip")) return 10000;
		if(type.equals("bike")) return 4000;
		if(type.equals("eco")) return 5000;
		return 0;
	}

	private double ratioCalc(String type,TripParam params){
		boolean rain = params.isRainy();
		boolean peak = params.isPeakTime();
		if (type.equals("eco")) {
			if(peak && rain) return 1.4D;
			if(peak || rain ) return 1.2D;
			return 1D;
		}

		if (type.equals("vip")) {
			if(peak && rain) return 3D;
			if(peak || rain) return 2D;
			return 1D;
		}

		if (type.equals("bike")) {
			if(peak && rain) return 1.5D;
			if(peak) return 2D;
			if(rain) return 0.8D;
			return 1D;
		}
		return 1;
	}

	public int calcPrice(String type, TripParam params) {
		int from = params.getSource();
		int to = params.getDestination();
		int basePrice = DistanceMap.distance[from][to];
		int base = type2base(type);
		double ratio = ratioCalc(type,params);
		return (int) (basePrice * base * ratio);
	}

}

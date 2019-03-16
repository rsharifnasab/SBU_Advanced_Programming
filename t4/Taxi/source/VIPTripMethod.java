
public class VIPTripMethod extends TripMethod {

	public int calcPrice(TripParam params){

			boolean rain = params.isRainy();
			boolean peak = params.isPeakTime();

			int from = params.getSource();
			int to = params.getDestination();
			final int mapPrice = DistanceMap.distance[from][to];

			final int paye =10000;
			double ratio = 1D;
			if(peak && rain) ratio = 3D;
			else if(peak) ratio = 2D;
			else if(rain) ratio = 2D;
			return (int) (mapPrice*paye*ratio);
	}

}

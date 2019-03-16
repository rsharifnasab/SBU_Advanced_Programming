
public class VIPTripMethod extends TripMethod {

	public int calcPrice(TripParam params){

			boolean rain = params.isRainy();
			boolean peak = params.isPeakTime();
			final int mapPrice = super.getMapPrice(params);
			final int paye =10000;
			double ratio = 1D;
			if(peak && rain) ratio = 3D;
			else if(peak) ratio = 2D;
			else if(rain) ratio = 2D;
			return (int) (mapPrice*paye*ratio);
	}

}

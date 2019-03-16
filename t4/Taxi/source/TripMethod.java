
public abstract class TripMethod {
	public abstract int calcPrice(TripParam params);

	protected int getMapPrice(TripParam params){
		int from = params.getSource();
		int to = params.getDestination();
		return DistanceMap.distance[from][to];
	}

}

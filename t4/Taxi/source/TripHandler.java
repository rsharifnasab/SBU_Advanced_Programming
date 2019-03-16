
public class TripHandler {
	private static TripHandler onlyInstance = new TripHandler();

	public static  TripHandler getInstance(){
		return onlyInstance;
	}

	private TripHandler(){}

	public int calcPrice(String type, TripParam params) {
		//your implementation

	}

}

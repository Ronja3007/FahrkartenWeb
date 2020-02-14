package logik;


public class DataController {
	
	private static DataController instance;
	private static GeldSachen finanzen;

	private DataController () {
		finanzen = new GeldSachen();
	}
	
	public static GeldSachen getFinanzen() {
		return finanzen;
	}
	
	public static DataController getInstance () {
		if (DataController.instance == null) {
			DataController.instance = new DataController ();
		}
		return DataController.instance;
	}
}


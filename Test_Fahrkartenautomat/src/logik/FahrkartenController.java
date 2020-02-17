package logik;

public class FahrkartenController {
	
	private static MenuesEingaben menue;
	private static GeldSachen finanzen;
	private static FahrkartenController instance;
	private static Service service;
	
	public void main(String[] args) {}
	
	private FahrkartenController() {
		finanzen = new GeldSachen();
		menue = new MenuesEingaben();
		service = new Service();
	}
	
	public GeldSachen getFinanzen () {
		return finanzen;
	}
	
	public MenuesEingaben getMenue() {
		return menue;
	}
	
	public Service getserService () {
		return service;
	}
	
	public static FahrkartenController getInstance () {
		if (FahrkartenController.instance == null) {
			FahrkartenController.instance = new FahrkartenController ();
		}
		return FahrkartenController.instance;
	}

	public void zuruecksetzen() {
		finanzen.zuruecksetzen();
	}
}

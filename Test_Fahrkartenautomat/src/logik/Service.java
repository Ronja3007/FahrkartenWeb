package logik;

public class Service {

	void geldAuffuellen(int anzahl, int auswahlGeldFach){
		FahrkartenController.getInstance().getFinanzen().geldAuffuellenOderLeeren(auswahlGeldFach, anzahl);
	}
	
	void geldLeeren(int anzahl, int auswahlGeldFach) {
		FahrkartenController.getInstance().getFinanzen().geldAuffuellenOderLeeren(auswahlGeldFach, -anzahl);
	}
}

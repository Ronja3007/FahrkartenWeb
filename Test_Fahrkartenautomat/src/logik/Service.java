package logik;

public class Service {

	public void pruefen(String fach, String anzahl, String addOderSub) throws ValidierungsException {
		int anzahlINT = pruefen(anzahl);
		if(addOderSub.equals("auffuellen")) {
			geldAuffuellen(anzahlINT, fach);
		}
		if(addOderSub.equals("leeren")) {
			geldLeeren(anzahlINT, fach);
		}
	}

	private int pruefen(String anzahl) throws ValidierungsException {
		try {
			return Integer.parseInt(anzahl);
		}catch (Exception e) {
			throw new ValidierungsException(e.getMessage());
		}
	}

	private void geldAuffuellen(int anzahl, String fach) throws ValidierungsException{
		FahrkartenController.getInstance().getFinanzen().geldAuffuellenOderLeeren(fach, anzahl);
	}
	
	private void geldLeeren(int anzahl, String auswahlGeldFach) throws ValidierungsException {
		FahrkartenController.getInstance().getFinanzen().geldAuffuellenOderLeeren(auswahlGeldFach, -anzahl);
	}
}

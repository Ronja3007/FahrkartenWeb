package logik;

public class Service {

	public void pruefen(String fach, String anzahl, String addOderSub) throws ValidierungsException {
		int anzahlINT = pruefen(anzahl);
		if(addOderSub.equals("auffuellen")) {
			geldAuffuellenLeeren(anzahlINT, fach);
		}
		if(addOderSub.equals("leeren")) {
			geldAuffuellenLeeren(-anzahlINT, fach);
		}
	}

	private int pruefen(String anzahl) throws ValidierungsException {
		try {
			return Integer.parseInt(anzahl);
		}catch (Exception e) {
			throw new ValidierungsException("Das ist keine Zahl!");
		}
	}

	private void geldAuffuellenLeeren(int anzahl, String fach) throws ValidierungsException{
		FahrkartenController.getInstance().getFinanzen().geldAuffuellenOderLeeren(fach, anzahl);
	}
}

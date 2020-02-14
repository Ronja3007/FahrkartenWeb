package logik;

public class FahrkartenController {
	
	private static final java.text.DecimalFormatSymbols germany = new java.text.DecimalFormatSymbols( java.util.Locale.GERMANY );
    private static final java.text.DecimalFormat german = new java.text.DecimalFormat( "##,##0.00", germany );
	
	public static void main(String[] args) {
		GeldSachen finanzen = new GeldSachen();
		MenuesEingaben menue = new MenuesEingaben();
		while(true) {
			try {
				int auswahl;
				double preis;
				double einzahlung;
				System.out.println("Willkommen!\nWas möchten Sie tun?");
				menue.menueAnzeigen();
				System.out.println("Ihre Auswahl: ");
				auswahl = (int) menue.eingeben(MenuesEingaben.HAUPTMENUE);
				int preisNummer = menue.unterMenueFuerFahrkarten(auswahl);
				preis = finanzen.getPreise().get(preisNummer-1);
				System.out.println("\nPreis: " + german.format(preis) + " Euro");
				System.out.println("\nMuenzen: 10, 20, 50, 1 Euro, 2 Euro\nScheine: 5, 10, 20, 50\nBetrag einzahlen: ");
				do {
					einzahlung = menue.eingeben(MenuesEingaben.ZAHLEN);
					finanzen.betragPruefen(einzahlung, preis);
					if(finanzen.getEingezahlt() < preis) {
						System.out.println("Es fehlen noch " + german.format(finanzen.getFehlendesGeld()) + " Euro");
					}
				} while (finanzen.getEingezahlt() < preis);
				
				if(finanzen.getEingezahlt() > preis) {
					System.out.println("Sie bekommen " + german.format(finanzen.getRueckgabeGeldAnKunden()) + " Euro zurueck\n\nGeldmuenzen/-scheine:");
					for(double f : finanzen.getListeRueckgeld()) {
						System.out.println(f);
					}
				}
			}catch(ValidierungsException v) {
				System.out.println("Fehler: " + v.getMessage());
			}
			System.out.println("\n\n");
		}
	}
}

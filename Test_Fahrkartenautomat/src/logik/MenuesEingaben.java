package logik;

import java.util.Scanner;

public class MenuesEingaben {
	
	private static int menueGroesse = 6;
	public static final String HAUPTMENUE = "hauptmenue";
	public static final String UNTERMENUEZEITKARTE = "untermenue";
	public static final String ZAHLEN = "zahlen";
	
	void menueAnzeigen() {
		System.out.println("\n1. Einzelfahrkarte kaufen\n"
				+ "2. 10er Streifenkarte kaufen\n"
				+ "3. TagesTicket Plus kaufen\n"
				+ "4. 4er Ticket kaufen\n"
				+ "5. Zeitkarte kaufen\n"
				+ "6. Ferienticket kaufen\n ");
	}
	
	int unterMenueFuerFahrkarten(int auswahl) throws ValidierungsException {
		System.out.println("\n\n");
		int kartenPreisNummer = -1;
		if(auswahl == 1) {
			System.out.println("-----EINZELFAHRKARTE-----");   //Kartenpreis 4
			kartenPreisNummer = 4;
		}
		if(auswahl == 2) {
			System.out.println("-----10ER STREIFENKARTE-----");    //Kartenpreis 5
			kartenPreisNummer = 5;
		}
		if(auswahl == 3) {
			System.out.println("-----TAGESTICKET PLUS-----");   //Kartenpreis 6
			kartenPreisNummer = 6;
		}
		if(auswahl == 4) {
			System.out.println("-----4ER TICKET-----");   //Kartenpreis 7
			kartenPreisNummer = 7;
		}
		if(auswahl == 5) {
			System.out.println("-----ZEITKARTE-----");
			kartenPreisNummer = menueZeitkarte();          //Kartenpreis 1, 2, 3
		}
		if(auswahl == 6) {
			System.out.println("-----FERIENTICKET-----");   //Kartenpreis 8
			kartenPreisNummer = 8;
		}
		return kartenPreisNummer;
	}

	private int menueZeitkarte() throws ValidierungsException{
		System.out.println("\n1. Wochenkarte\n"
				+ "2. Monatskarte\n"
				+ "3. Jahreskarte \n\n"
				+ "Ihre Auswahl: ");
			int auswahl = (int) eingeben(UNTERMENUEZEITKARTE);
			return(auswahl);
	}

	private  void auswahlPruefen(int auswahl, String welchesMenue) throws ValidierungsException{
		if(welchesMenue.equals(HAUPTMENUE)) {
			if(auswahl< 1 || auswahl > menueGroesse) {
				throw new ValidierungsException("Diesen Menuepunkt giebt es nicht!");
			}
		}
		if(welchesMenue.equals(UNTERMENUEZEITKARTE)) {
			if(auswahl < 1 || auswahl > 3) {
				throw new ValidierungsException("Diese Auswahl giebt es nicht!");
			}
		}
	}
	
	float eingeben(String welcheEingabe) throws ValidierungsException{
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		float eingabe = -1;
		try {
			eingabe = Float.parseFloat(scan.nextLine()); 
			if(welcheEingabe.equals(HAUPTMENUE)) {
				auswahlPruefen((int) eingabe, welcheEingabe);
			}	
		}catch (Exception e) {
			throw new ValidierungsException("Das ist keine Zahl!");
		}		
		return eingabe;
	}
	
}

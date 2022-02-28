package LocaliRecensioni;

public class Locale {

	public String denominazione;
	public String indirizzo;
	public int Nrecensioni;
	Recensione recensioni[]= new Recensione[1000];

	public Locale(String denominazione1, String indirizzo1) {

		denominazione = denominazione1;
		indirizzo = indirizzo1;
		Nrecensioni = 0;
	}
	public double CalcMedia() {
		double media=0;
		for(int i=0; i<Nrecensioni; i++) {
			media += recensioni[i].Stelle;
		}
		return media/Nrecensioni;
	}
	public void registraRecensione(String commento, String Utente , int Stelle) {

		recensioni[Nrecensioni] = new Recensione(Utente, Stelle,commento );
		Nrecensioni++;
}

}
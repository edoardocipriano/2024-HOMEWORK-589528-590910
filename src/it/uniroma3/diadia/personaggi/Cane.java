package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Cane extends AbstractPersonaggio {
	
	private Attrezzo ciboPreferito;

	public Cane(String nome, String presentaz) {
		super(nome, presentaz);
	}

	@Override
	public String agisci(Partita partita) {
		String msg = "Ti ho morso, bau!";
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
		return msg;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		if(attrezzo.equals(ciboPreferito)) {
			partita.getStanzaCorrente().addAttrezzo(attrezzo);
			return "Molto buono grazie! Bau!";
		}
		
		return agisci(partita);
	
	}

}

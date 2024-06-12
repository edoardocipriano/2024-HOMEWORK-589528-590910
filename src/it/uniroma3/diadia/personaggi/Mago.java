package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Mago extends AbstractPersonaggio {
	
	private static final String MESSAGGIO_DONO = "Mi stai molto simpatico, ecco a te un oggetto per"
			+ "il tuo borsone!";
	private static final String MESSAGGIO_SCUSE = "Mi spiace, ma non ho piu' nulla...";
	
	private Attrezzo attrezzo;

	public Mago(String nome, String presentaz,Attrezzo attrezzo) {
		super(nome, presentaz);
		this.attrezzo = attrezzo;
	}

	@Override
	public String agisci(Partita partita) {
		String msg;
		if (this.attrezzo!=null) {
			partita.getStanzaCorrente().addAttrezzo(this.attrezzo);
			this.attrezzo = null;
			msg = MESSAGGIO_DONO;
		}
		else {
			msg = MESSAGGIO_SCUSE;
		}
		return msg;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		String msg = "Grazie per il regalo! Ora gli dimezzo il peso e lo butto!";
		attrezzo.setPeso(attrezzo.getPeso()/2);
		partita.getStanzaCorrente().addAttrezzo(attrezzo);
		return msg;
	}
	
}

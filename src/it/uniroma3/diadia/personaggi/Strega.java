package it.uniroma3.diadia.personaggi;

import java.util.Collection;
import java.util.Iterator;
import java.util.Random;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Strega extends AbstractPersonaggio {

	public Strega(String nome, String presentaz) {
		super(nome, presentaz);
	}

	@Override
	public String agisci(Partita partita) {
		String msg = "Teletrasporto magico!";
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		Collection<Stanza> stanzeAdiacenti = stanzaCorrente.getStanzeAdiacenti();
		Random r = new Random();
		int index = r.nextInt(stanzeAdiacenti.size());
		Iterator<Stanza> it = stanzeAdiacenti.iterator();
		Stanza stanzaCasuale = it.next();
		int count = 1;
		while(it.hasNext() && count != index) {
			stanzaCasuale = it.next();
			count += 1;
		}
		partita.setStanzaCorrente(stanzaCasuale);
		return msg;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		String msg = "Grazie per il regalo! *Grasse risate*";
		return msg;
	}
	
	

}

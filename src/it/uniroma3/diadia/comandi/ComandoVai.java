package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.*;

public class ComandoVai extends AbstractComando {
	
	static final private String nome = "vai";
	
	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		Stanza prossimaStanza = null;
		
		if(getParametro()==null) {
			getIO().mostraMessaggio("Dove vuoi andare? Devi specificare una direzione");
			return;
		}
		
		prossimaStanza = stanzaCorrente.getStanzaAdiacente(Direzione.valueOf(getParametro().toUpperCase()));
		if (prossimaStanza==null) {
			getIO().mostraMessaggio("Direzione inesistente");
			return;
		}
		
		partita.setStanzaCorrente(prossimaStanza);
		getIO().mostraMessaggio(partita.getStanzaCorrente().toString());
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
		
	}
	
	@Override
	public String getNome() {
		return nome;
	}

}

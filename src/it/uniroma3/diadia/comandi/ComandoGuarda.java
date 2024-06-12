package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoGuarda extends AbstractComando {
	
	static final private String nome = "guarda";

	@Override
	public void esegui(Partita partita) {
		Stanza stanza = partita.getStanzaCorrente();
		getIO().mostraMessaggio(stanza.toString());
	}
	
	@Override
	public String getNome() {
		return nome;
	}
	
}

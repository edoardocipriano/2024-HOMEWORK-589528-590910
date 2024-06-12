package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

public class ComandoSaluta extends AbstractComando{
	
	static final private String nome = "saluta";
	private static final String MESSAGGIO_CON_CHI = "Chi dovrei salutare?...";

	@Override
	public void esegui(Partita partita) {
		AbstractPersonaggio personaggio;
		personaggio = partita.getStanzaCorrente().getPersonaggio();
		if(personaggio!=null)
			getIO().mostraMessaggio("Ciao " + personaggio.toString());
		else
			getIO().mostraMessaggio(MESSAGGIO_CON_CHI);
	}

	@Override
	public String getNome() {
		return nome;
	}
	
}

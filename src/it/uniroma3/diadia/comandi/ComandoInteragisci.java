package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

public class ComandoInteragisci extends AbstractComando{
	
	static final private String nome = "interagisci";
	private static final String MESSAGGIO_CON_CHI = "Con chi dovrei interagire?...";

	@Override
	public void esegui(Partita partita) {
		AbstractPersonaggio personaggio;
		personaggio = partita.getStanzaCorrente().getPersonaggio();
		if (personaggio!=null) {
			setMessaggio(personaggio.agisci(partita));
			getIO().mostraMessaggio(this.getMessaggio());

		} else getIO().mostraMessaggio(MESSAGGIO_CON_CHI);
	}

	@Override
	public String getNome() {
		return nome;
	}

}

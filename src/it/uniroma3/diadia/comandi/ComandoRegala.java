package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

public class ComandoRegala extends AbstractComando {
	
	static final private String nome = "regala";
	private static final String MESSAGGIO_CON_CHI = "A chi dovrei fare il regalo?...";

	@Override
	public void esegui(Partita partita) {
		AbstractPersonaggio personaggio;
		personaggio = partita.getStanzaCorrente().getPersonaggio();
		if(personaggio!=null) {
			setMessaggio(personaggio.riceviRegalo(partita.getGiocatore().getBorsa().getAttrezzo(getParametro()),partita));
			getIO().mostraMessaggio(getMessaggio());
		}
		else
			getIO().mostraMessaggio(MESSAGGIO_CON_CHI);
		
	}

	@Override
	public String getNome() {
		return nome;
	}

}

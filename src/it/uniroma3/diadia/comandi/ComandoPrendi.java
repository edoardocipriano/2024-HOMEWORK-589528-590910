package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.*;

public class ComandoPrendi extends AbstractComando {
	
	static final private String nome = "prendi";
	
	@Override
	public void esegui(Partita partita) {
		
		if(getParametro()==null)
			getIO().mostraMessaggio("Che attrezzo vuoi prendere?");
		
		Attrezzo newAttrezzo = partita.getStanzaCorrente().getAttrezzo(getParametro());
		if( newAttrezzo != null ) {
			partita.getStanzaCorrente().removeAttrezzo(newAttrezzo);
			partita.getGiocatore().getBorsa().addAttrezzo(newAttrezzo);
		}
		else {
			getIO().mostraMessaggio("Oggetto non presente nella stanza");
			getIO().mostraMessaggio("Che attrezzo vuoi prendere?");
		}
		getIO().mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		getIO().mostraMessaggio(partita.getGiocatore().getBorsa().getDescrizione());
	}
	
	@Override
	public String getNome() {
		return nome;
	}
	
}

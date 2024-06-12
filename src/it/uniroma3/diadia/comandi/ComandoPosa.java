package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa extends AbstractComando {
	
	static final private String nome = "posa";
	
	@Override
	public void esegui(Partita partita) {
		
		if(getParametro()==null)
			getIO().mostraMessaggio("Che attrezzo vuoi prendere?");
		Attrezzo newAttrezzo = partita.getGiocatore().getBorsa().getAttrezzo(getParametro());
		if( newAttrezzo != null ) {
			partita.getGiocatore().getBorsa().removeAttrezzo(newAttrezzo.getNome());
			partita.getStanzaCorrente().addAttrezzo(newAttrezzo);
		}
		else {
			getIO().mostraMessaggio("Oggetto non presente nella borsa");
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

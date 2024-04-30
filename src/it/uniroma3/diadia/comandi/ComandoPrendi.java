package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.*;

public class ComandoPrendi implements Comando {
	
	private String nomeAttrezzo;
	static final private String nome = "prendi";
	private IO io;
	
	public ComandoPrendi(IO io) {
		this.io = io;
	}
	
	@Override
	public void esegui(Partita partita) {
		
		if(nomeAttrezzo==null)
			io.mostraMessaggio("Che attrezzo che prendere?");
		
		Attrezzo newAttrezzo = partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
		if( newAttrezzo != null ) {
			partita.getStanzaCorrente().removeAttrezzo(newAttrezzo);
			partita.getGiocatore().getBorsa().addAttrezzo(newAttrezzo);
		}
		else {
			io.mostraMessaggio("Oggetto non presente nella stanza");
			io.mostraMessaggio("Che attrezzo vuoi prendere?");
		}
		io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		io.mostraMessaggio(partita.getGiocatore().getBorsa().getDescrizione());
	}
	
	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
	}
	
	@Override
	public String getNome() {
		return nome;
	}
	
	@Override
	public String getParametro() {
		return this.nomeAttrezzo;
	}
	
}

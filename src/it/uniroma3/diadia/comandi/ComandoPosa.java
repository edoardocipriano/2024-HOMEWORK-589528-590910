package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Comando {
	
	private String nomeAttrezzo;
	static final private String nome = "posa";
	private IO io;
	
	public ComandoPosa(IO io) {
		this.io = io;
	}
	
	@Override
	public void esegui(Partita partita) {
		
		if(nomeAttrezzo==null)
			io.mostraMessaggio("Che attrezzo vuoi prendere?");
		Attrezzo newAttrezzo = partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
		if( newAttrezzo != null ) {
			partita.getGiocatore().getBorsa().removeAttrezzo(newAttrezzo.getNome());
			partita.getStanzaCorrente().addAttrezzo(newAttrezzo);
		}
		else {
			io.mostraMessaggio("Oggetto non presente nella borsa");
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

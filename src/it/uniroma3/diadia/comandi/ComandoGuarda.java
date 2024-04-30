package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoGuarda implements Comando {
	
	private String parametro;
	static final private String nome = "guarda";
	private IO io;
	
	public ComandoGuarda(IO io) {
		this.io = io;
	}

	@Override
	public void esegui(Partita partita) {
		Stanza stanza = partita.getStanzaCorrente();
		io.mostraMessaggio(stanza.toString());
	}
	
	@Override
	public void setParametro(String parametro) {
		this.parametro = parametro;
	}
	
	@Override
	public String getNome() {
		return nome;
	}
	
	@Override
	public String getParametro() {
		return this.parametro;
	}
	
}

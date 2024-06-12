package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoNonValido extends AbstractComando {
	static final private String nome = "non valido";
	
	@Override
	public void esegui(Partita partita) {
		getIO().mostraMessaggio("Comando non valido");
	}
	
	@Override
	public String getNome() {
		return nome;
	}
	
}

package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoFine extends AbstractComando {

	static final private String nome = "fine";
	
	@Override
	public void esegui(Partita partita) {
		getIO().mostraMessaggio("Grazie di aver giocato!");
		partita.setFinita();
	}
	
	@Override
	public String getNome() {
		return nome;
	}

}

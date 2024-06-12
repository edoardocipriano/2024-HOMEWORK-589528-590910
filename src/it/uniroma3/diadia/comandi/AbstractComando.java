package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public abstract class AbstractComando {
	
	private IO io;
	private String parametro;
	private String messaggio;

	public abstract void esegui(Partita partita);
	
	public void setParametro(String parametro) {
		this.parametro = parametro;
	}
	
	public abstract String getNome();
	
	public String getParametro() {
		return this.parametro;
	}
	
	public void setIO(IO io) {
		this.io = io;
	}
	
	public IO getIO() {
		return this.io;
	}
	
	public String getMessaggio() {
		return this.messaggio;
	}
	
	public void setMessaggio(String messaggio) {
		this.messaggio = messaggio;
	}
	
}

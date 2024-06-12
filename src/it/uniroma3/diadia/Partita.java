package it.uniroma3.diadia;

import java.io.FileNotFoundException;

import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.giocatore.*;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {

	private boolean finita;
	private Stanza stanzaCorrente;
	private Labirinto labirinto;
	private Giocatore giocatore;
	
	public Partita(Labirinto l) throws FileNotFoundException, FormatoFileNonValidoException{
		this.labirinto = l;
		giocatore = new Giocatore();
		this.stanzaCorrente = this.getLabirinto().getStanzaIniziale();
		this.finita = false;
	}
	
	public Partita() {
		this.labirinto = new Labirinto();
		giocatore = new Giocatore();
		this.stanzaCorrente = this.getLabirinto().getStanzaIniziale();
		this.finita = false;
	}
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.stanzaCorrente==this.labirinto.getStanzaVincente();
	}
	
	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}
	
	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}
	
	public Labirinto getLabirinto() {
		return this.labirinto;
	}
	public Giocatore getGiocatore() {
		return this.giocatore;
	}
	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (this.giocatore.getCfu() == 0);
	}
	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}
	
	public boolean giocatoreIsVivo() {
		return this.giocatore.getCfu() > 0;
	}
}
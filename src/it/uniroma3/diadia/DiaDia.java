package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.*;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa"};

	private Partita partita;

	public DiaDia() {
		this.partita = new Partita();
	}

	public void gioca(IOConsole io) {
		String istruzione; 

		io.mostraMessaggio(MESSAGGIO_BENVENUTO);		
		do		
			istruzione = io.leggiRiga();
		while (!processaIstruzione(istruzione,io));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione,IOConsole io) {
		Comando comandoDaEseguire = new Comando(istruzione);

		if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine(io); 
			return true;
		} else if (comandoDaEseguire.getNome().equals("vai"))
			this.vai(comandoDaEseguire.getParametro(),io);
		else if (comandoDaEseguire.getNome().equals("aiuto"))
			this.aiuto(io);
		else if (comandoDaEseguire.getNome().equals("prendi"))
			this.prendi(comandoDaEseguire.getParametro(),io);
		else if (comandoDaEseguire.getNome().equals("posa"))
			this.posa(comandoDaEseguire.getParametro(),io);
		else
			io.mostraMessaggio("Comando sconosciuto");
		if (this.partita.vinta()) {
			io.mostraMessaggio("Hai vinto!");
			return true;
		} else
			return false;
	}   

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto(IOConsole io) {
		for(int i=0; i< elencoComandi.length; i++) 
			io.mostraMessaggio(elencoComandi[i]);
		io.mostraMessaggio("");
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione,IOConsole io) {
		if(direzione==null) 
			io.mostraMessaggio("Dove vuoi andare ?");
		Stanza prossimaStanza;
		prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null && direzione != null) {	// prima non c'era la seconda condizione
			io.mostraMessaggio("Direzione inesistente!");
			io.mostraMessaggio("Dove vuoi andare?");	// questa secoda print non c'era
		}	// prima non c'era la seconda condizione
		else if (prossimaStanza != null) {		// prima non c'era else if (solo else)
			this.partita.setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getGiocatore().getCfu();
			this.partita.getGiocatore().setCfu(cfu--);
		}
		io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		io.mostraMessaggio(partita.getGiocatore().getBorsa().getDescrizione());
	}
	
	/**
	 *  Rimuove attrezzi dalla stanza e li aggiunge alla borsa
	 */
	
	private void prendi(String nomeAttrezzo,IOConsole io) {
		if(nomeAttrezzo==null)
			io.mostraMessaggio("Che attrezzo vuoi prendere?");
		Attrezzo newAttrezzo = this.partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
		if( newAttrezzo != null ) {
			this.partita.getStanzaCorrente().removeAttrezzo(newAttrezzo);
			this.partita.getGiocatore().getBorsa().addAttrezzo(newAttrezzo);
		}
		else {
			io.mostraMessaggio("Oggetto non presente nella stanza");
			io.mostraMessaggio("Che attrezzo vuoi prendere?");
		}
		io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		io.mostraMessaggio(partita.getGiocatore().getBorsa().getDescrizione());
		
	}
	
	private void posa(String nomeAttrezzo,IOConsole io) {
		if(nomeAttrezzo==null)
			io.mostraMessaggio("Che attrezzo vuoi prendere?");
		Attrezzo newAttrezzo = this.partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
		if( newAttrezzo != null ) {
			this.partita.getGiocatore().getBorsa().removeAttrezzo(newAttrezzo.getNome());
			this.partita.getStanzaCorrente().addAttrezzo(newAttrezzo);
		}
		else {
			io.mostraMessaggio("Oggetto non presente nella borsa");
			io.mostraMessaggio("Che attrezzo vuoi prendere?");
		}
		io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		io.mostraMessaggio(partita.getGiocatore().getBorsa().getDescrizione());
	}
	
	/**
	 * Comando "Fine".
	 */
	private void fine(IOConsole io) {
		io.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}

	public static void main(String[] argc) {
		DiaDia gioco = new DiaDia();
		IOConsole io = new IOConsole();
		gioco.gioca(io);
	}
}

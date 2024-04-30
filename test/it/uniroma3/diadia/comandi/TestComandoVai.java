package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class TestComandoVai {
	
	private Stanza stanzaIniziale;
	private Partita partita;
	private ComandoVai vai;
	private IO io;
	
	@Before
	public void setUp() {
		this.partita = new Partita();
		this.stanzaIniziale = partita.getStanzaCorrente();
		this.io = new IOConsole();
		this.vai = new ComandoVai(io);
	}

	@Test
	public void testComandoVaiNord() {
		Stanza stanzaNord = this.stanzaIniziale.getStanzaAdiacente("nord");
		vai.setParametro("nord");
		vai.esegui(this.partita);
		assertEquals(stanzaNord,partita.getStanzaCorrente());
	}
	
	@Test 
	public void testComandoVaiSud() {
		Stanza stanzaSud = this.stanzaIniziale.getStanzaAdiacente("sud");
		vai.setParametro("sud");
		vai.esegui(this.partita);
		assertEquals(stanzaSud,partita.getStanzaCorrente());
	}
	
	@Test
	public void testComandoVaiEst() {
		Stanza stanzaEst = this.stanzaIniziale.getStanzaAdiacente("est");
		vai.setParametro("est");
		vai.esegui(this.partita);
		assertEquals(stanzaEst,partita.getStanzaCorrente());
	}
	
	@Test
	public void testComandoVaiOvest() {
		Stanza stanzaOvest = this.stanzaIniziale.getStanzaAdiacente("ovest");
		vai.setParametro("ovest");
		vai.esegui(this.partita);
		assertEquals(stanzaOvest,partita.getStanzaCorrente());
	}
	
	@Test
	public void testComandoVaiNoDirezione() {
		assertEquals(this.stanzaIniziale,partita.getStanzaCorrente());
	}

}

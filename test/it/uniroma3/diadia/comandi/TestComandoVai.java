package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Direzione;
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
		this.io = new IOConsole(new Scanner(System.in));
		this.vai = new ComandoVai();
	}

	@Test
	public void testComandoVaiNord() {
		Stanza stanzaNord = this.stanzaIniziale.getStanzaAdiacente(Direzione.valueOf("NORD"));
		vai.setParametro("nord");
		this.vai.setIO(io);
		vai.esegui(this.partita);
		assertEquals(stanzaNord,partita.getStanzaCorrente());
	}
	
	@Test 
	public void testComandoVaiSud() {
		Stanza stanzaSud = this.stanzaIniziale.getStanzaAdiacente(Direzione.valueOf("SUD"));
		vai.setParametro("sud");
		this.vai.setIO(io);
		vai.esegui(this.partita);
		assertEquals(stanzaSud,partita.getStanzaCorrente());
	}
	
	@Test
	public void testComandoVaiEst() {
		Stanza stanzaEst = this.stanzaIniziale.getStanzaAdiacente(Direzione.valueOf("EST"));
		vai.setParametro("est");
		this.vai.setIO(io);
		vai.esegui(this.partita);
		assertEquals(stanzaEst,partita.getStanzaCorrente());
	}
	
	@Test
	public void testComandoVaiOvest() {
		Stanza stanzaOvest = this.stanzaIniziale.getStanzaAdiacente(Direzione.valueOf("OVEST"));
		vai.setParametro("ovest");
		this.vai.setIO(io);
		vai.esegui(this.partita);
		assertEquals(stanzaOvest,partita.getStanzaCorrente());
	}
	
	@Test
	public void testComandoVaiNoDirezione() {
		assertEquals(this.stanzaIniziale,partita.getStanzaCorrente());
	}

}

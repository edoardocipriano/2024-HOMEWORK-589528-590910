package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.ambienti.Direzione;
import it.uniroma3.diadia.ambienti.Stanza;

public class TestPartita {
	
	Partita p = new Partita();

	@Test
	public void testVintaConStanzaNonVincente() {
		assertFalse(p.vinta());
	}
	
	@Test
	public void testVintaConStanzaVincente() {
		Stanza atrio = p.getStanzaCorrente();
		Stanza biblioteca = atrio.getStanzaAdiacente(Direzione.valueOf("NORD"));
		p.setStanzaCorrente(biblioteca);
		assertTrue(p.vinta());
	}
	
	@Test
	public void testVintaConAltraStanzaNonVincente() {
		Stanza atrio = p.getStanzaCorrente();
		Stanza aulaN11 = atrio.getStanzaAdiacente(Direzione.valueOf("EST"));
		p.setStanzaCorrente(aulaN11);
		assertFalse(p.vinta());
	}
	
	// FINE TEST vinta
	
	@Test
	public void testIsFinitaSoloFinitaVera() {
		p.setFinita();
		assertTrue(p.isFinita());
	}
	
	@Test
	public void testIsFinitaSoloZeroCfuVera() {
		p.getGiocatore().setCfu(0);
		assertTrue(p.isFinita());
	}
	
	@Test
	public void testIsFinitaSoloStanzaVincente() {
		Stanza atrio = p.getStanzaCorrente();
		Stanza biblioteca = atrio.getStanzaAdiacente(Direzione.valueOf("NORD"));
		p.setStanzaCorrente(biblioteca);
		assertTrue(p.isFinita());
	}
	
	@Test
	public void testIsFinitaTutteFalse() {
		assertFalse(p.isFinita());
	}

}

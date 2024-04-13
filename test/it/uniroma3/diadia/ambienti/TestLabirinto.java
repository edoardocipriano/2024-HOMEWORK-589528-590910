package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;
import org.junit.*;

public class TestLabirinto {
	
	Labirinto l = new Labirinto();
	Stanza atrio = l.getStanzaIniziale();	// stanza iniziale di default	// stanza vincente di default
	Stanza salone = new Stanza("salone");
		

	@Test
	public void testGetStanzaInizialeDefault() {
		assertEquals(atrio,l.getStanzaIniziale());
	}
	
	@Test
	public void testGetStanzaCorrenteAltraStanza() {
		l.setStanzaIniziale(salone);
		assertEquals(salone,l.getStanzaIniziale());
	}
	
	@Test
	public void testGetStanzaCorrenteNull() {
		l.setStanzaIniziale(null);
		assertEquals(null,l.getStanzaIniziale());
	}
	// FINE TEST getStanzaCorrente E setStanzaCorrente -> TEST UNICI PERCHE' I TEST SONO IDENTICI

}

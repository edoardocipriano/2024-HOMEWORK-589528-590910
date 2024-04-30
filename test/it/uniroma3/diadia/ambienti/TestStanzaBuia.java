package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class TestStanzaBuia {
	
	private StanzaBuia stanza1;
	private Attrezzo coltello;
	private Attrezzo scudo;
	
	@Before
	public void setUp() {
		 this.stanza1 = new StanzaBuia("biblioteca","coltello");
		 this.coltello = new Attrezzo("coltello",1);
		 this.scudo = new Attrezzo("scudo",2);
	}

	@Test
	public void testGetDescrizioneSenzaAttrezzo() {
		assertEquals("Qui c'e buio pesto",stanza1.getDescrizione());
	}
	
	@Test
	public void testGetDescrizioneConAttrezzo() {
		 this.stanza1.addAttrezzo(coltello);
		 assertEquals(stanza1.getNome()+"\nUscite: "+"\nAttrezzi nella stanza: coltello (1kg) ",stanza1.getDescrizione());
	}
	
	@Test
	public void testGetDescrizioneAttrezzoNonVisibile() {
		 this.stanza1.addAttrezzo(scudo);
		 assertEquals("Qui c'e buio pesto",stanza1.getDescrizione());
	}
	
	@Test
	public void testGetDescrizioneDueOggettiUnoVisibile() {
		 this.stanza1.addAttrezzo(coltello);
		 this.stanza1.addAttrezzo(scudo);
		 assertEquals(stanza1.getNome()+"\nUscite: "+"\nAttrezzi nella stanza: coltello (1kg) scudo (2kg) ",stanza1.getDescrizione());
	}

}

package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.*;

public class TestStanza {
	
	Stanza stanza1 = new Stanza("Stanza 1");
	Stanza stanza2 = new Stanza("Stanza 2");
	
	Attrezzo lanterna = new Attrezzo("Lanterna",2);
	Attrezzo spada = new Attrezzo("Spada",4);
	Attrezzo zaino = new Attrezzo("Zaino",1);
	Attrezzo bussola = new Attrezzo("Bussola",1);
	Attrezzo coltello = new Attrezzo("Coltello",2);
	Attrezzo borraccia = new Attrezzo("Borraccia",1);
	Attrezzo fornello = new Attrezzo("Fornello",3);
	Attrezzo arco = new Attrezzo("Arco",2);
	Attrezzo faretra = new Attrezzo("Faretra",1);
	Attrezzo scudo = new Attrezzo("Scudo",4);
	Attrezzo elmetto = new Attrezzo("Elmetto",2);
	
	Attrezzo[] attrezzi = {lanterna,spada,zaino,bussola,coltello,borraccia,fornello,arco,faretra,scudo};

	@Test
	public void testGetEdImpostaStanzaAdiacenteNord() {
		stanza1.impostaStanzaAdiacente("nord",stanza2);
		assertEquals(stanza2,stanza1.getStanzaAdiacente("nord"));
	}
	
	@Test
	public void testGetEdImpostaStanzaAdiacenteEst() {
		stanza1.impostaStanzaAdiacente("est",stanza2);
		assertEquals(stanza2,stanza1.getStanzaAdiacente("est"));
	}
	
	@Test
	public void testGetEdImpostaStanzaAdiacenteSud() {
		stanza1.impostaStanzaAdiacente("sud",stanza2);
		assertEquals(stanza2,stanza1.getStanzaAdiacente("sud"));
	}
	
	@Test
	public void testGetEdImpostaStanzaAdiacenteOvest() {
		stanza1.impostaStanzaAdiacente("ovest", stanza2);
		assertEquals(stanza2,stanza1.getStanzaAdiacente("ovest"));
	}
	
	@Test
	public void testGetEdImpostaStanzaAdiacenteNoDirezione() {
		assertEquals(null,stanza1.getStanzaAdiacente("nord"));
	}
	
	// TEST UNICI PER DUE METODI PERCHE' SAREBBERO TEST IDENTICI - FINE TEST
	
	@Test
	public void testAddAttrezzoSenzaAttrezzi() {
		assertTrue(stanza1.addAttrezzo(bussola));
	}
	
	@Test
	public void testAddAttrezzoConUnAttrezzo() {
		stanza1.addAttrezzo(bussola);
		assertTrue(stanza1.addAttrezzo(zaino));
	}
	
	@Test
	public void testAddAttrezzoConTreAttrezzi() {
		stanza1.addAttrezzo(bussola);
		stanza1.addAttrezzo(zaino);
		stanza1.addAttrezzo(spada);
		assertTrue(stanza1.addAttrezzo(lanterna));
	}
	
	@Test
	public void testAddAttrezzoConMaxAttrezzi() {
		for(Attrezzo attrezzo : attrezzi)
			stanza1.addAttrezzo(attrezzo);
		assertFalse(stanza1.addAttrezzo(elmetto));
	}
	
	// FINE TEST addAttrezzo
	
	@Test
	public void testGetAttrezzoNoAttrezzi() {
		assertEquals(null,stanza1.getAttrezzo("Lanterna"));
	}
	
	@Test
	public void testGetAttrezzoUnAttrezzoCercato() {
		stanza1.addAttrezzo(arco);
		assertEquals(arco,stanza1.getAttrezzo("Arco"));
	}
	
	@Test
	public void testGetAttrezzoUnAttrezzoNonCercato() {
		stanza1.addAttrezzo(arco);
		assertEquals(null,stanza1.getAttrezzo(("Lanterna")));
	}
	
	@Test
	public void testGetAttrezzoDueAttrezziUnoCercato() {
		stanza1.addAttrezzo(arco);
		stanza1.addAttrezzo(elmetto);
		assertEquals(elmetto,stanza1.getAttrezzo("Elmetto"));
	}
	
	// FINE TEST getAttrezzo
	
	@Test
	public void testHasAttrezzoNoAttrezzi() {
		assertFalse(stanza1.hasAttrezzo("Lanterna"));
	}
	
	@Test
	public void testHasAttrezzoUnAttrezzoCercato() {
		stanza1.addAttrezzo(spada);
		assertTrue(stanza1.hasAttrezzo("Spada"));
	}
	
	@Test
	public void testHasAttrezzoUnAttrezzoNonCercato() {
		stanza1.addAttrezzo(faretra);
		assertFalse(stanza1.hasAttrezzo("Elmetto"));
	}
	
	// FINE TEST hasAttrezzo
	

}

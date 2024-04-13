package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class TestBorsa {
	
	Borsa b = new Borsa();
	Attrezzo lanterna = new Attrezzo("Lanterna",2);
	Attrezzo spada = new Attrezzo("Spada",4);
	Attrezzo zaino = new Attrezzo("Zaino",1);
	Attrezzo bussola = new Attrezzo("Bussola",1);
	Attrezzo coltello = new Attrezzo("Coltello",2);

	@Test
	public void testAddGetAttrezzoBorsaVuota() {
		b.addAttrezzo(lanterna);
		assertEquals(lanterna,b.getAttrezzo("Lanterna"));
	}
	
	@Test
	public void testAddGetAttrezzoBorsaUnAttrezzoPrimoAttrezzoRichiesto() {
		b.addAttrezzo(lanterna);
		b.addAttrezzo(bussola);
		assertEquals(lanterna,b.getAttrezzo("Lanterna"));
	}
	
	@Test
	public void testAddGetAttrezzoBorsaUnAttrezzoSecondoattrezzoRichiesto() {
		b.addAttrezzo(lanterna);
		b.addAttrezzo(bussola);
		assertEquals(bussola,b.getAttrezzo("Bussola"));
	}
	
	@Test
	public void testGetAttrezzoBorsaVuota() {
		assertEquals(null,b.getAttrezzo("Lanterna"));
	}
	
	@Test
	public void testAddGetAttrezzoUnAttrezzoNonRichiesto() {
		b.addAttrezzo(spada);
		assertEquals(null,b.getAttrezzo("Coltello"));
	}
	
	@Test
	public void testAddGetAttrezzoDueAttrezziNonRichiesti() {
		b.addAttrezzo(zaino);
		b.addAttrezzo(spada);
		assertEquals(null,b.getAttrezzo("Bussola"));
	}
	
	@Test
	public void testHasAttrezzoBorsaVuota() {
		assertFalse(b.hasAttrezzo("Bussola"));
	}
	
	@Test
	public void testHasAttrezzoUnAttrezzoNonCercato() {
		b.addAttrezzo(lanterna);
		assertFalse(b.hasAttrezzo("Spada"));
	}
	
	@Test
	public void testHasAttrezzoUnAttrezzoCercato() {
		b.addAttrezzo(bussola);
		assertTrue(b.hasAttrezzo("Bussola"));
	}
	
	@Test
	public void testHasAttrezzoDueAttrezziUnoCercato() {
		b.addAttrezzo(bussola);
		b.addAttrezzo(spada);
		assertTrue(b.hasAttrezzo("Spada"));
	}
	
	@Test
	public void testHasAttrezzoDueAttrezziNonCercati() {
		b.addAttrezzo(coltello);
		b.addAttrezzo(lanterna);
		assertFalse(b.hasAttrezzo("Zaino"));
	}
	
	@Test
	public void testRemoveAttrezzoBorsaVuota() {
		assertEquals(null,b.removeAttrezzo("Spada"));
	}
	
	@Test
	public void testRemoveAttrezzoUnElementoDaRimuovere() {
		b.addAttrezzo(bussola);
		assertEquals(bussola,b.removeAttrezzo("Bussola"));
	}
	
	@Test
	public void testRemoveAttrezzoUnElementoDaNonRimuovere() {
		b.addAttrezzo(spada);
		assertEquals(null,b.removeAttrezzo("Lanterna"));
	}
	
	@Test
	public void testRemoveAttrezzoDueElementiSecondoDaRimuovere() {
		b.addAttrezzo(bussola);
		b.addAttrezzo(zaino);
		assertEquals(zaino,b.removeAttrezzo("Zaino"));
	}
	
	@Test
	public void testRemoveAttrezzoDueElementiPrimoDaRimuovere() {
		b.addAttrezzo(spada);
		b.addAttrezzo(lanterna);
		assertEquals(spada,b.removeAttrezzo("Spada"));
		
	}
	
	@Test
	public void testRemoveAttrezzoDueElementiDaNonRimuovere() {
		b.addAttrezzo(coltello);
		b.addAttrezzo(bussola);
		assertEquals(null,b.removeAttrezzo("Lanterna"));
	}

}

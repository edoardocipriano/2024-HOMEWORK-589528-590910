package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.ComparatorePerNome;
import it.uniroma3.diadia.attrezzi.ComparatorePerPeso;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;


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
	
	@Test
	public void testGetContenutoOrdinatoPerPesoDueElementi() {
		b.addAttrezzo(coltello);
		b.addAttrezzo(bussola);
		List<Attrezzo> lista = new ArrayList<>();
		lista.add(bussola);
		lista.add(coltello);
		assertEquals(lista,b.getContenutoOrdinatoPerPeso());
	}
	
	@Test
	public void testGetContenutoOrdinatoPerPesoTreElementiPesoDiverso() {
		b.addAttrezzo(coltello);
		b.addAttrezzo(bussola);
		b.addAttrezzo(spada);
		List<Attrezzo> lista = new ArrayList<>();
		lista.add(bussola);
		lista.add(coltello);
		lista.add(spada);
		assertEquals(lista,b.getContenutoOrdinatoPerPeso());
	}
	
	@Test
	public void testGetContenutoOrdinatoPerPesoTreElementiDuePesoUguale() {
		b.addAttrezzo(coltello);
		b.addAttrezzo(lanterna);
		b.addAttrezzo(bussola);
		List<Attrezzo> lista = new ArrayList<>();
		lista.add(bussola);
		lista.add(coltello);
		lista.add(lanterna);
		assertEquals(lista,b.getContenutoOrdinatoPerPeso());
	}
	
	@Test
	public void testGetContenutoOrdinatoPerNomeDueElementi() {
		b.addAttrezzo(lanterna);
		b.addAttrezzo(coltello);
		ComparatorePerNome comp = new ComparatorePerNome();
		SortedSet<Attrezzo> tree = new TreeSet<>(comp);
		tree.add(lanterna);
		tree.add(coltello);
		assertEquals(tree,b.getContenutoOrdinatoPerNome());
	}
	
	@Test
	public void testGetContenutoOrdinatoPerNomeTreElementi() {
		b.addAttrezzo(lanterna);
		b.addAttrezzo(coltello);
		b.addAttrezzo(bussola);
		ComparatorePerNome comp = new ComparatorePerNome();
		SortedSet<Attrezzo> tree = new TreeSet<>(comp);
		tree.add(lanterna);
		tree.add(coltello);
		tree.add(bussola);
		assertEquals(tree,b.getContenutoOrdinatoPerNome());
	}
	
	@Test
	public void testGetContenutoRaggruppatoPerPesoDuePesiDiversi() {
		b.addAttrezzo(lanterna);
		b.addAttrezzo(bussola);
		Map<Integer,Set<Attrezzo>> mappa = new HashMap<>();
		Set<Attrezzo> pesoUno = new HashSet<>();
		pesoUno.add(bussola);
		Set<Attrezzo> pesoDue = new HashSet<>();
		pesoDue.add(lanterna);
		mappa.put(1, pesoUno);
		mappa.put(2, pesoDue);
		assertEquals(mappa,b.getContenutoRaggruppatoPerPeso());
		
	}
	
	@Test
	public void testGetContenutoRaggruppatoPerPesoDuePesoUguale() {
		b.addAttrezzo(zaino);
		b.addAttrezzo(bussola);
		Map<Integer,Set<Attrezzo>> mappa = new HashMap<>();
		Set<Attrezzo> pesoUno = new HashSet<>();
		pesoUno.add(zaino);
		pesoUno.add(bussola);
		mappa.put(1, pesoUno);
		assertEquals(mappa,b.getContenutoRaggruppatoPerPeso());
	}
	
	@Test
	public void testGetContenutoRaggruppatoPerPesoDueUgualiUnoDiverso() {
		b.addAttrezzo(zaino);
		b.addAttrezzo(bussola);
		b.addAttrezzo(lanterna);
		Map<Integer,Set<Attrezzo>> mappa = new HashMap<>();
		Set<Attrezzo> pesoUno = new HashSet<>();
		pesoUno.add(zaino);
		pesoUno.add(bussola);
		Set<Attrezzo> pesoDue = new HashSet<>();
		pesoDue.add(lanterna);
		mappa.put(1, pesoUno);
		mappa.put(2, pesoDue);
		assertEquals(mappa,b.getContenutoRaggruppatoPerPeso());
		
	}
	
	@Test
	public void testGetSortedOrdinatoPerPesoDuePesiDiversi() {
		b.addAttrezzo(lanterna);
		b.addAttrezzo(bussola);
		ComparatorePerPeso comp = new ComparatorePerPeso();
		SortedSet<Attrezzo> tree = new TreeSet<>(comp);
		tree.add(bussola);
		tree.add(lanterna);
		assertEquals(tree,b.getSortedOrdinatoPerPeso());
		
	}
	
	@Test
	public void testGetSortedOrdinatoPerPesoDuePesiUguali() {
		b.addAttrezzo(zaino);
		b.addAttrezzo(bussola);
		ComparatorePerPeso comp = new ComparatorePerPeso();
		SortedSet<Attrezzo> tree = new TreeSet<>(comp);
		tree.add(zaino);
		tree.add(bussola);
		assertEquals(tree,b.getSortedOrdinatoPerPeso());
	}
	
	@Test
	public void testGetSortedOrdinatoPerPesoDuePesiUgualiUnoDiverso() {
		b.addAttrezzo(spada);
		b.addAttrezzo(zaino);
		b.addAttrezzo(bussola);
		ComparatorePerPeso comp = new ComparatorePerPeso();
		SortedSet<Attrezzo> tree = new TreeSet<>(comp);
		tree.add(zaino);
		tree.add(bussola);
		tree.add(spada);
		assertEquals(tree,b.getSortedOrdinatoPerPeso());
	}

}

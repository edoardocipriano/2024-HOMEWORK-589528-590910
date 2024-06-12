package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class TestComandoPrendi {
	
	private Partita partita;
	private ComandoPrendi prendi;
	private IO io;
	
	@Before
	public void setUp() {
		this.partita = new Partita();
		this.io = new IOConsole(new Scanner(System.in));
		this.prendi = new ComandoPrendi();
		this.prendi.setIO(io);
		Attrezzo scudo = new Attrezzo("scudo",2);
		Attrezzo spada = new Attrezzo("spada",3);
		this.partita.getStanzaCorrente().addAttrezzo(scudo);
		this.partita.getStanzaCorrente().addAttrezzo(spada);
	}

	@Test
	public void testBorsaVuotaAttrezzoPresente() {
		this.prendi.setParametro("scudo");
		this.prendi.esegui(partita);
		assertTrue(this.partita.getGiocatore().getBorsa().hasAttrezzo("scudo"));
	}
	
	@Test
	public void testBorsaVuotaAttrezzoNonPresente() {
		this.prendi.setParametro("arco");
		this.prendi.esegui(partita);
		assertFalse(this.partita.getGiocatore().getBorsa().hasAttrezzo("arco"));
	}
	
	@Test
	public void testBorsaNonVuotaAttrezzoPresente() {
		this.partita.getGiocatore().getBorsa().addAttrezzo(new Attrezzo("tavolino",1));
		this.prendi.setParametro("spada");
		this.prendi.esegui(partita);
		assertTrue(this.partita.getGiocatore().getBorsa().hasAttrezzo("spada"));
	}
	
	@Test
	public void testBorsaNonVuotaAttrezzoNonPresente() {
		this.partita.getGiocatore().getBorsa().addAttrezzo(new Attrezzo("coltello",1));
		this.prendi.setParametro("taglierino");
		this.prendi.esegui(partita);
		assertFalse(this.partita.getGiocatore().getBorsa().hasAttrezzo("taglierino"));
	}

}

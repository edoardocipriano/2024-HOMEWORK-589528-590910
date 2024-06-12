package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class TestComandoPosa {
	
	private Partita partita;
	private ComandoPosa posa;
	private IO io;
	
	@Before
	public void setUp() {
		this.partita = new Partita();
		this.io = new IOConsole(new Scanner(System.in));
		this.posa = new ComandoPosa();
	}

	@Test
	public void testBorsaVuotaOggettoQualsiasi() {
		this.posa.setParametro("coltello");
		this.posa.setIO(io);
		this.posa.esegui(partita);
		assertFalse(this.partita.getStanzaCorrente().hasAttrezzo("coltello"));
	}
	
	@Test
	public void testBorsaUnOggettoNonPosato() {
		this.partita.getGiocatore().getBorsa().addAttrezzo(new Attrezzo("spada",3));
		this.posa.setParametro("coltello");
		this.posa.setIO(io);
		this.posa.esegui(partita);
		assertFalse(this.partita.getStanzaCorrente().hasAttrezzo("spada"));
	}
	
	@Test
	public void testBorsaUnOggettoPosato() {
		this.partita.getGiocatore().getBorsa().addAttrezzo(new Attrezzo("scudo",2));
		this.posa.setParametro("scudo");
		this.posa.setIO(io);
		this.posa.esegui(partita);
		assertTrue(this.partita.getStanzaCorrente().hasAttrezzo("scudo"));
	}
	
	

}

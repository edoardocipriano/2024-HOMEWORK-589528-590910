package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;

public class TestFabbricaDiComandiFisarmonica {
	
	private FabbricaDiComandiFisarmonica factory;
	private IO io;
	
	@Before
	public void setUp() {
		this.io = new IOConsole(new Scanner(System.in));
		this.factory = new FabbricaDiComandiFisarmonica(io);
	}

	@Test
	public void testConComandoVai() {
		AbstractComando vai = factory.costruisciComando("vai");
		assertEquals("vai",vai.getNome());
	}
	
	@Test
	public void testConComandoPosa() {
		AbstractComando posa = factory.costruisciComando("posa");
		assertEquals("posa",posa.getNome());
	}
	
	@Test
	public void testConComandoPrendi() {
		AbstractComando prendi = factory.costruisciComando("prendi");
		assertEquals("prendi",prendi.getNome());
	}
	
	@Test
	public void testConComandoAiuto() {
		AbstractComando aiuto = factory.costruisciComando("aiuto");
		assertEquals("aiuto",aiuto.getNome());
	}
	
	@Test
	public void testConComandoGuarda() {
		AbstractComando guarda = factory.costruisciComando("guarda");
		assertEquals("guarda",guarda.getNome());
	}
	
	@Test
	public void testConComandoNonValido() {
		AbstractComando nonValido = factory.costruisciComando("non valido");
		assertEquals("non valido", nonValido.getNome());
	}
	
	@Test
	public void testConComandoFine() {
		AbstractComando fine = factory.costruisciComando("fine");
		assertEquals("fine",fine.getNome());
	}

}

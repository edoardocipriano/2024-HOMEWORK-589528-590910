package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class TestStanzaBloccata {
	
	private StanzaBloccata stanza1;
	private Stanza stanzaNord;
	private Stanza stanzaEst;
	private Stanza stanzaSud;
	private Stanza stanzaOvest;
	private Attrezzo coltello;
	private Attrezzo scudo;
	private Attrezzo spada;
	
	@Before
	public void setUp() {
		this.stanza1 = new StanzaBloccata("stanza1",Direzione.valueOf("NORD"),"coltello");
		this.stanzaNord = new Stanza("stanzaNord");
		this.stanzaEst = new Stanza("stanzaEst");
		this.stanzaSud = new Stanza("stanzaSud");
		this.stanzaOvest = new Stanza("stanzaOvest");
		this.coltello = new Attrezzo("coltello",1);
		this.scudo = new Attrezzo("scudo",2);
		this.spada = new Attrezzo("spada",3);
		
		stanza1.impostaStanzaAdiacente(Direzione.valueOf("NORD"), stanzaNord);
		stanza1.impostaStanzaAdiacente(Direzione.valueOf("EST"), stanzaEst);
		stanza1.impostaStanzaAdiacente(Direzione.valueOf("SUD"), stanzaSud);
		stanza1.impostaStanzaAdiacente(Direzione.valueOf("OVEST"), stanzaOvest);
	}

	@Test
	public void testGetStanzaAdiacenteNessunAttrezzo() {
		assertEquals(stanza1,stanza1.getStanzaAdiacente(Direzione.valueOf("NORD")));
	}
	
	@Test
	public void testGetStanzaAdiacenteUnAttrezzoNonSblocca() {
		stanza1.addAttrezzo(spada);
		assertEquals(stanza1,stanza1.getStanzaAdiacente(Direzione.valueOf("NORD")));
	}
	
	@Test
	public void testGetStanzaAdiacenteUnAttrezzoDirezioneNonBloccata() {
		stanza1.addAttrezzo(spada);
		assertEquals(stanzaSud,stanza1.getStanzaAdiacente(Direzione.valueOf("SUD")));
	}
	
	@Test
	public void testGetStanzaAdiacenteNessunAttrezzoDirezioneNonBloccata() {
		assertEquals(stanzaOvest,stanza1.getStanzaAdiacente(Direzione.valueOf("OVEST")));
	}
	
	@Test
	public void testGetStanzaAdiacenteDueAttrezziNonSbloccanoDirezioneBloccata() {
		stanza1.addAttrezzo(spada);
		stanza1.addAttrezzo(scudo);
		assertEquals(stanza1,stanza1.getStanzaAdiacente(Direzione.valueOf("NORD")));
	}
	
	@Test
	public void testGetStanzaAdiacenteUnAttrezzoSbloccaDirezioneBloccata() {
		stanza1.addAttrezzo(coltello);
		assertEquals(stanzaNord,stanza1.getStanzaAdiacente(Direzione.valueOf("NORD")));
	}
	
	@Test
	public void testGetStanzaAdiacenteDueAttrezziUnoSbloccaDirezioneBloccata() {
		stanza1.addAttrezzo(coltello);
		stanza1.addAttrezzo(scudo);
		assertEquals(stanzaNord,stanza1.getStanzaAdiacente(Direzione.valueOf("NORD")));
	}
	
	@Test
	public void testGetStanzaAdiacenteUnAttrezzoSbloccaDirezioneNonBloccata() {
		stanza1.addAttrezzo(coltello);
		assertEquals(stanzaSud,stanza1.getStanzaAdiacente(Direzione.valueOf("SUD")));
	}
 
}

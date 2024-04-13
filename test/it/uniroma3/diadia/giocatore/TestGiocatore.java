package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestGiocatore {
	
	Giocatore g = new Giocatore();

	@Test
	public void testGetCfuDefault() {
		assertEquals(20,g.getCfu());
	}
	
	@Test
	public void testSetGetCfuDiminuitiDiUno() {
		g.setCfu(g.getCfu()-1);
		assertEquals(19,g.getCfu());
	}
	
	@Test
	public void testSetGetCfuAumentatiDiUno() {
		g.setCfu(g.getCfu()+1);
		assertEquals(21,g.getCfu());
	}
	
	@Test
	public void testSetGetCfuZero() {
		g.setCfu(0);
		assertEquals(0,g.getCfu());
	}
	
	

}

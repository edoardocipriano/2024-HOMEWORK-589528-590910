package it.uniroma3.diadia.ambienti;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import it.uniroma3.diadia.CaricatoreLabirinto;
import it.uniroma3.diadia.FormatoFileNonValidoException;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Labirinto {
	
	private Stanza stanzaIniziale;
	private Stanza stanzaVincente;
	
	private Labirinto(String file) throws FileNotFoundException, FormatoFileNonValidoException {
	
		CaricatoreLabirinto c = new CaricatoreLabirinto(file);
		c.carica();
		this.stanzaIniziale = c.getStanzaIniziale();
		this.stanzaVincente = c.getStanzaVincente();
		
	}
	
	public Labirinto() {
		
		Attrezzo lanterna = new Attrezzo("lanterna",3);
		Attrezzo osso = new Attrezzo("osso",1);
		
		Stanza atrio = new Stanza("Atrio");
		Stanza aulaN11 = new Stanza("Aula N11");
		Stanza aulaN10 = new Stanza("Aula N10");
		Stanza laboratorio = new Stanza("Laboratorio Campus");
		Stanza biblioteca = new Stanza("Biblioteca");
		
		
		atrio.impostaStanzaAdiacente(Direzione.valueOf("NORD"), biblioteca);
		atrio.impostaStanzaAdiacente(Direzione.valueOf("EST"), aulaN11);
		atrio.impostaStanzaAdiacente(Direzione.valueOf("SUD"), aulaN10);
		atrio.impostaStanzaAdiacente(Direzione.valueOf("OVEST"), laboratorio);
		aulaN11.impostaStanzaAdiacente(Direzione.valueOf("EST"), laboratorio);
		aulaN11.impostaStanzaAdiacente(Direzione.valueOf("OVEST"), atrio);
		aulaN10.impostaStanzaAdiacente(Direzione.valueOf("NORD"), atrio);
		aulaN10.impostaStanzaAdiacente(Direzione.valueOf("EST"), aulaN11);
		aulaN10.impostaStanzaAdiacente(Direzione.valueOf("OVEST"), laboratorio);
		laboratorio.impostaStanzaAdiacente(Direzione.valueOf("EST"), atrio);
		laboratorio.impostaStanzaAdiacente(Direzione.valueOf("OVEST"), aulaN11);
		biblioteca.impostaStanzaAdiacente(Direzione.valueOf("SUD"), atrio);

        
		aulaN10.addAttrezzo(lanterna);
		atrio.addAttrezzo(osso);

		// il gioco comincia nell'atrio
        this.stanzaIniziale = atrio;  
		this.stanzaVincente = biblioteca;
	}
	
	public Stanza getStanzaIniziale() {
		return this.stanzaIniziale;
	}
	
	public Stanza getStanzaVincente() {
		return this.stanzaVincente;
	}
	
	public void setStanzaIniziale(Stanza stanzaCorrente) {
		this.stanzaIniziale = stanzaCorrente;
	}
	
	public void setStanzaVincente(Stanza stanza) {
		this.stanzaVincente = stanza;
	}
	
	public static LabirintoBuilder newBuilder(String labirinto) throws FileNotFoundException, FormatoFileNonValidoException {
		return new LabirintoBuilder(labirinto);
	}
	
	public static class LabirintoBuilder {
		
		private Labirinto labirinto;
		private Stanza ultimaStanzaAggiunta;
		private Map<String, Stanza> stanze;

		public LabirintoBuilder(String file) throws FileNotFoundException, FormatoFileNonValidoException {
			this.labirinto = new Labirinto(file);
			this.stanze = new HashMap<String, Stanza>();
		}
		
		public Map<String, Stanza> getStanze() {
			return stanze;
		}

		public Labirinto getLabirinto() {
			return this.labirinto;
		}

		public LabirintoBuilder addStanzaIniziale(String stanzaIniziale) {
			Stanza i = new Stanza(stanzaIniziale);
			this.labirinto.setStanzaIniziale(i);
			this.ultimaStanzaAggiunta(i);
			return this;
		}

		public LabirintoBuilder addStanzaVincente(String stanzaVincente) {
			Stanza s = new Stanza(stanzaVincente);
			this.labirinto.setStanzaVincente(s);
			this.ultimaStanzaAggiunta(s);
			return this;
		}

		public LabirintoBuilder addStanza(String stanza) {
			Stanza s = new Stanza(stanza);
			this.ultimaStanzaAggiunta(s);
			return this;
		}	

		public LabirintoBuilder addAttrezzo(String attrezzo, int peso) {
			Attrezzo a = new Attrezzo(attrezzo, peso);
			if(this.ultimaStanzaAggiunta==null)
				return this;
			this.ultimaStanzaAggiunta.addAttrezzo(a);
			return this;
		}

		public LabirintoBuilder addAdiacenza(String stanzaCorrente, String stanzaAdiecente, Direzione direzione) {
			Stanza c = this.stanze.get(stanzaCorrente);
			Stanza a = this.stanze.get(stanzaAdiecente);
			c.impostaStanzaAdiacente(direzione, a);
			return this;
		}
		
		public LabirintoBuilder addStanzaMagica(String nome) {
			Stanza stanza = new StanzaMagica(nome);
			this.ultimaStanzaAggiunta(stanza);
			return this;
		}
		
		public LabirintoBuilder addStanzaBuia(String nome, String attrezzoPerVedere) {
			Stanza stanza = new StanzaBuia(nome,attrezzoPerVedere);
			this.ultimaStanzaAggiunta(stanza);
			return this;
		}
		
		public LabirintoBuilder addStanzaBloccata(String nome, String attrezzoSbloccante, Direzione direzioneBloccata) {
			Stanza stanza = new StanzaBloccata(nome, direzioneBloccata,attrezzoSbloccante);
			this.ultimaStanzaAggiunta(stanza);
			return this;
		}
		
		public void ultimaStanzaAggiunta(Stanza stanza) {
			this.ultimaStanzaAggiunta = stanza;
			this.stanze.put(stanza.getNome(), stanza);
		}
		
	}
	
	
}

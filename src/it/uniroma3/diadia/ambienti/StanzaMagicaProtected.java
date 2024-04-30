package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagicaProtected extends StanzaMagica {

	final static protected int SOGLIA_MAGICA_DEFAULT = 3;
	@SuppressWarnings("unused")
	static final protected int NUMERO_MASSIMO_DIREZIONI = 4;
	static final protected int NUMERO_MASSIMO_ATTREZZI = 10;
	
	protected int contatoreAttrezziPosati;
	protected int sogliaMagica;
	
	public StanzaMagicaProtected(String nome,int soglia) {
		super(nome,soglia);
	}
	
	public StanzaMagicaProtected(String nome) {
		super(nome);
	}
	
	protected Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
		StringBuilder nomeInvertito;
		int pesoX2 = attrezzo.getPeso() * 2;
		nomeInvertito = new StringBuilder(attrezzo.getNome());
		nomeInvertito = nomeInvertito.reverse();
		attrezzo = new Attrezzo(nomeInvertito.toString(),
		pesoX2);
		return attrezzo;
	}
	
}

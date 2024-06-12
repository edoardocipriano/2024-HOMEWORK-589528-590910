package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagica extends Stanza {

	final static private int SOGLIA_MAGICA_DEFAULT = 3;		// SOGLIA VOLTE CHE POSI ATTREZZO
	@SuppressWarnings("unused")
	static final private int NUMERO_MASSIMO_ATTREZZI = 10;
	
	private int contatoreAttrezziPosati;
	private int sogliaMagica;
	
	public StanzaMagica(String nome,int soglia) {
		super(nome);
		this.contatoreAttrezziPosati = 0;
		this.sogliaMagica = soglia;
	}
	
	public StanzaMagica(String nome) {
		this(nome,SOGLIA_MAGICA_DEFAULT);
	}
	
	@Override
    public boolean addAttrezzo(Attrezzo attrezzo) {
        if (this.getNumeroAttrezzi() < NUMERO_MASSIMO_ATTREZZI) {
        	if(this.contatoreAttrezziPosati >= sogliaMagica) {
        		attrezzo = this.modificaAttrezzo(attrezzo);
        	}
        	this.getAttrezzi().add(attrezzo);
        	this.contatoreAttrezziPosati += 1;
        	return true;
        }
        else {
        	return false;
        }
    }
	
	private Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
		StringBuilder nomeInvertito;
		int pesoX2 = attrezzo.getPeso() * 2;
		nomeInvertito = new StringBuilder(attrezzo.getNome());
		nomeInvertito = nomeInvertito.reverse();
		attrezzo = new Attrezzo(nomeInvertito.toString(),
		pesoX2);
		return attrezzo;
	}
	
	@Override
	public String getNome() {
		return "ciao";
	}
	
	
	
}

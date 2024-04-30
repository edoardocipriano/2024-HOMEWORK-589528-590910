package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccata extends Stanza {

	private String direzioneBloccata;
	private String attrezzoSblocca;
	
	public StanzaBloccata(String nome,String direzione,String attrezzo) {
		super(nome);
		this.direzioneBloccata = direzione;
		this.attrezzoSblocca = attrezzo;
	}
	
	@Override
	public Stanza getStanzaAdiacente(String dir) {
		if(!this.hasAttrezzo(attrezzoSblocca)&&direzioneBloccata.equals(dir))
			return this;
		else
			return super.getStanzaAdiacente(dir);
	}
	
	@Override
	public String getDescrizione() {
		if(!this.hasAttrezzo(attrezzoSblocca)) {
	    	StringBuilder risultato = new StringBuilder();
	    	risultato.append(this.getNome());
	    	risultato.append("\nDirezione bloccata: "+this.direzioneBloccata);
	    	risultato.append("\nUscite: ");
	    	for (String direzione : this.getDirezioni()) 
	    		if (direzione!=null)
	    			risultato.append(" " + direzione);
	    	risultato.append("\nAttrezzi nella stanza: ");
	    	for (Attrezzo attrezzo : this.getAttrezzi()) {
	    		if(attrezzo!=null)	// prima modifica -> in teoria risolve null pointer exception
	    			risultato.append(attrezzo.toString()+" ");
	    	}
	    	return risultato.toString();
		}
		else
			return super.getDescrizione();
			
	}
	
}

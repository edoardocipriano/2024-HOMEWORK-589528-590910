package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza{

	private String attrezzoStanzaBuia;
	
	
	public StanzaBuia(String nome,String nomeAttrezzo) {
		super(nome);
		this.attrezzoStanzaBuia = nomeAttrezzo;
	}
	
	@Override
	public String getDescrizione() {
		if(!this.hasAttrezzo(attrezzoStanzaBuia)) 
			return "Qui c'e buio pesto";
		else 
			return super.getDescrizione();
	}
	
}

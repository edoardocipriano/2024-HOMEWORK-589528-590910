package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.*;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.SortedSet;
import java.util.TreeSet;


public class Borsa {

	private List<Attrezzo> attrezzi;
	private int pesoMax;
	static final private int DEFAULT_PESO_MAX = 10;
	
	public Borsa() {
		this(DEFAULT_PESO_MAX);
	}
	
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new ArrayList<>(); 
	}
	
	public boolean addAttrezzo(Attrezzo attrezzo) {
		return this.attrezzi.add(attrezzo);
	}
	
	public int getPesoMax() {
		return pesoMax;
	}

	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo attrezzoCercato = null;
		for(Attrezzo a : this.attrezzi) {
			if(a.getNome().equals(nomeAttrezzo))
				attrezzoCercato = a;
		}
		
		return attrezzoCercato;
	}
	
	public int getPeso() {
		int peso = 0;
		for(Attrezzo a : this.attrezzi)
			peso += a.getPeso();

		return peso;
	}
	
	public boolean isEmpty() {
		return this.attrezzi.isEmpty();
	}
	
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}
	
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo attrezzoRimosso = null;
		boolean rimosso = false;
		for(Attrezzo a : this.attrezzi) {
			if(a.getNome().equals(nomeAttrezzo)) {
				attrezzoRimosso = a;
				rimosso = true;
			}
		}
		
		if(rimosso)
			this.attrezzi.remove(attrezzoRimosso);
		return attrezzoRimosso;
	}
	
	public String getDescrizione() {
		return this.toString();
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();

		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			for(Attrezzo a : this.attrezzi)
				s.append(a.toString()+" ");
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}
	
	public List<Attrezzo> getContenutoOrdinatoPerPeso() {
		ComparatorePerPeso comparatore = new ComparatorePerPeso();
		Collections.sort(this.attrezzi,comparatore);
		
		return this.attrezzi;
	}
	
	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome() {
		ComparatorePerNome comparatore = new ComparatorePerNome();
		SortedSet<Attrezzo> tree = new TreeSet<>(comparatore);
		tree.addAll(this.attrezzi);
		
		return tree;
	}
	
	public Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso() {
		Map<Integer,Set<Attrezzo>> mappa = new HashMap<>();
		for(Attrezzo a : this.attrezzi) {
			int pesoCorrente = a.getPeso();
			Set<Attrezzo> nuovoSet = new HashSet<>();
			for(Attrezzo aux : this.attrezzi) {
				if(aux.getPeso()==pesoCorrente)
					nuovoSet.add(aux);
			}
			mappa.put(pesoCorrente, nuovoSet);
		}
		
		return mappa;
	}
	
	public SortedSet<Attrezzo> getSortedOrdinatoPerPeso() {
		ComparatorePerPeso comparatore = new ComparatorePerPeso();
		SortedSet<Attrezzo> tree = new TreeSet<>(comparatore);
		tree.addAll(this.attrezzi);
		
		return tree;
	}
}

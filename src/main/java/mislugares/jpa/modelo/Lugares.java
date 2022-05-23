package mislugares.jpa.modelo;

import java.util.List;




public class Lugares {
	
	private List<Lugar> lugareslista;

	
	public Lugares() {
		
		
	}


	public Lugares(List<Lugar> lugares) {
		super();
		this.lugareslista = lugares;
	}


	public List<Lugar> getLugares() {
		return lugareslista;
	}


	public void setLugares(List<Lugar> lugares) {
		this.lugareslista = lugares;
	}
	

	
	
	

}

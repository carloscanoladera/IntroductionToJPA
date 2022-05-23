package mislugares.jpa.servicios;

import java.util.List;

import mislugares.jpa.modelo.Lugar;

public interface MisLugaresServicio {
	
	   Lugar createLugar(Lugar lugar);
	    
	    
	    
	     Lugar updateLugar(Lugar lugar);
	    
	    
	     Lugar findLugarById(int id);
	     
	 	 Lugar findLugarByName(String name);
	    
	     List<Lugar> getLugares();
	
	     int borrarLugar(int id) ;

}

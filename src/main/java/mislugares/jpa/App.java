package mislugares.jpa;

import java.util.List;

import mislugares.jpa.modelo.Lugar;
import mislugares.jpa.modelo.TipoLugar;
import mislugares.jpa.servicios.MisLugaresServicio;
import mislugares.jpa.servicios.MisLugaresServicioImpl;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		MisLugaresServicio lugares = new MisLugaresServicioImpl();

		Lugar lugar = lugares.findLugarById(1);

		lugar.setTipo(TipoLugar.EDUCACION);

		Lugar lugar2 = lugares.findLugarByName("Gandía");
		
		Lugar lugar3= new Lugar();
		
		lugar3.setTipo(TipoLugar.BAR);
		
		lugar3 =lugares.createLugar(lugar3);
		
		lugares.borrarLugar(lugar3.getId());

		List<Lugar> lugaresLista = lugares.getLugares();
		lugaresLista.forEach(System.out::println);

	}
}

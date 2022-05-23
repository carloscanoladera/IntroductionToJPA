package mislugares.jpa.modelo;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


/**
 * This Class implements place, locations.
 *
 * @version 1.1
 * @author Carlos@Cano
 * @since 1.0
 */

@Entity
@Table(name="lugares")
public class Lugar implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 686759294820843522L;

	
    @Id
    @Column(name="_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
	

    private String nombre;

    private String direccion;
	
	
    private GeoPunto posicion;
    
    @Enumerated(EnumType.ORDINAL)
    private TipoLugar tipo;

    private String foto="";

    private int telefono;

    
    private String url;
 
    private String comentario;
    private long fecha;
    private float valoracion;

  
    
    public Lugar(String nombre, String direccion, double longitud, double latitud, TipoLugar tipo, int telefono,
            String url, String comentario, int valoracion) {
   fecha = System.currentTimeMillis();
   posicion = new GeoPunto(longitud, latitud);
   this.tipo = tipo;
   this.foto="foto_epsg.png";
   this.nombre = nombre;
   this.direccion = direccion;
   this.telefono = telefono;
   this.url = url;
   this.comentario = comentario;
   this.valoracion = valoracion;
}

public Lugar() {
fecha = System.currentTimeMillis();
posicion= new GeoPunto(0,0);
tipo = TipoLugar.OTROS;
}
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * This method returns an object TipoLugar
     *
     *
     * @return TipoLugar the kind o Lugar
     */

    public TipoLugar getTipo() {
        return tipo;
    }

    /**
     * This method changes/sets the kind of place
     *
     * @author Carlos Cano
     *
     * @param tipo kind of place
     *
     * @return void
     */

    public void setTipo(TipoLugar tipo) {
        this.tipo = tipo;
    }

    /**
     * This method returns the place name
     *
     *
     * @return String the object Lugar name
     */
    public String getNombre() {
        return nombre;
    }


    /**
     * This method changes/sets the name of the place
     *
     *
     * @param nombre Name of the place
     *
     * @return void
     */

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * This method returns an Address
     *
     *
     * @return String the object Lugar address
     */
  
    public GeoPunto getPosicion() {
        return posicion;
    }

    public void setPosicion(GeoPunto posicion) {
        this.posicion = posicion;
    }
    public String getDireccion() {
        return direccion;
    }

    /**
     * This method changes/sets the address of the place
     *
     *
     * @param direccion Place Address
     *                      *
     * @return void
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * This method returns a phone number
     *
     *
     * @return int telephone number
     */

    public int getTelefono() {
        return telefono;
    }

    /**
     * This method changes/sets the address of the place
     * @author Carlos Cano
     *
     *
     * @param  telefono telephone number
     *                      *
     * @return void
    */

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    /**
     * This method returns the photo url from this place
     * @author Carlos Cano
     *
     *
     * @return String the photo url
     */
 
    public String getFoto() {
        return foto;
    }

    /**
     * This method changes/sets the photo from the place
     * @author Carlos Cano
     *
     *
     * @param  foto Address
     *                      *
     * @return void
     */

    public void setFoto(String foto) {
        this.foto = foto;
    }

    /**
     * This method return the Lugar (place) website address
     *
     *
     * @return String the website address of this Lugar
     */

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * This method return Lugar comments
     *
     *
     * @return String comments from this Lugar
     */

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    /**
     * This method return lsat visit date to this Lugar
     *
     *
     * @return long last visit date to the place
     */

    public long getFecha() {
        return fecha;
    }

    public void setFecha(long fecha) {
        this.fecha = fecha;
    }

    /**
     * This method return the rate for this Lugar
     *
     *
     * @return float the rate for the place
     */

    public float getValoracion() {
        return valoracion;
    }

    public void setValoracion(float valoracion) {
        this.valoracion = valoracion;
    }



    @Override
    public String toString() {
        return "Lugar {nombre" + nombre + ",direccion=" + direccion
                + ", posicion=" + posicion + ", foto=" + foto + ", telefono="
                + telefono + ", url=" + url + ",comentario=" + comentario
                + ", fecha=" + fecha + ",valoracion=" + valoracion + "}";

    }

	@Override
	public int hashCode() {
		return Objects.hash(comentario, direccion, fecha, foto, id, nombre, posicion, telefono, tipo, url, valoracion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lugar other = (Lugar) obj;
		return Objects.equals(comentario, other.comentario) && Objects.equals(direccion, other.direccion)
				&& fecha == other.fecha && Objects.equals(foto, other.foto) && id == other.id
				&& Objects.equals(nombre, other.nombre) && Objects.equals(posicion, other.posicion)
				&& telefono == other.telefono && tipo == other.tipo && Objects.equals(url, other.url)
				&& Float.floatToIntBits(valoracion) == Float.floatToIntBits(other.valoracion);
	}



}





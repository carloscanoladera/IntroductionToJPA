package mislugares.jpa.modelo;

import java.io.Serializable;
import java.util.Objects;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;




/**
 * This Class implements a Geographic Point on Earth
 *
 * @version 1.1
 * @author Carlos@Cano
 */

@Embeddable
@Table(name="lugares")

 public class GeoPunto implements Serializable  {


	@Column(name="longitud")
    private double longitud;

	@Column(name="latitud")
    private double latitud;

    public GeoPunto() {
    	
    	
    }

    public GeoPunto(double longitud, double latitud) {

        this.latitud = latitud;
        this.longitud = longitud;

    }


    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }


    /**
     * This method take a picture from the public storage, which can be Gallery or another app,
     *
     * @author Carlos Cano
     *
     *
     * @return String return latitude and longitude as a String
     *
     */

    public String toString() {

        return new String("longitud:" + longitud + ", latitud:" + latitud);
    }

    /**
     * This method take a picture from the public storage, which can be Gallery or another app,
     * @author Carlos Cano
     *
     *
     * @param punto . Coordenate on Earth
     *
     * @return double representing the distancias between the current point and the point passed as
     * a parameter
     */

    public double distancia(GeoPunto punto) {

        final double RADIO_TIERRA = 6371000; // en metros
        double dLat = Math.toRadians(latitud - punto.latitud);
        double dLon = Math.toRadians(longitud - punto.longitud);
        double lat1 = Math.toRadians(latitud);
        double lat2 = Math.toRadians(latitud);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.sin(dLon / 2) * Math.sin(dLon / 2) *
                        Math.cos(lat1) * Math.cos(lat2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return c * RADIO_TIERRA;
    }
}

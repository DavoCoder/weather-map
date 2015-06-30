/**
 * 
 */
package ar.com.itba.weathermap.builder;

import org.geonames.InsufficientStyleException;
import org.geonames.Toponym;

import ar.com.itba.weathermap.entity.Place;

/**
 * Builder for Place object.
 * 
 * @author David Cisneros
 *
 */
public class ToponymPlaceBuilder {

	/**
	 * @param toponym
	 * @param country
	 * @return
	 * @throws InsufficientStyleException
	 */
	public static Place buildPlace(Toponym toponym, String country) throws InsufficientStyleException {
		Place place = new Place();
		place.setGeonameId(String.valueOf(toponym.getGeoNameId()));
		place.setLatitude(toponym.getLatitude());
		place.setLongitude(toponym.getLongitude());
		place.setName(toponym.getName());
		place.setPopulation(toponym.getPopulation());
		place.setCountry(country);
		return place;
	}
}

/**
 * 
 */
package ar.com.itba.weathermap.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import ar.com.itba.weathermap.entity.Place;

/**
 * Interface for Place Dao
 * 
 * @author David Cisneros
 *
 */
@Repository
public interface PlaceDao extends GenericDao<Place, Long>{

	List<Place> getPlacesByCountry(String... country);
	
	List<String> getCountryNames();
	
	void deleteData(String... country);
	
	
}

/**
 * 
 */
package ar.com.itba.weathermap.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.geonames.Toponym;

import ar.com.itba.weathermap.builder.ToponymPlaceBuilder;
import ar.com.itba.weathermap.dao.PlaceDao;
import ar.com.itba.weathermap.dto.Response;
import ar.com.itba.weathermap.entity.Place;
import ar.com.itba.weathermap.geonames.GeonamesService;
import ar.com.itba.weathermap.service.PlaceService;

/**
 * Implementation for Place Service.
 * 
 * @author David Cisneros
 *
 */
public class PlaceServiceImpl implements PlaceService{

	private PlaceDao placeDao;


	/**
	 * @see ar.com.itba.weathermap.service.PlaceService#getCountryNames()
	 */
	@Override
	public List<String> getCountryNames() {
		return placeDao.getCountryNames();
	}

	
	/**
	 * @see ar.com.itba.weathermap.service.PlaceService#updateDataBase(java.lang.String, java.lang.String)
	 */
	@Override
	@Transactional
	public Response updateDataBase(String username, String country){
		Response resp = new Response();
		try {
			validateParam("Geonames Username",username);
			validateParam("Country",country);
			validateCountry(country);
			
			List<Toponym> toponyms = GeonamesService.getToponyms(username, country);

			placeDao.deleteData(country);

			for (Toponym toponym : toponyms) {
				placeDao.save(ToponymPlaceBuilder.buildPlace(toponym,country));
			}

			resp.setResponseCode("0");
			resp.setResponseDescription("Database Updated ok!");

		} catch (Exception e) {
			resp.setResponseCode("1");
			resp.setResponseDescription("Database Not updated, error:" + e.getMessage());
		}
		return resp;
	}

	private void validateParam(String key, String value) throws Exception{
		if(value==null || value.isEmpty() || value.trim().equals("")){
			throw new Exception(key + " must set");
		}
	}
	
	private void validateCountry(String country) throws Exception{
		List<Place> places =placeDao.getPlacesByCountry(country);
		if(places.size()>0){
			throw new Exception("Country already exists");
		}
	}


	/**
	 * @param placeDao the placeDao to set
	 */
	public void setPlaceDao(PlaceDao placeDao) {
		this.placeDao = placeDao;
	}


}

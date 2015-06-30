/**
 * 
 */
package ar.com.itba.weathermap.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import ar.com.itba.weathermap.builder.PlaceForecastBuilder;
import ar.com.itba.weathermap.dao.PlaceDao;
import ar.com.itba.weathermap.dto.Forecast;
import ar.com.itba.weathermap.entity.Place;
import ar.com.itba.weathermap.service.ForecastService;

/**
 * Implementation of Forecast Service.
 * 
 * @author David Cisneros
 *
 */
public class ForecastServiceImpl implements ForecastService{

	private static final Logger LOGGER = Logger.getLogger(ForecastServiceImpl.class);
	
	private PlaceDao placeDao;
	
	/**
	 * @see ar.com.itba.weathermap.service.ForecastService#getForecasts(java.lang.String, java.lang.String)
	 */
	public List<Forecast> getForecasts(String[] countries) throws Exception{
		List<Forecast> forecastList = new ArrayList<Forecast>();
			
		List<Place> places = placeDao.getPlacesByCountry(countries);
		
		LOGGER.info("Places size:" + places.size());
		for (Place place : places) {
			forecastList.add(PlaceForecastBuilder.buildForecast(place));
		}

		return forecastList;
	}

	/**
	 * @param placeDao the placeDao to set
	 */
	public void setPlaceDao(PlaceDao placeDao) {
		this.placeDao = placeDao;
	}



}

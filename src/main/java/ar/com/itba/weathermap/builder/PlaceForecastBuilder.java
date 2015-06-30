/**
 * 
 */
package ar.com.itba.weathermap.builder;

import ar.com.itba.weathermap.dto.Forecast;
import ar.com.itba.weathermap.dto.ForecastTypeEnum;
import ar.com.itba.weathermap.entity.Place;

/**
 * Builder for Forecast object.
 * 
 * @author David Cisneros
 *
 */
public class PlaceForecastBuilder {

	/**
	 * @param place
	 * @return
	 */
	public static Forecast buildForecast(Place place) {
		Forecast forecast = new Forecast();
		forecast.setForecastKey(place.getGeonameId());
		forecast.setForecastLatitude(place.getLatitude());
		forecast.setForecastLongitude(place.getLongitude());
		forecast.setForecastRegion(place.getName());
		forecast.setPopulation(place.getPopulation());
		if(null!=forecast.getPopulation()&&forecast.getPopulation()>1000000){
			forecast.setForecastType(ForecastTypeEnum.AIRPORT.getName());
		}else{
			forecast.setForecastType(ForecastTypeEnum.VILLAGE.getName());
		}

		return forecast;
	} 
}

/**
 * 
 */
package ar.com.itba.weathermap.service;

import java.util.List;

import ar.com.itba.weathermap.dto.Forecast;

/**
 * Forecast Service Interface.
 * 
 * @author David Cisneros
 *
 */
public interface ForecastService {


	/**
	 * @param country
	 * @return
	 * @throws Exception
	 */
	List<Forecast> getForecasts(String[] countries) throws Exception;

}

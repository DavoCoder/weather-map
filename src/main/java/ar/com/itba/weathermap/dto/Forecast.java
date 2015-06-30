/**
 * 
 */
package ar.com.itba.weathermap.dto;

import java.io.Serializable;


/**
 * Data Transfer Object for Forecast.
 * 
 * @author David Cisneros
 *
 */
public class Forecast implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5912622758400388039L;

	private Long forecastId;

	private String forecastKey;
	
	private String forecastType;
	
	private Double forecastLatitude;
	
	private Double forecastLongitude;
	
	private Long population;
	
	private String forecastRegion;

	/**
	 * @return the forecastId
	 */
	public Long getForecastId() {
		return forecastId;
	}

	/**
	 * @param forecastId the forecastId to set
	 */
	public void setForecastId(Long forecastId) {
		this.forecastId = forecastId;
	}

	/**
	 * @return the forecastKey
	 */
	public String getForecastKey() {
		return forecastKey;
	}

	/**
	 * @param forecastKey the forecastKey to set
	 */
	public void setForecastKey(String forecastKey) {
		this.forecastKey = forecastKey;
	}

	/**
	 * @return the forecastType
	 */
	public String getForecastType() {
		return forecastType;
	}

	/**
	 * @param forecastType the forecastType to set
	 */
	public void setForecastType(String forecastType) {
		this.forecastType = forecastType;
	}

	

	/**
	 * @return the forecastLatitude
	 */
	public Double getForecastLatitude() {
		return forecastLatitude;
	}

	/**
	 * @param forecastLatitude the forecastLatitude to set
	 */
	public void setForecastLatitude(Double forecastLatitude) {
		this.forecastLatitude = forecastLatitude;
	}

	/**
	 * @return the forecastLongitude
	 */
	public Double getForecastLongitude() {
		return forecastLongitude;
	}

	/**
	 * @param forecastLongitude the forecastLongitude to set
	 */
	public void setForecastLongitude(Double forecastLongitude) {
		this.forecastLongitude = forecastLongitude;
	}

	/**
	 * @return the forecastRegion
	 */
	public String getForecastRegion() {
		return forecastRegion;
	}

	/**
	 * @param forecastRegion the forecastRegion to set
	 */
	public void setForecastRegion(String forecastRegion) {
		this.forecastRegion = forecastRegion;
	}

	/**
	 * @return the population
	 */
	public Long getPopulation() {
		return population;
	}

	/**
	 * @param population the population to set
	 */
	public void setPopulation(Long population) {
		this.population = population;
	}


}

/**
 * 
 */
package ar.com.itba.weathermap.web.map.marker;

import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.Marker;

import ar.com.itba.weathermap.dto.Forecast;

/**
 * Marker specialized class for Forecast.
 *  
 * @author David Cisneros
 *
 */
public class ForecastMarker extends Marker{
	
	private Forecast forecast;

	/**
	 * 
	 */
	private static final long serialVersionUID = -5669744499612533152L;
	
	/**
	 * @param latlng
	 * @param title
	 * @param data
	 * @param icon
	 * @param shadow
	 */
	public ForecastMarker(LatLng latlng, String title, Object data, String icon, String shadow) {
		super(latlng, title, data, icon, shadow);
	}
	
	public ForecastMarker(LatLng latlng, String title, Object data, String icon, String shadow, Forecast forecast) {
		super(latlng, title, data, icon, shadow);
		this.forecast = forecast;
	}

	/**
	 * @return the forecast
	 */
	public Forecast getForecast() {
		return forecast;
	}

	/**
	 * @param forecast the forecast to set
	 */
	public void setForecast(Forecast forecast) {
		this.forecast = forecast;
	}
}

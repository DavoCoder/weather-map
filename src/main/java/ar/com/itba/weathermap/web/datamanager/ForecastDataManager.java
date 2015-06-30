/**
 * 
 */
package ar.com.itba.weathermap.web.datamanager;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.map.MapModel;

import ar.com.itba.weathermap.web.map.marker.ForecastMarker;

/**
 * Bean for Forecast data.
 * 
 * @author David Cisneros
 *
 */
@ManagedBean
@ViewScoped
public class ForecastDataManager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8512508466713671974L;

	private MapModel forecastMapModel;

	private ForecastMarker forecastMarker;

	private List<String> countries;



	/**
	 * Default constructor.
	 */
	public ForecastDataManager() {
		super();
	}



	/**
	 * @return the forecastMapModel
	 */
	public MapModel getForecastMapModel() {
		return forecastMapModel;
	}



	/**
	 * @param forecastMapModel the forecastMapModel to set
	 */
	public void setForecastMapModel(MapModel forecastMapModel) {
		this.forecastMapModel = forecastMapModel;
	}



	/**
	 * @return the forecastMarker
	 */
	public ForecastMarker getForecastMarker() {
		return forecastMarker;
	}



	/**
	 * @param forecastMarker the forecastMarker to set
	 */
	public void setForecastMarker(ForecastMarker forecastMarker) {
		this.forecastMarker = forecastMarker;
	}



	/**
	 * @return the countries
	 */
	public List<String> getCountries() {
		return countries;
	}



	/**
	 * @param countries the countries to set
	 */
	public void setCountries(List<String> countries) {
		this.countries = countries;
	}


}

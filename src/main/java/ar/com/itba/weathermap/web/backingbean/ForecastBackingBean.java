/**
 * 
 */
package ar.com.itba.weathermap.web.backingbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.model.SelectItem;

import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.DefaultMapModel;

import ar.com.itba.weathermap.service.ForecastService;
import ar.com.itba.weathermap.service.PlaceService;
import ar.com.itba.weathermap.web.datamanager.ForecastDataManager;
import ar.com.itba.weathermap.web.map.builder.ForecastMapModelBuilder;
import ar.com.itba.weathermap.web.map.marker.ForecastMarker;

/**
 * Bean for Forecast actions and disposable properties.
 * 
 * @author David Cisneros
 *
 */
@ManagedBean
@RequestScoped
public class ForecastBackingBean {

	@ManagedProperty(value="#{forecastDataManager}")
	private ForecastDataManager forecastDataManager;

	@ManagedProperty(value="#{forecastService}")
	private ForecastService forecastService;

	@ManagedProperty(value="#{placeService}")
	private PlaceService placeService;

	private List<String> selectedCountries;

	/**
	 * Loads forecasts.
	 */
	public void loadForecasts(ComponentSystemEvent event){
		forecastDataManager.setCountries(placeService.getCountryNames());
		if(null==forecastDataManager.getForecastMapModel()){
			forecastDataManager.setForecastMapModel(new DefaultMapModel());
		}
	}

	/**
	 * Loads map
	 */
	public void loadMap(){
		try {
			if(null!=selectedCountries && !selectedCountries.isEmpty()){
				String[] countries = selectedCountries.toArray(new String[selectedCountries.size()]);
				forecastDataManager.setForecastMapModel(ForecastMapModelBuilder.getForecastMapModel(forecastService.getForecasts(countries)));
			}
		} catch (Exception e) {
			System.out.println("Error:" + e.getMessage());
		}
	}

	/**
	 * @return countries
	 */
	public List<SelectItem> getCountries(){
		List<SelectItem> items = new ArrayList<SelectItem>();
		for (String c : forecastDataManager.getCountries()) {
			items.add(new SelectItem(c, c));	
		}
		return items;
	}

	/**
	 * @param event
	 */
	public void onMarkerSelect(OverlaySelectEvent event) {
		forecastDataManager.setForecastMarker((ForecastMarker) event.getOverlay());
	}
	/**
	 * @param forecastDataManager the forecastDataManager to set
	 */
	public void setForecastDataManager(ForecastDataManager forecastDataManager) {
		this.forecastDataManager = forecastDataManager;
	}

	/**
	 * @param forecastService the forecastService to set
	 */
	public void setForecastService(ForecastService forecastService) {
		this.forecastService = forecastService;
	}

	/**
	 * @param placeService the placeService to set
	 */
	public void setPlaceService(PlaceService placeService) {
		this.placeService = placeService;
	}

	/**
	 * @return the selectedCountries
	 */
	public List<String> getSelectedCountries() {
		return selectedCountries;
	}

	/**
	 * @param selectedCountries the selectedCountries to set
	 */
	public void setSelectedCountries(List<String> selectedCountries) {
		this.selectedCountries = selectedCountries;
	}


}

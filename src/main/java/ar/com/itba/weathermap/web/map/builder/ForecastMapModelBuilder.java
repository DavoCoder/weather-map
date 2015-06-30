/**
 * 
 */
package ar.com.itba.weathermap.web.map.builder;

import java.util.List;

import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;

import ar.com.itba.weathermap.dto.Forecast;
import ar.com.itba.weathermap.web.map.marker.ForecastMarker;
import ar.com.itba.weathermap.web.map.marker.MarkerIconEnum;
import ar.com.itba.weathermap.web.support.FacesContextUtils;

/**
 * Builder class for Forecast Map Model.
 * 
 * @author David Cisneros
 *
 */
public final class ForecastMapModelBuilder {

	private static final Integer INF_POPUL = 100000;
	private static final Integer MID_POPUL = 500000;
	private static final Integer SUP_POPUL = 1000000;
	
	/**
	 * Default constructor.
	 */
	private ForecastMapModelBuilder() {
		super();
	}


	/**
	 * @param forecasts
	 * @return
	 */
	public static MapModel getForecastMapModel(List<Forecast> forecasts){
		MapModel mapModel = new DefaultMapModel();  
		
		for (Forecast forecast : forecasts) {
			loadForecastMapModel(forecast, mapModel);
		}
		
		return mapModel;
	}
	
	
	/**
	 * @param forecast
	 * @return
	 */
	public static MapModel getForecastMapModel(Forecast forecast){
		MapModel mapModel = new DefaultMapModel();  
		
		loadForecastMapModel(forecast,mapModel);
		
		return mapModel;
	}

	/**
	 * @param forecast
	 * @param mapModel
	 */
	private static void loadForecastMapModel(Forecast forecast, MapModel mapModel) {
		if(null!=forecast.getForecastLatitude() && null!=forecast.getForecastLongitude()){
			LatLng latLng = new LatLng(Double.valueOf(forecast.getForecastLatitude()), Double.valueOf(forecast.getForecastLongitude()));
			ForecastMarker forecastMarker = new ForecastMarker(latLng, forecast.getForecastRegion(),"", 
					getMarkerIcon(forecast.getPopulation()),null,forecast);
			mapModel.addOverlay(forecastMarker);
		}
	}
	
	private static String getMarkerIcon(Long population){
		String markerIcon = getMarkerIconPath(MarkerIconEnum.GRAY_MARKER.getIconPath());
		if(null!=population){
			if(population < INF_POPUL){
				markerIcon = getMarkerIconPath(MarkerIconEnum.RED_MARKER.getIconPath());
			}else if (population >= INF_POPUL && population < MID_POPUL){
				markerIcon = getMarkerIconPath(MarkerIconEnum.GREEN_MARKER.getIconPath());
			}else if (population >= MID_POPUL && population < SUP_POPUL){
				markerIcon = getMarkerIconPath(MarkerIconEnum.BLUE_MARKER.getIconPath());
			}else{
				markerIcon = getMarkerIconPath(MarkerIconEnum.PURPLE_MARKER.getIconPath());
			}
		}
		return markerIcon;
	}
	
	private static String getMarkerIconPath(String path){
		return FacesContextUtils.getContextPath().concat(path);
	}

}

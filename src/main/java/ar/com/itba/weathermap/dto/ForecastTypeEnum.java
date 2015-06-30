/**
 * 
 */
package ar.com.itba.weathermap.dto;

/**
 * Forecast Type Enumerator.
 * 
 * @author David Cisneros
 *
 */
public enum ForecastTypeEnum {

	SEASIDE("seaside"),VILLAGE("village"),AIRPORT("airport"),ORIENTAL("oriental"),TOWN("town");
	
	private final String name;

	private ForecastTypeEnum(String name) {
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


}

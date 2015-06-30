/**
 * 
 */
package ar.com.itba.weathermap.geonames;

import java.util.HashSet;
import java.util.Set;

import org.geonames.FeatureClass;
import org.geonames.Style;
import org.geonames.ToponymSearchCriteria;

/**
 * Builder for search criteria object.
 * 
 * @author David Cisneros
 *
 */
public class GeonamesSearchCriteriaBuilder {


	/**
	 * @param countries
	 * @return criteria
	 */
	public static ToponymSearchCriteria getSearchCriteria(Set<String> countries) {
		ToponymSearchCriteria searchCriteria = new ToponymSearchCriteria();

		searchCriteria.setCountryCodes(countries);
		searchCriteria.setStyle(Style.LONG);
		searchCriteria.setFeatureClass(FeatureClass.P);
		searchCriteria.setMaxRows(1000);
		
		searchCriteria.setFeatureCodes(GeonamesParamsBuilder.getFeatureCodes());
		
		//searchCriteria.setQ(searchString);
		return searchCriteria;
	}

	/**
	 * @param countryCode
	 * @return criteria
	 */
	public static ToponymSearchCriteria getSearchCriteria(String countryCode) {
		Set<String> countries = new HashSet<String>();
		countries.add(countryCode);
		return getSearchCriteria(countries);
	}
}

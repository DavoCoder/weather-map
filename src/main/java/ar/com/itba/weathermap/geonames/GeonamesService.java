/**
 * 
 */
package ar.com.itba.weathermap.geonames;

import java.util.List;

import org.apache.log4j.Logger;
import org.geonames.Toponym;
import org.geonames.ToponymSearchResult;
import org.geonames.WebService;

/**
 * @author David Cisneros
 *
 */
public class GeonamesService {
	
	private static final Logger LOGGER = Logger.getLogger(GeonamesService.class);
	
	public static List<Toponym> getToponyms(String username, String countryCode) throws Exception{

		WebService.setUserName(username); 
		
		ToponymSearchResult searchResult = WebService.search(GeonamesSearchCriteriaBuilder.getSearchCriteria(countryCode));
		
		LOGGER.info("Geonames total results:" + searchResult.getTotalResultsCount());
		LOGGER.info("Geonames toponyms results:" + searchResult.getToponyms().size());

		return searchResult.getToponyms();
	}
}

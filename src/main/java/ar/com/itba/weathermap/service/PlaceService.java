/**
 * 
 */
package ar.com.itba.weathermap.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import ar.com.itba.weathermap.dto.Response;

/**
 * Place Service Interface.
 * 
 * @author David Cisneros
 *
 */
@Path("/place")
public interface PlaceService {

	/**
	 * ETL Process to extract data from geonames, transform and load to te local database.
	 * 
	 * @param username
	 * @param country
	 * @return response
	 */
	@GET
	@Produces ("application/xml")
	@Path("/{username}/{country}")
	Response updateDataBase(@PathParam ("username")String username, @PathParam ("country")String country);
	
	/**
	 * @return country names.
	 */
	List<String> getCountryNames();
}

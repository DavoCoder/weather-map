/**
 * 
 */
package ar.com.itba.weathermap.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * Object that represents Place table.
 * 
 * @author David Cisneros
 *
 */
@Entity
@Table(name = "wm_place")
@SequenceGenerator(name = "seq_wm_place", sequenceName = "wm_place_seq",allocationSize=1)
public class Place implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5912622758400388039L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_wm_place")
	@Column(name = "place_id", unique = true, nullable = false)
	private Long placeId;
	
	@Column(name = "countryid", nullable = false)
	private String country;

	@Column(name = "geoname_id", nullable = false, unique=true)
	private String geonameId;

	@Column(name = "latitude", nullable = false)
	private Double latitude;
	
	@Column(name = "longitude", nullable = false)
	private Double longitude;
	
	@Column(name = "population", nullable = true)
	private Long population;
	
	@Column(name = "name", nullable = false)
	private String name;

	/**
	 * @return the placeId
	 */
	public Long getPlaceId() {
		return placeId;
	}

	/**
	 * @param placeId the placeId to set
	 */
	public void setPlaceId(Long placeId) {
		this.placeId = placeId;
	}

	/**
	 * @return the geonameId
	 */
	public String getGeonameId() {
		return geonameId;
	}

	/**
	 * @param geonameId the geonameId to set
	 */
	public void setGeonameId(String geonameId) {
		this.geonameId = geonameId;
	}

	/**
	 * @return the latitude
	 */
	public Double getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return the longitude
	 */
	public Double getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
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

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

}

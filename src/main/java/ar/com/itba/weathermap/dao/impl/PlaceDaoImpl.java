/**
 * 
 */
package ar.com.itba.weathermap.dao.impl;

import java.util.Arrays;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import ar.com.itba.weathermap.dao.PlaceDao;
import ar.com.itba.weathermap.entity.Place;

/**
 * Implementation of Data Access Object for Place.
 * 
 * @author David Cisneros
 *
 */
public class PlaceDaoImpl extends GenericDaoImpl<Place, Long> implements PlaceDao{

	/**
	 * @see ar.com.itba.weathermap.dao.PlaceDao#getPlacesByCountry(java.lang.String[])
	 */
	@Override
	public List<Place> getPlacesByCountry(String... countries) {
		StringBuffer sb = new StringBuffer();

		sb.append("SELECT p FROM Place p WHERE ");
		sb.append("p.country IN (:countries) ");

		TypedQuery<Place> q= em.createQuery(sb.toString(),Place.class);
		q.setParameter("countries",Arrays.asList(countries));
	
		return q.getResultList();
	}

	/**
	 * @see ar.com.itba.weathermap.dao.PlaceDao#deleteData(java.lang.String[])
	 */
	@Override
	public void deleteData(String... countries) {
		StringBuffer sb = new StringBuffer();

		sb.append("DELETE FROM Place p WHERE ");
		sb.append("p.country IN (:countries) ");

		Query q= em.createQuery(sb.toString());
		q.setParameter("countries",Arrays.asList(countries));
		q.executeUpdate();
	}

	/**
	 * @see ar.com.itba.weathermap.dao.PlaceDao#getCountryNames()
	 */
	@Override
	public List<String> getCountryNames() {
		StringBuffer sb = new StringBuffer();

		sb.append("SELECT DISTINCT(p.country) FROM Place p ORDER BY p.country ASC ");
		TypedQuery<String> q= em.createQuery(sb.toString(),String.class);
		
		return q.getResultList();
	}



}

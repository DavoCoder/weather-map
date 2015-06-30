package ar.com.itba.weathermap.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Interface for Generic Dao
 * 
 * @author David Cisneros
 * @version $Revision: 1.0 $
 */
public interface GenericDao<T, PK extends Serializable> {

	/**
	 * Generic Update
	 * 
	 * @param o
	 */
	void update(T o) ;

	/**
	 * Generic update-flush.
	 * 
	 * @param o
	 */
	void updateFlush(T o) ;

	/**
	 * Generic save.
	 * 
	 * @param o
	 */
	void save(T o);

	/**
	 * Generic save-flush.
	 * 
	 * @param o
	 */
	void saveFlush(T o);

	/**
	 * Generic Lock.
	 * 
	 * @param id
	 * @param lockModeType  see: javax.persistence.LockModeType  p
	 */
	void lock(PK id, String lockModeType);


	/**
	 * Generic Find by Id
	 * 
	 * @param id
	 * @return object
	 */
	T findById(PK id);


	/**
	 * Generic Find all
	 * 
	 * @param initRow
	 * @param rows
	 * @return
	 */
	List<T> findAll(Integer initRow, Integer rows);

	/**
	 * Generic Find all
	 * 
	 * @return list
	 */
	List<T> findAll();


	/**
	 * Generic Delete
	 * 
	 * @param id
	 */
	void delete(PK id);

}

package ar.com.itba.weathermap.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ar.com.itba.weathermap.dao.GenericDao;

/**
 * 
 * Generic class for create, update, delete and find entities
 * 
 * @author David Cisneros
 * @version $Revision: 1.0 $
 */

public abstract class GenericDaoImpl<T, PK extends Serializable> implements GenericDao<T, PK> {

	@PersistenceContext
	protected EntityManager em;

	private Class<T> type;

	/**
	 * Constructor default.
	 */
	public GenericDaoImpl() {
		super();
	}

	/**
	 * @see com.mountainsecuador.dao.GenericDao#update(java.lang.Object)
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public void update(T o) {
		em.merge(o);
	}

	/**
	 * @see com.mountainsecuador.dao.GenericDao#save(java.lang.Object)
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public void save(T o) {
		em.persist(o);
	}

	/**
	 * @see com.mountainsecuador.dao.GenericDao#saveFlush(java.lang.Object)
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public void saveFlush(T o){
		em.persist(o);
		em.flush();
	}

	/**
	 * @see com.mountainsecuador.dao.GenericDao#updateFlush(java.lang.Object)
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public void updateFlush(T o) {
		em.merge(o);
		em.flush();
	}

	/**
	 * @see com.mountainsecuador.dao.GenericDao#lock(java.io.Serializable, javax.persistence.LockModeType)
	 */
	public void lock(PK id, String lockModeType) {
		T o = (T) em.find(type, id);
		
		em.lock(o, LockModeType.valueOf(lockModeType));
	}

	/**
	 * @see com.mountainsecuador.dao.GenericDao#findById(java.io.Serializable)
	 */
	public T findById(PK id) {
		T entity = (T) em.find(type, id);
		return entity;
	}

	/**
	 * @see com.mountainsecuador.dao.GenericDao#findAll(java.lang.Integer, java.lang.Integer)
	 */
	@SuppressWarnings("unchecked")
	public List<T> findAll(Integer initRow, Integer rows) {
		Query q = em.createQuery("from ".concat(type.getSimpleName()));
		if(initRow!=null){
			q.setFirstResult(initRow);
		}
		if(rows!=null){
			q.setMaxResults(rows);
		}

		return q.getResultList();
	}
	
	/**
	 * @see com.mountainsecuador.dao.GenericDao#findAll()
	 */
	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		Query q = em.createQuery("from ".concat(type.getSimpleName()));
		return q.getResultList();
	}

	/**
	 * @see com.mountainsecuador.dao.GenericDao#delete(java.io.Serializable)
	 */
	@Transactional
	public void delete(PK id) {
		T objectToRemove = findById(id);
		em.remove(objectToRemove);
	}

	/**
	 * @param type
	 */
	public void setType(Class<T> type) {
		this.type = type;
	}
	
}
package com.interview.contactmgt.dao.impl;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.interview.contactmgt.dao.BaseDao;
import com.interview.contactmgt.dto.ResponseStatus;
import com.interview.contactmgt.exception.DaoException;
import com.interview.contactmgt.util.ContactRespoCode;

/*@author AmitYadav
 * @date-27 may 2021
 * @created by  AmitYadav
 * @Class BaseDaoImpl
 */
public class BaseDaoImpl implements BaseDao {

	@Autowired
	private SessionFactory sessionFactory;

	
	private static final Logger LOGGER = Logger.getLogger(BaseDaoImpl.class);

	
	/*@author AmitYadav
	 * @date-27 may 2021
	 * @created by  AmitYadav
	 * @Method save
	 */
	@Transactional
	public boolean save(Object obj) throws DaoException {
		LOGGER.info("Inside BaseDAO Save"+obj);

		boolean isSuccess = false;
		try {
			this.sessionFactory.getCurrentSession().save(obj);
			isSuccess = true;
		} catch (Exception e) {
			LOGGER.error("==>Exception thrown in BaseDaoImpl in save ", e);
			ResponseStatus status = new ResponseStatus();
			status.setResponseCode(ContactRespoCode.C113.getCode()+"");
			status.setResponseMessage(ContactRespoCode.C113.getValue());
		
			throw new DaoException(status);

		}
		return isSuccess;
	}

	/*@author AmitYadav
	 * @date-27 may 2021
	 * @created by  AmitYadav
	 * @Method update
	 */
	@Transactional
	public boolean update(Object obj) throws DaoException {
		LOGGER.info("Inside BaseDAO Update"+obj);
		boolean isSuccess = false;
		try {
			this.sessionFactory.getCurrentSession().update(obj);
			isSuccess = true;
		} catch (Exception e) {
			LOGGER.error("==>Exception thrown in BaseDaoImpl in update", e);
			ResponseStatus status = new ResponseStatus();
			status.setResponseCode(ContactRespoCode.C114.getCode()+"");
			status.setResponseMessage(ContactRespoCode.C114.getValue());
			throw new DaoException(status);
		}
		return isSuccess;
	
}
}
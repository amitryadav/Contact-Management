package com.interview.contactmgt.dao;

import com.interview.contactmgt.exception.DaoException;

/*@author AmitYadav
 * @date-27 may 2021
 * @created by  AmitYadav
 * @Interface BaseDao
 */
public interface BaseDao {
	 boolean save(Object obj) throws DaoException;
	 boolean update(Object obj) throws DaoException;
	 
}

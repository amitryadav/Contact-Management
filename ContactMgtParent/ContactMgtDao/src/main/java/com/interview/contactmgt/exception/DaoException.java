package com.interview.contactmgt.exception;

import com.interview.contactmgt.dto.ResponseStatus;

/*@author AmitYadav
 * @date-26 may 2021
 * @created by  AmitYadav
 * @Class DaoException
 */
public class DaoException extends Exception {
	
	private static final long serialVersionUID = 1L;

	private ResponseStatus status;

	public DaoException(String message) {
		super(message);
	}

	public DaoException(ResponseStatus status) {

		super(status.getResponseMessage());
		this.status = status;
	}

	public ResponseStatus getStatus() {
		return status;
	}

	public void setStatus(ResponseStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DaoException [status=");
		builder.append(status);
		builder.append("]");
		return builder.toString();
	}

}

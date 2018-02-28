package dao;

/**
 *
 * @author dunco114
 */
public class DaoException extends RuntimeException {

	public DaoException(String reason) {
		super(reason);
	}

	public DaoException(String reason, Throwable cause) {
		super(reason, cause);
	}
}

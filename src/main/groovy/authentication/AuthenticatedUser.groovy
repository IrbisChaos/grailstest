package authentication

import util.EnumBase

/**
 * Class encapsulating the result of a login. Encapsulates errors also so that
 * login failures to not use exceptions (very bad for performance and they are not ... exceptional)
 */
class AuthenticatedUser implements Serializable {

	static enum ERROR implements EnumBase{
		NO_SUCH_LOGIN(1),
		INCORRECT_CREDENTIALS(2),
		LOGIN_NAME_NOT_AVAILABLE(3),
		AWAITING_CONFIRMATION(4)
		ERROR(int value) {
			this.value = value
		}
		private final Integer value
		Integer getValue() {
			value
		}
		public String toString() {
			return name()
		}

		@Override
		Integer val() {
			return value
		}

		@Override
		String fromString() {
			return name()
		}
	}

	String login
    
    /**
     * Date/time at which this user logged in
     */
	Date loginTime

	/**
	 * Is the user currently logged in
	 */
	boolean loggedIn
	
	/**
	 * True if email address has been confirmed to work
	 */
	boolean confirmed

	/**
	 * The domain object id of the user principal object for this account
	 */
	def userObjectId
	
	/**
	 * Any application-specific attributes you wish to store for this session can go here
	 */
	def attributes = [:]
	
	/**
	 * The result code for the outcome of the last login attempt
	 */
	int result
}
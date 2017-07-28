package authentication

import java.sql.Timestamp

class AuthenticationUser { 
	String login
	String password
	String email
	int status = AuthenticationService.STATUS.NEW.value
	java.sql.Timestamp dateCreated
	java.sql.Timestamp lastUpdated

	def authenticationService

	static constraints = {
		login(size:5..64, unique: true, validator: { val, obj -> obj.authenticationService.checkLogin(val) } )
		password(size:5..64, password: true, validator: { val, obj -> obj.authenticationService.checkPassword(val) })
		email(email:true, nullable: true, blank: false)
		status(inList: getVals(AuthenticationService.STATUS))
//		autoTimestamp(true)
		dateCreated (column: "ts_cr", type: Timestamp)
		lastUpdated (column: "ts_modi", type: Timestamp)
	}

	public static List<Integer> getVals(Class<? extends Enum<?>> e) {
		def rez = []
		e.getEnumConstants().each {x -> rez << x.value}
		rez
	}

}

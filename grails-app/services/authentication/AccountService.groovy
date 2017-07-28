package authentication

import util.EnumBase

class AccountService {

	def configurationHolder
	def grailsApplicationAttributes

	static enum ROLE implements EnumBase{
		GUEST(0),
		USER(1),
		GRAND_USER(2),
		TESTER(3),
		DEVELOPER(4),
		ADMIN(5)
		ROLE(int value) {
			this.value = value
		}
		private final Integer value

		String toString() {
			return name()
		}

		@Override
		Integer val() {
			value
		}

		@Override
		String fromString() {
			name()
		}
	}

}


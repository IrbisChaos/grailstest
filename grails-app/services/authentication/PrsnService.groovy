package authentication

import util.EnumBase

class PrsnService {

	def configurationHolder
	def grailsApplicationAttributes

	static enum GENDER implements EnumBase {
		MALE(0, "M"),
		FEMALE(1, "F")

		GENDER(Integer num, String str) {
			this.num = num;
			this.str = str;
		}

		private Integer num;
		private String str;

		Integer val() {
			return num;
		}

		String fromString() {
			return str;
		}

	}

}


package by.fomkin.homework_user_registration.validator;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.fomkin.homework_user_registration.bean.RegistrationInfo;

public class ValidationResult {

	private boolean haveErrors;
	private ValidationException exception;

	private static final String namePattern = "[\\w-]+";
	private static final String mailPattern = "[a-zA-Z0-9][\\w-]+@[a-zA-Z]+.[a-zA-Z]+";
	private static final String agePattern = "[0-9]+";
	private static final String passwordPattern = "(?=.*\\d)(?=.*[A-Z])[a-zA-Z0-9]{8,16}";

	private ValidationResult(Validator validator) {
		
		if (validator.getErrors() != null && !validator.getErrors().isEmpty()) {
			haveErrors = true;
			exception = new ValidationException(validator.getErrors());
		
		} else {
			haveErrors = false;
		}

	}

	public boolean isHaveErrors() {
		return haveErrors;
	}

	public ValidationException getException() {
		return exception;
	}

	public static class Validator {

		private Map<ParamName, ErrorKey> errors = new HashMap<>();

		public Map<ParamName, ErrorKey> getErrors() {
			return errors;
		}

		private static final Pattern name = Pattern.compile(namePattern);
		Matcher match;

		public Validator validName(RegistrationInfo newUserInfo) {

			if (newUserInfo.getName() == null) {

				errors.put(ParamName.NAME, ErrorKey.EMPTY);
			} else {

				match = name.matcher(newUserInfo.getName());

				if (!match.matches()) {

					errors.put(ParamName.NAME, ErrorKey.UNCORRECT);
				}
			}
			return this;
		}

		private static final Pattern mail = Pattern.compile(mailPattern);

		public Validator validMail(RegistrationInfo newUserInfo) {

			if (newUserInfo.getMail() == null) {

				errors.put(ParamName.MAIL, ErrorKey.EMPTY);

			} else {

				match = mail.matcher(newUserInfo.getMail());

				if (!match.matches()) {

					errors.put(ParamName.MAIL, ErrorKey.UNCORRECT);
				}
			}
			return this;
		}

		private static final Pattern age = Pattern.compile(agePattern);

		public Validator validAge(RegistrationInfo newUserInfo) {

			if (newUserInfo.getAge() == null) {

				errors.put(ParamName.AGE, ErrorKey.EMPTY);
			} else {

				match = age.matcher(newUserInfo.getAge());

				if (!match.matches()) {

					errors.put(ParamName.AGE, ErrorKey.UNCORRECT);
				}
			}
			return this;
		}

		private static final Pattern password = Pattern.compile(passwordPattern);

		public Validator validPassword(RegistrationInfo newUserInfo) {

			if (newUserInfo.getPassword() == null) {

				errors.put(ParamName.PASSWORD, ErrorKey.EMPTY);

			} else {

				match = password.matcher(newUserInfo.getPassword());

				if (!match.matches()) {

					errors.put(ParamName.PASSWORD, ErrorKey.UNCORRECT);

				} else if (!newUserInfo.getPassword().equals(newUserInfo.getRepeatPassword())) {

					errors.put(ParamName.PASSWORD, ErrorKey.DOES_NOT_MATCH);
				}
			}
			return this;
		}

		public ValidationResult build() {

			return new ValidationResult(this);
		}
	}

}

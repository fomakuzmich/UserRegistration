package by.fomkin.homework_user_registration.validator;

import java.util.HashMap;
import java.util.Map;

import by.fomkin.homework_user_registration.controller.ServiceException;

public class ValidationException extends ServiceException {

	private static final long serialVersionUID = 1L;

	private Map<ParamName, ErrorKey> errors = new HashMap<>();

	public ValidationException() {

	}

	public ValidationException(Map<ParamName, ErrorKey> errors) {

		this.errors = errors;

	}

	public Map<ParamName, ErrorKey> getErrors() {

		return errors;
	}

}

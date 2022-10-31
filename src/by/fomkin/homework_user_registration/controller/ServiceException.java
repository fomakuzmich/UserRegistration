package by.fomkin.homework_user_registration.controller;

import java.util.HashMap;
import java.util.Map;

import by.fomkin.homework_user_registration.validator.ErrorKey;
import by.fomkin.homework_user_registration.validator.ParamName;
import by.fomkin.homework_user_registration.validator.ValidationException;

public class ServiceException extends Exception {

	private static final long serialVersionUID = 1L;

	private Map<ParamName, ErrorKey> errors = new HashMap<>();

	public ServiceException() {

	}

	public ServiceException(ValidationException exception) {

		this.errors = exception.getErrors();

	}

	public Map<ParamName, ErrorKey> getErrors() {
		
		return errors;
	}
}

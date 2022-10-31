package by.fomkin.homework_user_registration.controller;

import by.fomkin.homework_user_registration.bean.RegistrationInfo;
import by.fomkin.homework_user_registration.bean.User;
import by.fomkin.homework_user_registration.validator.ValidationResult;

public class Controller {

	public void registration(RegistrationInfo newUserInfo) throws ServiceException {

		ValidationResult.Validator validBuild = new ValidationResult.Validator();

		ValidationResult validationResult = validBuild.validName(newUserInfo).validMail(newUserInfo)
				.validAge(newUserInfo).validPassword(newUserInfo).build();

		if (validationResult.isHaveErrors()) {

			throw new ServiceException(validationResult.getException());

		} else {

			newUser(newUserInfo);
		}

	}

	public User newUser(RegistrationInfo newUserInfo) {

		return new User(newUserInfo.getName(), newUserInfo.getMail(), newUserInfo.getPassword(),
				Integer.parseInt(newUserInfo.getAge()));

	}

}

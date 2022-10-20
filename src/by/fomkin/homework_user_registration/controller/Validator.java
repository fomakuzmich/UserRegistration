package by.fomkin.homework_user_registration.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.fomkin.homework_user_registration.bean.Club;
import by.fomkin.homework_user_registration.bean.Request;
import by.fomkin.homework_user_registration.bean.User;

public class Validator {

	public static String message;

	public static boolean requestValidator(Request request) {
		Club club = Club.getInstance();
		for (User user : club.getUsers()) {
			if (user.getName().equalsIgnoreCase(request.getName())) {
				message = "There is already a user with that name";
				return false;
			} else if (user.getMail().equalsIgnoreCase(request.getMail())) {
				message = "There is already a user with that mail";
				return false;
			}
		}

		Matcher match;
		Pattern name = Pattern.compile("[\\w-]+");
		match = name.matcher(request.getName());
		if (!match.matches()) {
			message = "Uncorrectly input name";
			return false;
		}
		Pattern mail = Pattern.compile("[a-zA-Z0-9][\\w-]+@[a-zA-Z]+.[a-zA-Z]+");
		match = mail.matcher(request.getMail());
		if (!match.matches()) {
			message = "Uncorrectly input mail";
			return false;
		}
		Pattern age = Pattern.compile("[0-9]+");
		match = age.matcher(request.getAge());
		if (!match.matches()) {
			message = "Uncorrectly input age";
			return false;
		}
		Pattern password = Pattern.compile("[a-zA-Z0-9]{8,16}");
		match = password.matcher(request.getPassword());
		if (!match.matches()) {
			message = "Uncorrectly input password";
			return false;
		}
		if (!request.getPassword().equals(request.getRepeatPassword())) {
			message = "Uncorrectly repeat password";
			return false;
		}
		message = "Registration is approved";
		return true;
	}

}

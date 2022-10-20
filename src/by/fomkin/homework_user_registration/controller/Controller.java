package by.fomkin.homework_user_registration.controller;

import java.util.Scanner;

import by.fomkin.homework_user_registration.bean.Request;
import by.fomkin.homework_user_registration.bean.User;

public class Controller {
	private Scanner scan = new Scanner(System.in);

	public User newUser() {

		System.out.println("Input username:");
		String name = scan.next();
		System.out.println("Input mail:");
		String mail = scan.next();
		System.out.println("Input age:");
		String age = scan.next();
		System.out.println("Input password:");
		String password = scan.next();
		System.out.println("Repeat password:");
		String repeatPassword = scan.next();

		Request request = new Request(name, mail, age, password, repeatPassword);

		if (!Validator.requestValidator(request)) {
			System.out.println(Validator.message);

			System.out.println("Repeat registration:");
			return newUser();
		} else {
			System.out.println(Validator.message);

			return new User(name, mail, password, Integer.parseInt(age));

		}
	}

}

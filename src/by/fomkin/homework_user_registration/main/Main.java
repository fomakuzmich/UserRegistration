package by.fomkin.homework_user_registration.main;

import java.util.Scanner;

import by.fomkin.homework_user_registration.bean.RegistrationInfo;
import by.fomkin.homework_user_registration.controller.Controller;
import by.fomkin.homework_user_registration.controller.ServiceException;

public class Main {

	public static void main(String[] args) throws ServiceException {

		Controller control = new Controller();

		Scanner scan = new Scanner(System.in);
		
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
		
		scan.close();

		RegistrationInfo newUserInfo = new RegistrationInfo(name, mail, age, password, repeatPassword);
		control.registration(newUserInfo);

	}

}

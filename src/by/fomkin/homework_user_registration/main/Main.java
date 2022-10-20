package by.fomkin.homework_user_registration.main;

import by.fomkin.homework_user_registration.bean.Club;
import by.fomkin.homework_user_registration.bean.User;
import by.fomkin.homework_user_registration.controller.Controller;

public class Main {

	public static void main(String[] args) {

		Controller control = new Controller();

		Club club = Club.getInstance();

		club.addToClub(control.newUser());
		club.addToClub(control.newUser());

		for (User user : club.getUsers()) {
			System.out.println(user.getName() + ", " + user.getAge() + ", " + user.getMail());
		}

	}

}

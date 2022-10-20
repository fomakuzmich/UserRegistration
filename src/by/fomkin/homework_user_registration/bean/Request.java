package by.fomkin.homework_user_registration.bean;

public class Request {

	private String name;
	private String mail;
	private String age;
	private String password;
	private String repeatPassword;

	public Request() {

	}

	public Request(String name, String mail, String age, String password, String repeatPassword) {
		super();
		this.name = name;
		this.mail = mail;
		this.age = age;
		this.password = password;
		this.repeatPassword = repeatPassword;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRepeatPassword() {
		return repeatPassword;
	}

	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}

}

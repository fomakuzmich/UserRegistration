package by.fomkin.homework_user_registration.bean;

import java.io.Serializable;
import java.util.Objects;

public class RegistrationInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private String mail;
	private String age;
	private String password;
	private String repeatPassword;

	public RegistrationInfo() {

	}

	public RegistrationInfo(String name, String mail, String age, String password, String repeatPassword) {

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

	@Override
	public int hashCode() {
		return Objects.hash(age, mail, name, password, repeatPassword);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RegistrationInfo other = (RegistrationInfo) obj;
		return Objects.equals(age, other.age) && Objects.equals(mail, other.mail) && Objects.equals(name, other.name)
				&& Objects.equals(password, other.password) && Objects.equals(repeatPassword, other.repeatPassword);
	}

	@Override
	public String toString() {
		return getClass().getName() + " [name=" + name + ", mail=" + mail + ", age=" + age + ", password=" + password
				+ ", repeatPassword=" + repeatPassword + "]";
	}

}

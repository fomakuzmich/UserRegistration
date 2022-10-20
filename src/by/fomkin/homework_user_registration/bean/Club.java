package by.fomkin.homework_user_registration.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Club implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final Club instance = new Club();

	private List<User> users;

	private Club() {
		this.users = new ArrayList<>();

	}

	public Club(List<User> users) {

		this.users = users;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public void addToClub(User user) {
		users.add(user);
	}

	public static Club getInstance() {
		return instance;
	}

	@Override
	public int hashCode() {
		return Objects.hash(users);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Club other = (Club) obj;
		return Objects.equals(users, other.users);
	}

	@Override
	public String toString() {
		return getClass().getName() + " [users=" + users + "]";
	}

}

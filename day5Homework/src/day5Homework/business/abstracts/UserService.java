package day5Homework.business.abstracts;

import day5Homework.entities.concretes.User;

public interface UserService {
	void register(User user);
	void login(User user);
	boolean getByMail(String email);
}

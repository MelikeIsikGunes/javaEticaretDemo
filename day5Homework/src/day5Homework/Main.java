package day5Homework;

import day5Homework.business.abstracts.UserService;
import day5Homework.business.concretes.UserManager;
import day5Homework.core.concretes.EmailLoggerManager;
import day5Homework.core.concretes.GoogleAccountManagerAdaptor;
import day5Homework.dataAccess.concretes.AbcUserDao;
import day5Homework.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		UserService userService = new UserManager(new AbcUserDao(),new EmailLoggerManager(), new GoogleAccountManagerAdaptor());
		User user1=new User(1,"Melike", "I��k", "melike@gmail.com","123456");
		User user2=new User(2,"Fatih", "G�ne�", "@gmail.com","895874");
		userService.register(user1); //Kay�t olabilecek
		System.out.println("------");
		userService.register(user2); //Eposta hatas� al�r
		
		System.out.println("------");
		userService.login(user1);	//Giri� yapabilir
		System.out.println("------");
		userService.login(user2); //Giri� yapamaz
	}

}

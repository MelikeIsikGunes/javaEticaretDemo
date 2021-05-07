package day5Homework.business.concretes;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import day5Homework.business.abstracts.UserService;
import day5Homework.core.abstracts.AccountService;
import day5Homework.core.abstracts.LoggerService;
import day5Homework.dataAccess.abstracts.UserDao;
import day5Homework.entities.concretes.User;

public class UserManager implements UserService {
	
	private UserDao userDao;
	private LoggerService loggerService;
	private AccountService accountService;


	public UserManager(UserDao userDao,LoggerService loggerService, AccountService accountService) {
		super();
		this.userDao = userDao;
		this.loggerService = loggerService;
		this.accountService = accountService;
	}

	@Override
	public void register(User user) {
		if(user.getPassword().length()<6) {
			System.out.println("Parola en az 6 karakterden oluþmalýdýr.");
			return;
		}
		String regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(user.getEmail());
		if(matcher.matches()==false) {
			System.out.println("E-posta alaný e-posta formatýnda olmalýdýr. (example@gmail.com) ");
			return;
		}
		
		if(user.getFirstName().length()<2 || user.getLastName().length()<2) {
			System.out.println("Ad ve soyad en az iki karakterden oluþmalýdýr.");
			return;
		}
		
		
		if(getByMail(user.getEmail())) {
			System.out.println("Bu eposta sistemde kayýtlýdýr.");
			return;
		}
		
		this.userDao.add(user);
		this.accountService.saveToSystem(user.getFirstName());
		this.loggerService.log(user.getEmail());
		System.out.println("Üyelik iþlemi tamamlandý.");
		
		
		
	}

	@Override
	public void login(User user) {
		if(user.getEmail()=="melike@gmail.com" && user.getPassword()=="123456") {
			System.out.println("Sisteme giriþ yapýldý. Hoþgeldin "+ user.getFirstName());
		}else {
			System.out.println("Hatalý eposta veya þifre girdiniz");
		}
		
	}

	@Override
	public boolean getByMail(String email) {
		return false;
		
	}

}

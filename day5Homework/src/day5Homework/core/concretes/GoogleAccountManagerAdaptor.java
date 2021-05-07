package day5Homework.core.concretes;

import day5Homework.core.abstracts.AccountService;
import day5Homework.googleAccount.GoogleAccountManager;

public class GoogleAccountManagerAdaptor implements AccountService {

	@Override
	public void saveToSystem(String message) {
		GoogleAccountManager manager=new GoogleAccountManager();
		manager.save(message);
		
	}

}

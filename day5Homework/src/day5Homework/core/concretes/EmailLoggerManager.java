package day5Homework.core.concretes;

import day5Homework.core.abstracts.LoggerService;

public class EmailLoggerManager implements LoggerService{

	@Override
	public void log(String message) {
		System.out.println("Do�rulama linki yolland� : "+ message);	
	}

}

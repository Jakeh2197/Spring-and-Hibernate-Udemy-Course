package com.luv2code.springdemo;

import java.util.Random;

public class RandomFortuneService implements FortuneService {
	
	private String[] fortunes;
	
	

	public RandomFortuneService() {
		fortunes = new String[3];
		fortunes[0] = "Fortune number 1";
		fortunes[1] = "Fortune number 2";
		fortunes[2] = "Fortune number 3";
	}



	@Override
	public String getFortune() {
		return getRandomFortune(fortunes);
	}
	
	private String getRandomFortune(String[] fortunes) {
		int random = new Random().nextInt(fortunes.length);
		
		return fortunes[random];
	}

}

package com.jake.springdemo;

public class SadFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Trump will win";
	}

}

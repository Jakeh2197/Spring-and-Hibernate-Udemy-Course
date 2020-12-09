package com.jake.springdemo;

import org.springframework.stereotype.Component;

@Component
public class GetFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "You will get a job as a Software Engineer!";
	}

}

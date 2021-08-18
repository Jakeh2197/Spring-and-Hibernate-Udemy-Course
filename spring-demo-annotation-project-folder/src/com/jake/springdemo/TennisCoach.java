package com.jake.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
	
	@Autowired
	@Qualifier("getFortuneService")
	private FortuneService fortuneService;
	

// 	// Constructor injection
//	@Autowired
//	public TennisCoach(FortuneService fortuneService) {
//		this.fortuneService = fortuneService;
//	}

	
	public TennisCoach() {
		
	}
	
	// define init method
	@PostConstruct
	public void init() {
		System.out.println("Inside init method");
	}
	
	// define destroy method
	@PreDestroy
	public void destroy() {
		System.out.println("Inside destroy method");
	}

	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

/*
	// setter injection
	@Autowired
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
*/
	
}

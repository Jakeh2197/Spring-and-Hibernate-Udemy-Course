package com.luv2code.springdemo;

public class CricketCoach implements Coach {
	
	// define a private field for the dependency
	private FortuneService fortuneService;

	public CricketCoach() {
		System.out.println("CricketCoach: Inside no-arg constructor");
	}	
	
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("CricketCoach: Inside setter method");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Practice fast bowling for 15 minutes a day";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}

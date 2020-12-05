package com.luv2code.springdemo;

public class TrackCoach implements Coach {
	
	// define a private field for the dependency
	private FortuneService fortuneService;
	
	// define a constructor for dependency injection
	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	public TrackCoach() {
		super();
	}

	@Override
	public String getDailyWorkout() {
		return "Spend 30 minutes practicing sprints";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}

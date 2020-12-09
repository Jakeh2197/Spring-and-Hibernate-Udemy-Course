package com.luv2code.springdemo;

public class CricketCoach implements Coach {
	
	private String emailAddress;
	private String team;
	
	// define a private field for the dependency
	private FortuneService fortuneService;

	public CricketCoach() {
		System.out.println("CricketCoach: Inside no-arg constructor");
	}	
	
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("CricketCoach: Inside setter method for setFortuneService");
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

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		System.out.println("CricketCoach: Inside setter method for setEmailAddress");
		this.emailAddress = emailAddress;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		System.out.println("CricketCoach: Inside setter method for setTeam");
		this.team = team;
	}

}

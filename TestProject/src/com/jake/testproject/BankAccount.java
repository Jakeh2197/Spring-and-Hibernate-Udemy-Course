package com.jake.testproject;

public class BankAccount {
	
	private Double savingsAccountBalance;
	private Double checkingAccountBalance;
	
	private Double savingsInterestRate = 0.09;
	private Double checkingInterestRate = 0.04;
	
	public BankAccount() {
	}
	
	public Double getSavingsAccountBalance() {
		return savingsAccountBalance;
	}
	public void setSavingsAccountBalance(Double savingsAccountBalance) {
		this.savingsAccountBalance = savingsAccountBalance;
	}
	public Double getCheckingAccountBalance() {
		return checkingAccountBalance;
	}
	public void setCheckingAccountBalance(Double checkingAccountBalance) {
		this.checkingAccountBalance = checkingAccountBalance;
	}
	public Double getSavingsInterestRate() {
		return savingsInterestRate;
	}
	public void setSavingsInterestRate(Double savingsInterestRate) {
		this.savingsInterestRate = savingsInterestRate;
	}
	public Double getCheckingInterestRate() {
		return checkingInterestRate;
	}
	public void setCheckingInterestRate(Double checkingInterestRate) {
		this.checkingInterestRate = checkingInterestRate;
	}

}

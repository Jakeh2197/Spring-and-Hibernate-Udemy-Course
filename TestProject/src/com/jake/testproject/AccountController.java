package com.jake.testproject;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AccountController {
	
	BankAccount account = new BankAccount();
	
	@RequestMapping("/")
	public String showPage(Model model) {
		model.addAttribute("account", account);
		
		return "account-setup";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("account") BankAccount account,
			BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return "account-setup";
		} else {
			System.out.println(account.getCheckingAccountBalance());
			return "account-home";
		}
	}
	
	@RequestMapping("/transfers") 
	public String accountTransfers(@ModelAttribute("account") BankAccount account,
			BindingResult bindingResult) {
		System.out.println(account.getCheckingAccountBalance());
		return "account-transfers";
	}
}

package com.capgemini.shoppingCartSystem.loginservice.config;

import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.shoppingCartSystem.loginservice.service.CurrentUserService;

public class LogOutThread extends Thread{
	@Autowired
	CurrentUserService cus;
	public void run(){  
		try {
			Thread.currentThread().wait(6000);
			cus.logout();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}  
}

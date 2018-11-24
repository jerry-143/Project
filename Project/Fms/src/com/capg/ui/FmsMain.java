package com.capg.ui;

import java.util.Scanner;

import com.capg.service.ServiceImpl;

public class FmsMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb=new Scanner(System.in);
		
	    ServiceImpl s = new ServiceImpl();
	    
		System.out.println("enter user name");
		String uname=kb.nextLine();
	    System.out.println("enter password");
	    String pass=kb.nextLine();
	
		System.out.println(s.isValidate(uname, pass));

	}

}

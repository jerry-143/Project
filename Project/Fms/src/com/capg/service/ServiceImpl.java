package com.capg.service;

public class ServiceImpl implements Iservice{

	@Override
	public Boolean isValidate(String str1, String str2) {
		// TODO Auto-generated method stub
		
		if(!(str1.isEmpty()||str2.isEmpty()))
		return true;
		else
		return false;
	}

}
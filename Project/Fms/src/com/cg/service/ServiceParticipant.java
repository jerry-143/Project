package com.cg.service;

import com.cg.bean.FeedbackMaster;
import com.cg.dao.DaoParticipant;

public class ServiceParticipant {
	DaoParticipant dp=new DaoParticipant();
	public void insertFeedback(FeedbackMaster fm){
		dp.insertFeedback(fm);
		
	}
}

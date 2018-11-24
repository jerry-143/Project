package com.cg.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cg.bean.FeedbackMaster;
import com.cg.bean.TrainingProgram;
import com.cg.dao.DAO;
import com.cg.dao.DaoCoord;
import com.cg.dao.IDaoCoord;

public class ServiceCoord implements IServiceCoord{
	IDaoCoord dao=new DaoCoord();
    DAO d=new DAO();
	@Override
	public ArrayList<TrainingProgram> trainingMaintenance() {
		
		return dao.trainingMaintenance();
	}



	@Override
	public ArrayList<FeedbackMaster> viewFeedback() throws SQLException {
		
		return  d.retriveFeedback();
		
	}



	@Override
	public int addParticipantDetails(com.cg.bean.paticipantEnrollment Enroll) {
		// TODO Auto-generated method stub
		 return dao.addParticipantDetails(Enroll);
	}



}

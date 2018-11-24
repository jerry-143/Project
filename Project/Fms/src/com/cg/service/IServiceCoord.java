package com.cg.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cg.bean.FeedbackMaster;
import com.cg.bean.TrainingProgram;
import com.cg.bean.paticipantEnrollment;

public interface IServiceCoord {

	ArrayList<TrainingProgram> trainingMaintenance();
	
	int addParticipantDetails(paticipantEnrollment Enroll);

	ArrayList<FeedbackMaster> viewFeedback() throws SQLException;

}

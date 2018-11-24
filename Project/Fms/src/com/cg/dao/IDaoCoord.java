package com.cg.dao;

import java.util.ArrayList;

import com.cg.bean.TrainingProgram;
import com.cg.bean.paticipantEnrollment;

public interface IDaoCoord {

	ArrayList<TrainingProgram> trainingMaintenance();
	
	int addParticipantDetails(paticipantEnrollment Enroll);

	


}

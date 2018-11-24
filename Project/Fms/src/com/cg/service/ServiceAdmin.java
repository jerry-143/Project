package com.cg.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cg.bean.FeedbackMaster;
import com.cg.dao.DAO;

public class ServiceAdmin implements IServiceAdmin{
DAO d=new DAO();
	@Override
	public void facultySkillMaintenance() {
		
		
	}

	@Override
	public void courseMaintenance() {
		
		
	}

	@Override
	public ArrayList<FeedbackMaster> viewReport() throws SQLException {
		return  d.retriveFeedback();
		
	}

}

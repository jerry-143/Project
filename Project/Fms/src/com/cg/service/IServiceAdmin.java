package com.cg.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cg.bean.FeedbackMaster;

public interface IServiceAdmin {

	void facultySkillMaintenance();

	void courseMaintenance();

	ArrayList<FeedbackMaster> viewReport() throws SQLException;

}

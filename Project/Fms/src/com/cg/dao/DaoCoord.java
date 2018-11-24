package com.cg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.cg.bean.TrainingProgram;
import com.cg.bean.paticipantEnrollment;
import com.cg.util.DBUtil;

public class DaoCoord implements IDaoCoord {
   Connection conn;
	public DaoCoord(){
		conn=DBUtil.getConnection();
	}
	
	ArrayList<TrainingProgram> al=new ArrayList<TrainingProgram>();

	@Override
	public ArrayList<TrainingProgram> trainingMaintenance() 
	{
	String query="select * from training_program";
	try
	{
		PreparedStatement statement=  conn.prepareStatement(query);
		ResultSet rset= statement.executeQuery();
		
		while(rset.next())
		{
			int trainingCode=rset.getInt(1);
			int courseCode=rset.getInt(2);
			int facultyCode=rset.getInt(3);
			String startdate=rset.getString(4);
			String endDate=rset.getString(5);
			TrainingProgram obj=new TrainingProgram(trainingCode,courseCode,facultyCode,startdate,endDate);
			al.add(obj);
			
		}
	}
	catch (SQLException e) {
		
		e.printStackTrace();
	}
	return al;
	}
	
	//
	  

	@Override
		public int addParticipantDetails(paticipantEnrollment Enroll) {
		
		int x = 0;
		String sql="INSERT INTO TRAINING_PARTICIPANT_ENROLLMENT VALUES(?,?)"; 
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
					
			
			statement.setInt(1,Enroll.getTrainingCode());
			statement.setInt(2,Enroll.getParticipantId());
			
			
			
			x=statement.executeUpdate();
			System.out.println("Enrolled Successful ..");
			
			
		
		} catch (SQLException e) {
			
			e.printStackTrace();
			
			
			
		}
			
		return x;
	}


	
	 
}

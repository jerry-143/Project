package com.cg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.cg.bean.FeedbackMaster;
import com.cg.util.DBUtil;

public class DaoParticipant {
	Connection conn;
		 public int insertFeedback(FeedbackMaster fm){
				
				conn=DBUtil.getConnection();
				
				int x=0;	
				String sql="INSERT INTO FEEDBACK_MASTER VALUES(?,?,?,?,?,?,?,?,?)"; 
				try {
					PreparedStatement statement = conn.prepareStatement(sql);
							
					
					statement.setInt(1,fm.getTraining_Code());
					statement.setInt(2,fm.getParticipant_Id());
					
					statement.setInt(3,fm.getFB_Prs_comm());
					statement.setInt(4,fm.getFB_Clrfy_dbts());
					statement.setInt(5,fm.getFB_TM());
					statement.setInt(6,fm.getFB_Hnd_out());
					statement.setInt(7,fm.getFB_Hw_Sw_Ntwrk());
					statement.setString(8,fm.getComments());
					statement.setString(9,fm.getSuggestions());
					
					x=statement.executeUpdate();
					System.out.println("Enrolled Successful ..");
					
					return x;	
				
				} catch (SQLException e) {
					
					e.printStackTrace();
					return x;		
				}
			}
}

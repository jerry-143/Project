package com.cg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cg.bean.FeedbackMaster;
import com.cg.util.DBUtil;

public class DAO implements IDao {
	Connection conn;

	public DAO() {

		conn = DBUtil.getConnection();

	}

	@Override
	public String validate(int eid, String pass) {
		String query = "SELECT * FROM EMPLOYEE_MASTER WHERE Employee_ID =? AND Password=?";
		try {
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, eid);
			statement.setString(2, pass);
			ResultSet rSet = statement.executeQuery();
			if (rSet == null) {

				return ("invalid Employee id or password \n try again");
			} else {
				rSet.next();
				if (rSet.getString(4).equalsIgnoreCase("admin"))

				{
					return "admin";
				} else if (rSet.getString(4).equalsIgnoreCase("coordinator")) {
					return "coordinator";
				} else // participant
				{
					return "participant";
				}
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

	// @Override
	// public void show() {
	// String query = "select something2 from somewhere2";
	// try {
	// PreparedStatement statement= conn.prepareStatement(query);
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	//
	//
	//
	//
	// }

	// for course ID Course_Master
	public Boolean validateCID(int id) {
		String query = "select course_ID from Course_master where Course_ID=?";
		ResultSet resultSet = null;
		try {
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(1, id);
			resultSet = stmt.executeQuery();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		if (resultSet == null) {
			return false;
		} else
			return true;
	}

	// for training code table=Trainig_program
	public Boolean validate(int id) {
		String query = "Select training_code from training_program where training_code=?";
		ResultSet resultSet = null;
		try {
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(1, id);
			resultSet = stmt.executeQuery();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		if (resultSet == null) {
			return false;
		} else
			return true;

	}
	
	public ArrayList<FeedbackMaster> retriveFeedback() throws SQLException{
		ArrayList<FeedbackMaster> al=new ArrayList<FeedbackMaster>();
		String query = "Select * from feedback_master";
		ResultSet rs=null;
		PreparedStatement pst=conn.prepareStatement(query);
		rs=pst.executeQuery();
		while(rs.next()){
			FeedbackMaster fm=new FeedbackMaster();
			fm.setComments(rs.getString(8));
			fm.setFB_Clrfy_dbts(rs.getInt(4));
			fm.setFB_Hnd_out(rs.getInt(6));
			fm.setFB_Hw_Sw_Ntwrk(rs.getInt(7));
			fm.setFB_Prs_comm(rs.getInt(3));
			fm.setFB_TM(rs.getInt(5));
			fm.setParticipant_Id(rs.getInt(2));
			fm.setTraining_Code(rs.getInt(1));
			fm.setSuggestions(rs.getString(9));
			al.add(fm);
		}
		
		return al;
		
	} 

}
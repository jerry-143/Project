package com.cg.ui;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.cg.bean.FeedbackMaster;
import com.cg.bean.TrainingProgram;
import com.cg.bean.paticipantEnrollment;
import com.cg.dao.DAO;
import com.cg.dao.DaoCoord;
import com.cg.service.IService;
import com.cg.service.IServiceAdmin;
import com.cg.service.IServiceCoord;
import com.cg.service.Service;
import com.cg.service.ServiceAdmin;
import com.cg.service.ServiceCoord;
import com.cg.service.ServiceParticipant;

public class Fmsmain {
	
	public static void main(String[] args) throws SQLException {
		DAO d=new DAO();
		FeedbackMaster fm=new FeedbackMaster();
		int eid;
		ServiceParticipant sp=new ServiceParticipant();
		Scanner kb= new Scanner(System.in);
		IService service=new Service();
		IServiceAdmin admin=new ServiceAdmin();
		IServiceCoord coord=new ServiceCoord();
		ArrayList<FeedbackMaster> fbm=new ArrayList<FeedbackMaster>();
		String role="";
	do{
		do
		{
		
		System.out.println("Employee ID: ");
		eid=kb.nextInt();
		System.out.println("passsword: ");
		String pass=kb.next();
		Boolean b= service.isValid(eid, pass);
		if(b==true)
		{
			 role=service.validate(eid,pass);
			 break;
		}
		else
		{
			System.out.println(role);
		}
		}while(true);
		
		
		switch(role)
		{
		case "admin":
		{  int choice;
			do
			{
			System.out.println("1.	Faculty skill Maintenance");
			System.out.println("2.	Course Maintenance");
			System.out.println("3.	View Feedback Report");
			System.out.println("4.  exit");
			System.out.println("Enter your choice:");
			 choice=kb.nextInt();
			
			switch(choice){
			case 1:
			{
				admin.facultySkillMaintenance();
			    	
			}
			case 2:
			{
				admin.courseMaintenance();
			}
			case 3:
			{
				fbm=admin.viewReport();
				for(int i=0;i<fbm.size();i++){
					System.out.println(fbm.get(i).getParticipant_Id());
					System.out.println(fbm.get(i).getTraining_Code());
					System.out.println(fbm.get(i).getFB_Prs_comm());
					System.out.println(fbm.get(i).getFB_Clrfy_dbts());
					System.out.println(fbm.get(i).getFB_TM());
					System.out.println(fbm.get(i).getFB_Hnd_out());
					System.out.println(fbm.get(i).getFB_Hw_Sw_Ntwrk());
					System.out.println(fbm.get(i).getComments());
					System.out.println(fbm.get(i).getSuggestions());
					System.out.println("___________________________________");
				}
			}
			case 4:
			{
				break;
			}
			}
		}while(choice!=4);
			break;
		}
		case "coordinator" :
		{  int choice;
			do
			{
			System.out.println("1.	Training program Maintenance");
			System.out.println("2.	Participant Enrollment");
			System.out.println("3.	View Feedback Report");
			System.out.println("4.  exit");
			System.out.println("enter your choice");
			 choice=kb.nextInt();
			ArrayList<TrainingProgram> al=new ArrayList<TrainingProgram>();
			
			switch(choice){
			case 1:
			{
				al=coord.trainingMaintenance();
				//while(al.hasNext()){
				for(TrainingProgram obj: al){
					System.out.println("");
					
				}	
				}
			
			case 2:
			{    	al=coord.trainingMaintenance();
			//while(al.hasNext()){
			for(TrainingProgram obj: al){
				System.out.println("");
				
			}	
				
				System.out.println("Enter the Participant Id: ");
				
				
				int participant=kb.nextInt();
				System.out.println("Enter Training Code: ");
				int TrainingCode=kb.nextInt();
				paticipantEnrollment p= new paticipantEnrollment();
				p.setParticipantId(participant);
				p.setTrainingCode(TrainingCode);
				int x=coord.addParticipantDetails(p);
				System.out.println("code chal raha h"+x);// remove this
			}
			case 3:
			{	
				fbm=coord.viewFeedback();
				for(int i=0;i<fbm.size();i++){
					System.out.println(fbm.get(i).getParticipant_Id());
					System.out.println(fbm.get(i).getTraining_Code());
					System.out.println(fbm.get(i).getFB_Prs_comm());
					System.out.println(fbm.get(i).getFB_Clrfy_dbts());
					System.out.println(fbm.get(i).getFB_TM());
					System.out.println(fbm.get(i).getFB_Hnd_out());
					System.out.println(fbm.get(i).getFB_Hw_Sw_Ntwrk());
					System.out.println(fbm.get(i).getComments());
					System.out.println(fbm.get(i).getSuggestions());
					System.out.println("___________________________________");
				}
			}
			case 4:
			{
				break;
			}
			default :
			{
				System.out.println("please enter correct choice");
			}
			}
		}while(choice!=4);
		}
		case "participant" :
		{
			
			System.out.println("1. Feedback");
			System.out.println("2. Exit");
			
			int choice=kb.nextInt();
			
			switch(choice){
			case 1:
			{
				do{
				System.out.println("Enter your training code:");
				int tCode=kb.nextInt();
				int pId=eid;
				if(d.validate(tCode)){
					System.out.println("--------Overall Course Rating-------------");
					System.out.println("1. How would you rate the course you attended as an overall learning experience?(out of 1 to 5)");
					int overall=kb.nextInt();
					System.out.println("2. Number of clarified doubts:");
					int cDoubts=kb.nextInt();
					System.out.println("3. Rate: were the topics relevent");
					int tRelevent=kb.nextInt(); 
					System.out.println("4. Rate your Hands-on Experience");
					int hExp=kb.nextInt();
					System.out.println("5. Rate: Hardware/Software/Networking");
					int rateHSN=kb.nextInt();
					System.out.println("6. What are the views you find most valuable about this course?");
					String comments=kb.next();
					System.out.println("7. What suggestions do you have to improve the course?");
					String suggest=kb.next();
					fm.setComments(comments);
					fm.setFB_Clrfy_dbts(cDoubts);
					fm.setFB_Hnd_out(hExp);
					fm.setFB_Hw_Sw_Ntwrk(rateHSN);
					fm.setFB_Prs_comm(overall);
					fm.setFB_TM(tRelevent);
					fm.setParticipant_Id(pId);
					fm.setSuggestions(suggest);
					fm.setTraining_Code(tCode);
					sp.insertFeedback(fm);
				}else{
					System.out.println("Enter valid training code.");
					break;
				}
				}while(true);
			}
			
			}
			
		}
		}

	}while(true);
	
	}

}

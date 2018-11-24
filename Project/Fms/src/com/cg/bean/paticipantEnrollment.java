package com.cg.bean;

public class paticipantEnrollment {
	
	
	int trainingCode;
	int participantId;
	
	public paticipantEnrollment() {
		// TODO Auto-generated constructor stub
	}
	public int getTrainingCode() {
		return trainingCode;
	}
	public void setTrainingCode(int trainingCode) {
		this.trainingCode = trainingCode;
	}
	public int getParticipantId() {
		return participantId;
	}
	public void setParticipantId(int participantId) {
		this.participantId = participantId;
	}
	
	public paticipantEnrollment(int trainingCode, int participantId) {
		super();
		this.trainingCode = trainingCode;
		this.participantId = participantId;
		
	
	

}
	@Override
	public String toString() {
		return "paticipantEnrollment [trainingCode=" + trainingCode
				+ ", participantId=" + participantId + "]";
	}
}

package com.jobtrack;

public class Job {

	private int file;
	private String company;
	private String position;
	private String dateApplied;
	private String interview;
	private String interviewDate;
	private String notes;
	
	public Job(int file, String company, String position, String dateApplied, String interview, String interviewDate,
			String notes) {
		this.file = file;
		this.company = company;
		this.position = position;
		this.dateApplied = dateApplied;
		this.interview = interview;
		this.interviewDate = interviewDate;
		this.notes = notes;
	}

	public Job(String company, String position, String dateApplied, String interview, String interviewDate,
			String notes) {
		this.company = company;
		this.position = position;
		this.dateApplied = dateApplied;
		this.interview = interview;
		this.interviewDate = interviewDate;
		this.notes = notes;
	}

	
	public int getFile() {
		return file;
	}

	public void setFile(int file) {
		this.file = file;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getDateApplied() {
		return dateApplied;
	}

	public void setDateApplied(String dateApplied) {
		this.dateApplied = dateApplied;
	}

	public String getInterview() {
		return interview;
	}

	public void setInterview(String interview) {
		this.interview = interview;
	}

	public String getInterviewDate() {
		return interviewDate;
	}

	public void setInterviewDate(String interviewDate) {
		this.interviewDate = interviewDate;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Override
	public String toString() {
		return "Job [file=" + file + ", company=" + company + ", position=" + position + ", dateApplied=" + dateApplied
				+ ", interview=" + interview + ", interviewDate=" + interviewDate + ", notes=" + notes + "]";
	}

}

package com.jobtrack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class JobTrackDbUtil {

	private DataSource dataSource;
	
	public JobTrackDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}
	
	public List<Job> getJobs() throws Exception {
		
		List<Job> jobs = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// get a connection
			myConn = dataSource.getConnection();
			
			// create a sql statement
			String sql = "select * from job order by company";
			
			myStmt = myConn.createStatement();
			
			// execute the query
			myRs = myStmt.executeQuery(sql);
			
			//process the result set
			while (myRs.next()) {
				
				// retrieve data from Rs row
				int file = myRs.getInt("File");
				String company = myRs.getString("Company");
				String position = myRs.getString("Position");
				String dateApplied = myRs.getString("Date_Applied");
				String interview = myRs.getString("Interview");
				String interviewDate = myRs.getString("Interview_Date");
				String notes = myRs.getString("Notes");
				
				// create new job application object
				Job tempJob = new Job(file, company, position, dateApplied, interview, interviewDate, notes);
				
				// add it to the list of job applications
				jobs.add(tempJob);
				
			}
				
			return jobs;
			
		}
		finally {
			// close JDBC objects
			close(myConn, myStmt, myRs);
		}
		
		
		
	}

	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
		
		try {
			if (myRs != null) {
				myRs.close();
			}
			
			if (myStmt != null) {
				myStmt.close();
			}
			
			if (myConn != null) {
				myConn.close();
			}
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
		
	}

	public void addJob(Job theJob) throws Exception{
			
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// create db connection
			myConn = dataSource.getConnection();
			
			// create sql for insert			
			String sql = "insert into job "
					+ "(company, position, date_applied, interview, interview_date, notes) "
					+ "values (?, ?, ?, ?, ?, ?)";
			
			myStmt = myConn.prepareStatement(sql);
			
			// set the param values for the job applications
			myStmt.setString(1, theJob.getCompany());
			myStmt.setString(2, theJob.getPosition());
			myStmt.setString(3, theJob.getDateApplied());
			myStmt.setString(4, theJob.getInterview());
			myStmt.setString(5, theJob.getInterviewDate());
			myStmt.setString(6, theJob.getNotes());
		
			// execute sql insert
			myStmt.execute();
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}
	}
	
}

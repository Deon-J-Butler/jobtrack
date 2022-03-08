package com.jobtrack;

import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import javax.sql.DataSource;

/**
 * Servlet implementation class JobTrackServlet
 */
@WebServlet("/JobTrackServlet")
public class JobTrackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private JobTrackDbUtil jobTrackDbUtil;
	
	@Resource(name="jdbc/jobtrack")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		// create our jobtrack db util ... and pass in the conn pool / datasource
		try {
			jobTrackDbUtil = new JobTrackDbUtil(dataSource);
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			// read the "command" parameter
			String theCommand = request.getParameter("command");
			
			// if the command is missing, then default to listing students
			if (theCommand == null) {
				theCommand = "LIST";
			}
			
			// route to the appropriate
			switch (theCommand) {
			
			case "LIST":
				listJob(request, response);
				break;
				
			case "ADD":
				addJob(request, response);
				break;
				
			default:
				listJob(request, response);
			}
			
			// list the jobs applied in MVC fashion
			listJob(request, response);
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
		
	}

	private void addJob(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// read application info from the form data
		String company = request.getParameter("company");
		String position = request.getParameter("position");
		String dateApplied = request.getParameter("dateApplied");
		String interview = request.getParameter("interview");
		String interviewDate = request.getParameter("interviewDate");
		String notes = request.getParameter("notes");
		
		// create a new job application object
		Job theJob = new Job(company, position, dateApplied, interview, interviewDate, notes);
				
		// track the job application on the db
		jobTrackDbUtil.addJob(theJob);
		
		// send back to main page (the list)
		listJob(request, response);
	}

	private void listJob(HttpServletRequest request, HttpServletResponse response) 
	throws Exception{
		
		// get students from db util
		List<Job> jobs = jobTrackDbUtil.getJobs();
		
		// add students to the request
		request.setAttribute("JOB_LIST", jobs);
		
		// send to JSP page (view)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-jobs-applied.jsp");
		dispatcher.forward(request, response);
		
	}

}

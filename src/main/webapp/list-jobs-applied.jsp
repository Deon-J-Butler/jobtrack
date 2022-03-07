<%@ page import="java.util.*, com.jobtrack.*, main.webapp.DateBean" %>
<!DOCTYPE html>
<html>

<head>
<title>JobTrack</title>

<link type="text/css" rel="stylesheet" href="style.css">
</head>

<%
// get the students from the request object (sent by servlet)
	List<Job> theJobs =
			(List<Job>) request.getAttribute("JOB_LIST");
%>

<body>

<div id="wrapper">
	<div id="header">
		<h2>JobTrack</h2>
	</div>
</div>

<div id="container">

<div id="content">

<input type="button" value="Track Job Application"
onclick="window.location.href='track-job.jsp'; return false;"
class="button"
/>
<br>
<input type="button" value="Export as .csv"
onclick="window.location.href='ExportJobTrack'; return true;"
class="button"
/>

<table>
	<tr>
		<th>Company</th>
		<th>Position</th>
		<th>Date Applied</th>
		<th>Interview? (Y/N)</th>
		<th>Date Interviewed</th>
		<th>Notes</th>
	</tr>
	
	<%
		for (Job tempJob : theJobs) {
		%>
	
		<tr>
			<td> <%= tempJob.getCompany() %> </td>
			<td> <%= tempJob.getPosition() %> </td>
			<td> <%= tempJob.getDateApplied() %> </td>
			<td> <%= tempJob.getInterview() %> </td>
			<td> <%= tempJob.getInterviewDate() %> </td>
			<td> <%= tempJob.getNotes() %> </td>
		</tr>
	
	<% } %>
</table>

</div>

</div>
<br>
<input type="button" value="Contact Us"
onclick="window.location.href='email-form.jsp'; return false;"
class="button"
/>

	<div class="fixed"><jsp:useBean id="dateBean" class="main.webapp.DateBean" scope="session">
		<%-- initialize bean properties --%>
		<jsp:setProperty property="param1" name="dateBean"/>
	</jsp:useBean>
	
	<jsp:getProperty property="param1" name="dateBean"/></div>

</body>



</html>
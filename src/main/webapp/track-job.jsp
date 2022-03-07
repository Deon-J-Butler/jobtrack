<!DOCTYPE html>
<html>

<head>
	<title>Track Job</title>
	
	<link type="text/css" rel="stylesheet" href="style.css">
	<link type="text/css" rel="stylesheet" href="track-job-style.css">
	
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>JobTrack</h2>
		</div>
	</div>

	<div id="container">
		<h3>Track Job</h3>
		
		<form action="JobTrackServlet" method="GET">
		
			<input type="hidden" name="command" value="ADD" />
		
			<table>
				<tbody>
					<tr>
						<td><label>Company:</label></td>
						<td><input type="text" name="company" /></td>
					</tr>
					
					<tr>
						<td><label>Position:</label></td>
						<td><input type="text" name="position" /></td>
					</tr>
					
					<tr>
						<td><label>Date Applied (YYYY-MM-DD):</label></td>
						<td><input type="text" name="dateApplied" /></td>
					</tr>
					
					<tr>
						<td><label>Interview (Y/N):</label></td>
						<td><input type="text" name="interview" /></td>
					</tr>
					
					<tr>
						<td><label>Interview Date (YYYY-MM-DD):</label></td>
						<td><input type="text" name="dateInterviewed" /></td>
					</tr>
					
					<tr>
						<td><label>Notes:</label></td>
						<td><input type="text" name="notes" /></td>
					</tr>
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>
				</tbody>
			</table>
		</form>
		
		<div style="clear: both;"></div>
		
		<p>
			<a href="JobTrackServlet">Back to List</a>
		</p>
	</div>
	
	<div class="fixed"><jsp:useBean id="dateBean" class="main.webapp.DateBean" scope="session">
		<%-- initialize bean properties --%>
		<jsp:setProperty property="param1" name="dateBean"/>
	</jsp:useBean>
	
	<jsp:getProperty property="param1" name="dateBean"/></div>
	
</body>

</html>
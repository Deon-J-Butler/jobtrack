package com.jobtrack;

import java.io.*;
import java.sql.*;

public class ExportJobTrack {

	public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/jobtrack";
        String username = "root";
        String password = "toor";
         
        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password)) {
            String sql = "SELECT * FROM job";
             
            Statement statement = connection.createStatement();
             
            ResultSet result = statement.executeQuery(sql);
             
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter("JobTracker.csv"));
             
            // write header line containing column names       
            fileWriter.write("File,Company,Position,Date_Applied,Interview,Interview_Date,Notes");
             
            while (result.next()) {
                int file = result.getInt("File");
                String company = result.getString("Company");
                String position = result.getString("Position");
                String dateApplied = result.getString("Date_Applied");
                String interview = result.getString("Interview");
                String interviewDate = result.getString("Interview_Date");
                String notes = result.getString("Notes");
                 
                String line = String.format("\"%s\",%s,%s,%s,%s,%s,%s",
                       file, company, position, dateApplied, interview, interviewDate, notes);
                 
                fileWriter.newLine();
                fileWriter.write(line);            
            }
             
            statement.close();
            fileWriter.close();
             
        } catch (SQLException e) {
            System.out.println("Datababse error:");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("File IO error:");
            e.printStackTrace();
        }
         
    }
	
}

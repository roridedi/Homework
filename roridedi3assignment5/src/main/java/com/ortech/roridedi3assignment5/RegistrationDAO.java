package com.ortech.roridedi3assignment5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegistrationDAO {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://127.0.0.1:3306?useSSL=false" + "";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "afolabi41";

	void saveRegistration(Registration registraion) {

		Connection conn = null;
		PreparedStatement ps = null;
		PreparedStatement ps1= null;
		// STEP 2: Register JDBC driver
		try {
			Class.forName(JDBC_DRIVER);
			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			ps = conn.prepareStatement("INSERT INTO roridedi.REGISTRATION (FIRST_NAME,EMAIL,EMPLOYMENT_STATUS,VEHICLE,"
					+ "PRICE,TOTAL,HOTEL_PRICE,REGISTRATION_ID) values (?,?,?,?,?,?,?,?)");
			ps1= conn.prepareStatement("INSERT INTO roridedi.COURSE(COURSE_ID, COURSE_NAME) VALUES (?,?)");
			ps.setString(1, registraion.getFirstName());
			ps.setString(2, registraion.getEmail());
			ps.setString(3, registraion.getEmploymentStatus());
			ps.setString(4, registraion.getVehicle());
			ps.setString(5, registraion.getPrice());
			ps.setString(6, registraion.getTotal());
			ps.setString(7, registraion.getHotelPrice());
			ps.setString(8, registraion.getFirstName());
			ps.executeUpdate();
			
			for(Course c: registraion.getCourses()) {
				ps1.setString(1, registraion.getFirstName());
				ps1.setString(2, c.getCourseName());
				ps1.executeUpdate();
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//ps1.setString(1, registraion.getCourses().);

	}

	 Registration getRegistrationList(String registrationName) throws ClassNotFoundException, SQLException {
		 Registration registration = null;
		 Connection conn = null;
		PreparedStatement ps = null;
		// STEP 2: Register JDBC driver
		Class.forName(JDBC_DRIVER);

		// STEP 3: Open a connection
		System.out.println("Connecting to database...");
		conn = DriverManager.getConnection(DB_URL, USER, PASS);
		// STEP 4: Execute a query
		System.out.println("Creating statement...");
		ps = conn.prepareStatement("	SELECT A.FIRST_NAME,A.EMAIL,A.EMPLOYMENT_STATUS,A.VEHICLE,\n"
				+ "		A.PRICE,A.TOTAL,A.HOTEL_PRICE,A.REGISTRATION_ID,B.COURSE_ID,B.COURSE_NAME FROM \n"
				+ "		REGISTRATION A, COURSE B where a.FIRST_NAME=B.COURSE_ID AND B.COURSE_ID=?;\n" + ")");
		ps.setString(1, registrationName);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			registration= new Registration();
			registration.setFirstName(rs.getString(1));
			registration.setEmail(rs.getString(2));
			registration.setEmploymentStatus(rs.getString(3));
			registration.setVehicle(rs.getString(4));
			registration.setPrice(rs.getString(5));
			registration.setTotal(rs.getString(6));
			registration.setHotelPrice(rs.getString(7));
			Course course = new Course();
			course.setCourseId(rs.getString(9));
			course.setCourseName(rs.getString(10));
			List<Course> courses = new ArrayList<Course>();
			registration.setCourses(courses);
		}
		rs.close();
		ps.close();
		conn.close();

		return registration;

	}
	
	
}

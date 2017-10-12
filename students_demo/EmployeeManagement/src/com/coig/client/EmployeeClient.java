package com.coig.client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeClient {
	public static void main(String[] args) {

		// load driver
		// make connecion
		// statment
		// resultset
		// connectionclose
		Connection con = null;
		try {

			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/apex_db", "root", "admin");
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery("select * from employees");

			while (rs.next()) {
				// type type = (type) rs.next();
				System.out.println("ID " + rs.getInt(1));
				System.out.println("Name " + rs.getString(2));
				System.out.println("Email " + rs.getString(3));
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}

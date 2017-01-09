package com.msrm.ocp8.chapter0;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * <pre>
 * Which of the following position a ResultSet cursor to a location immediately before the
first row? (Choose all that apply.)
A. rs.absolute(-1) 
B. rs.absolute(0) 
C. rs.absolute(1) 
D. rs.beforeFirst() 
E. rs.first()
F. rs.next()
 * </pre>
 * 
 * @author srirammuthaiah
 *
 */
public class CH0Question19 {

	public static void main(String[] args) throws Exception {
		String url = "jdbc:mysql://localhost:3306/test";
		String user = "root";
		String password = "root";
		try (Connection con = DriverManager.getConnection(url, user, password);
				// Statement st =
				// con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
				// ResultSet.CONCUR_UPDATABLE);
				Statement st = con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = st.executeQuery("SELECT * FROM items");) {
			System.out.println("Item details");

			rs.absolute(3);
			rs.relative(2);
			System.out.println(rs.getString(2));
			rs.relative(-1);
			System.out.println(rs.getString(2));

			// while (rs.next()) {
			// System.out.printf("%d\t%-30s %.2f%n", rs.getInt(1),
			// rs.getString(2), rs.getFloat(3));
			// }
		}
	}

}

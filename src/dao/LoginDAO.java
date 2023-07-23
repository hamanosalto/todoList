package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.user;

public class LoginDAO {

	private final static String JDBC_URL ="jdbc:mysql://localhost:3306/text";
	private final static String DB_USER = "root";
	private final static String DB_PASS = "rootroot";

	public user findAll(user user) {

		user userr = null;

		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

			String sql = "SELECT pass FROM user where master_id = ? ";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, user.getMaster_id());

			ResultSet rs = pStmt.executeQuery();
			while(rs.next()) {
				String pass = rs.getString("pass");

				userr = new user(pass);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userr;
	}
}

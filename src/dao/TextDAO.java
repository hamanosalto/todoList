package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.TextBeen;

public class TextDAO {

	private final static String JDBC_URL ="jdbc:mysql://localhost:3306/text";
	private final static String DB_USER = "root";
	private final static String DB_PASS = "rootroot";

	public boolean insertText(TextBeen text1) {
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
		String sql =
		"INSERT INTO text(todo) VALUES(?)";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				pStmt.setString(1, text1.getText());

				int rs = pStmt.executeUpdate();
				if(rs != 1){
					return false;
				}

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				return false;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
			return true;
	}

	public ArrayList<TextBeen> selectAll() {

		ArrayList<TextBeen> textList = new ArrayList<TextBeen>();

		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

			String sql = "SELECT * FROM text;";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			ResultSet rs = pStmt.executeQuery();
			while(rs.next()) {
				String kekka = rs.getString("todo");
				TextBeen text = new TextBeen(kekka);
				textList.add(text);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return textList;
	}

}

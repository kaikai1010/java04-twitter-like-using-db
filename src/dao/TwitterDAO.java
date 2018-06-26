package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Twitter;

public class TwitterDAO {

	private final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	private final String JDBC_URL =
		"jdbc:mysql://localhost:3306/twitter_like?characterEncoding=UTF-8&serverTimezone=JST";
	private final String DB_USER = "root";
	private final String DB_PASS = "";

	public List<Twitter> findAll() {

		List<Twitter> tList = new ArrayList<Twitter>();

		Connection conn = null;

		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			String sql = "SELECT NAME,TEXT FROM TWITTER ORDER BY ID DESC";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();

			while(rs.next()) {
				String TwitterName = rs.getString("NAME");
				String text = rs.getString("TEXT");

				Twitter t = new Twitter(TwitterName, text);
				tList.add(t);
			}
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		finally {
			if(conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return tList;
	}

	public boolean create(Twitter t) {

		Connection conn = null;

		try {
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			String sql = "INSERT INTO TWITTER (NAME,TEXT) VALUES (?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, t.getTwitterName());
			pStmt.setString(2, t.getText());

			int result = pStmt.executeUpdate();

			if(result != 1) {
				return false;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally {
			if(conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					return false;
				}
			}
		}
		return true;
	}

}

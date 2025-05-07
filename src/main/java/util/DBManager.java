package util;

import java.sql.*;

public class DBManager implements AutoCloseable {
	
	private Connection connection = null;
	
	public DBManager() throws Exception {
		// WITHOUT POOL
		String user = "mysql";
		String password="prac";
		String db = "lab2s";
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection=DriverManager.getConnection("jdbc:mysql://localhost/"+db+"?serverTimezone=UTC&user="+user+"&password="+password);
	}
	
	public PreparedStatement prepareStatement(String query) throws SQLException{
		// Note that this is done using https://www.arquitecturajava.com/jdbc-prepared-statement-y-su-manejo/
		return connection.prepareStatement(query);
	}
	
	@Override
	public void close() throws SQLException{
		if (connection != null && !connection.isClosed()) {
            connection.close();
        }
	}
}
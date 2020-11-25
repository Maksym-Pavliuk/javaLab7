package postgreSQL;

import java.sql.DriverManager;
import java.sql.Connection;

import java.sql.SQLException;

public class Connector {

		private static final String DB_URL = "jdbc:postgresql://127.0.0.1:5432/JavaDB";
		private static final String USER = "java";
		private static final String PASS = "12345";
		
	public static Connection Connect() throws SQLException{
		Connection connection = null;
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			return connection;
		}
		catch(ClassNotFoundException e) {
			throw new SQLException(e.getMessage());
		}
	}
	
	public static void Disconnect(Connection connection) throws SQLException {
			connection.close();
	}
}

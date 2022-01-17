import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionFactory {
	
	public Connection recuperarConexao() throws SQLException{
		
		return  DriverManager.getConnection("jdbc:mysql://localhost/prova?useTimezone=true&serverTimezone=UTC","root","root");
	}
}
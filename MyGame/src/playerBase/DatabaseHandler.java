package playerBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseHandler extends Configs {
Connection dbConnetion;

public Connection getDbConnection() throws ClassNotFoundException, SQLException {
	String conectionString = "jdbc:mysql://" +  dbHost + ":" + dbPort + "/" + dbName + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			
	Class.forName("com.mysql.cj.jdbc.Driver");
	dbConnetion = DriverManager.getConnection(conectionString, dbUser, dbPass);
	return dbConnetion;
}

public void signUpUser(User user) {
	
	String insert = "INSERT INTO " + Const.USER_TABLE + "(" + Const.USERS_FIRSTNAME + ","+ Const.USERS_LASTNAME +","+Const.USERS_LOGIN + ","+
				Const.USERS_PASSWORD + "," + Const.USERS_COUNTRY + "," + Const.USERS_GENDER + ")" +
			"VALUES(?,?,?,?,?,?)";
	PreparedStatement prSt;
	try {
		prSt = getDbConnection().prepareStatement(insert);
		prSt.setString(1, user.getFirstName());
		prSt.setString(2, user.getLastName());
		prSt.setString(3, user.getLogin());
		prSt.setString(4, user.getPassword());
		prSt.setString(5, user.getCountry());
		prSt.setString(6, user.getGender());
		
		prSt.executeUpdate();
		System.out.println("Соединене с базой установлено");
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

public ResultSet getUser(User user) {
	ResultSet resSet = null;
	
	String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " +Const.USERS_LOGIN + "=? AND "+
			Const.USERS_PASSWORD + "=?";
	
	try {
		PreparedStatement prSt = getDbConnection().prepareStatement(select);
		
		prSt.setString(1, user.getLogin());
		prSt.setString(2, user.getPassword());
	
		
		resSet = prSt.executeQuery();
		System.out.println("Данные с базы получены");
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return resSet;
}
}

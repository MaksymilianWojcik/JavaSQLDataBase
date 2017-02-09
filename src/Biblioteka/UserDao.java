package Biblioteka;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDao {

	private MySQLConnector connect;

	public UserDao() {
		connect = MySQLConnector.getINSTANCE();
	}

	public void addUser(User user) {
		// id name lastname telephoneNumber
		String sql = "INSERT INTO user VALUES(?,?,?,?)";
		PreparedStatement state = connect.getPreparedStatement(sql);
		try {
			state.setNull(1, 0);
			state.setString(2, user.getName());
			state.setString(3, user.getLastname());
			state.setInt(4, user.getPhoneNumber());
			state.execute();
			state.closeOnCompletion();
			System.out.println("dodano uzytkownika");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void removeUser(int id) {
		String sql = "DELETE FROM user WHERE id=?";
		PreparedStatement state = connect.getPreparedStatement(sql);
		try {
			state.setInt(1, id);
			state.execute();
			state.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

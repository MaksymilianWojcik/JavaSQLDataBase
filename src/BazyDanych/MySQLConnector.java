package BazyDanych;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConnector {
	//SINGLETON - obejrzec 05:20 - 05:32 zeby ogarnac o co chodzi bo sie wylaczylem
	private static MySQLConnector instance;
	private final static String DBURL = "jdbc:mysql://5.135.218.27/maks";
	private final static String DBLOGIN = "root";
	private final static String DBPASSWORD = "10135886";
	
	private Connection conn;
	
	//tutaj tak z dupy tlumaczac jescze raz po co ten singleton
	//jak tworzymy nowe obiekty bazy danych to musimy sie laczyc za kazdym razem
	//z baza danych. A jak stworzymy singleton to mamy juz jedno stale polaczenie
	//i szybciej to dziala
	
	private MySQLConnector(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DBURL, DBLOGIN, DBPASSWORD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Polaczono z baza danych");
	}
	
	//NIE UZYWAC W WATKACH !!!!! Do watkow co prawda dopiero dojedziemy
	//no jeszce ni ebbylo, ale to taka przestroga
	public static MySQLConnector getINSTANCE(){
		if(instance == null){
			instance = new MySQLConnector();
		}
		
		return instance;
	}
	
	
	public Statement getStatement(){
		try {
			return conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return null;
	}
	
	public PreparedStatement getPreparedStatement(String sql){
		try {
			return conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}

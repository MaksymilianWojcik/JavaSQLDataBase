package Biblioteka;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookDao {
	
	private MySQLConnector connect;
	
	public BookDao(){
		connect = MySQLConnector.getINSTANCE();
	}
	
	public void addBook(Book book){
		//id title authour publishedYear
		String sql = "INSERT INTO books VALUES(?,?,?,?)";
		PreparedStatement state = connect.getPreparedStatement(sql);
		try {
			state.setNull(1,0);
			state.setString(2, book.getTitle());
			state.setString(3, book.getAuthor());
			state.setInt(4, book.getPublishedYear());
			state.execute();
			state.closeOnCompletion();
			System.out.println("dodano ksiazke");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

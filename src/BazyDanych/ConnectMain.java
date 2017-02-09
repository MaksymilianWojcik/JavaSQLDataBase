package BazyDanych;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectMain {
	
	//najpierw dajemy jdbc (bedziemy korzystac z silnika jdbc) ://ip serwera bazy danych (mamy to na phpmyadmin) / nazwa bazy danych
	private final static String DBURL = "jdbc:mysql://5.135.218.27/maks";
	private final static String DBLOGIN = "root";
	private final static String DBPASSWORD = "10135886"; 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Mamy zaimportowana biblioteke connectora, i teraz tworzymy polaczenie
		//z ta baza danych
		
		//connection importujemy z java.sql.Connection a nie tego pierwszego
		//Co ciekawe, samo napisanie tej uinstrukcji Connection~~~ jest podkreslone
		//bo wymaga obsluzenia wyjatku!! i teraz mozemy sobie dodac try atch albo throws
		try {
			//REFLEKSJE POZWALAJA ODWOLAC SIE DO KLASY BEZ TWORZENIA ICH INSTANCJI.
			//ta refleksja o ktorej mowa nizej: (to ta jedna linijka pod tym)
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(DBURL, DBLOGIN, DBPASSWORD);
			System.out.println("Polaczono");
			
			//cwiczenia. importujemy statement z java.sql
			//statement czyli komunikat
			Statement  state = conn.createStatement();
			ResultSet rs = state.executeQuery("SELECT * FROM Pracownicy WHERE placa='5500'");
			//id imie naziwsko placa tytul
			while(rs.next()){ //jezeli jest nastepna wartosci mamy true, niepotrzbeny tu zadne i++ itp;
				System.out.println("ID: " + rs.getInt("id"));
				System.out.println("Pracownik: " + rs.getString("imie") + " " + rs.getString("nazwisko"));
				System.out.println("Tytul: " + rs.getString("tytul"));
			}
			
			//dodajemy dane do tabeli:	//dodajemy srednik na koncu zapytania, bo tak konczymy zapytania sql. moze byc tez np ';)");		
			//state.execute("INSERT INTO Pracownicy VALUES(NULL, 'Tomek','Kowalski','2200','profesor');");

			//state.execute("UPDATE Pracownicy SET imie='Bartek' WHERE imie='Tomek';");
			
			//state.execute("DELETE FROM Pracownicy WHERE imie='Bartek';");
			
			
			
			//stworzylismy Singletona w klasie MySQLConnector
			// dzieki temu (co jest w singletonie) nie tworzymy nie wiadomo
			// ilu polaczen z baza przy tworzeniu obiektow
			//MySQLConnector baza = MySQLConnector.getINSTANCE();
			//dzieki temu usuwamy wsyzstko co tutaj bylo zwiazane z utworzeniem
			//polaczneia do bazy danych (zakomentowalem to w /*/*) i przepisujemy
			// do singletona
			
			//obiektu normlanie nie stworzymy, bo dalismy konstruktorowi private
			//MySQLConnector baza1 = new MySQLConnector();
			
			//mamy jesczcze cos takiego jeszce jak PreparedStatement
			//dzieki temu jak mamy jakies zlozone zpaytanie to tak jest wygodniej i przejrzysciej
			PreparedStatement prepareState = conn.prepareStatement("INSERT INTO Pracownicy VALUES(NULL,?,?,?,?);");
			prepareState.setString(1, "imie");
			prepareState.setString(2, "naziwsko");
			prepareState.setInt(3, 2200);
			prepareState.setString(4, "dr");
			prepareState.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//i tera zjzeli dziala, to wypisze ten napis. JEDNAK MIMO TO I TAK JEST BLAD
		//No suitable driver found, ale i tak wypisuje "Polacozno'". Dlatego teraz
		//musimy zrob ic refleksje, ktora dodalem do try! (Class.forName("com.mysql.jdbc.Driver");)
		//System.out.println("Polaczono"); przenosimy to na gore do try
		
		
	}

}

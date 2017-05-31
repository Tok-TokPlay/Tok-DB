import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class JDBCexam {
	Connection connection;
	Statement statement;
	ResultSet resultSet;
	
	String driverName = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/o2";
	String user = "root";
	String password = "js1112";
	
	public JDBCexam(String funcName){
		try{
			// �� �ε�
			Class.forName(driverName);
			System.out.println("�ε� ����");
			// �� ����
			connection = DriverManager.getConnection(url, user, password);
			System.out.println("���� ����");
			
			//Statement ���
			statement = connection.createStatement();
			System.out.println("statement ����");
			
			//insert ����
			if(funcName.equals("INSERT")){
				Scanner scan = new Scanner(System.in);
				String music;
				String singer;
				
				System.out.println("music���� �Է����ּ���");
				music = scan.nextLine();
				
				System.out.println("�������� �Է����ּ���");
				singer = scan.nextLine();
				
				String sql = "INSERT INTO toktok(music, singer) VALUES ('" + music + "', '" + singer + "')";
				statement.executeUpdate(sql);
				System.out.println("insert ����");
			}	
			
			//Delete ����
			else if(funcName.equals("DELETE")){
				Scanner scan = new Scanner(System.in);
				System.out.println("�� ���� Ű���� �����ҷ�?");
				String musicKey = scan.nextLine();
				String sql = "DELETE FROM toktok WHERE musicKey=" + musicKey + ";";
				statement.executeUpdate(sql);
				System.out.println(musicKey + " ���� ���� �����Ǿ����ϴ�.");
			}
			
			//select ����
			else if(funcName.equals("SELECT")){
				String sql = "SELECT * FROM toktok";
				resultSet = statement.executeQuery(sql);
				while(resultSet.next()){
					String musicKey = resultSet.getString("musicKey");
					String music = resultSet.getString("music");
					String singer = resultSet.getString("singer");
					System.out.print("�뷡 Ű�� ; " + musicKey);
					System.out.print("\t�뷡 ���� ; " + music);
					System.out.println("\t���� �� ; " + singer);
				}
			}
			
			
		}catch (ClassNotFoundException e){
			System.out.println("[�ε� ����]\n" + e.getStackTrace());
		}
		catch (SQLException e){
			System.out.println("[���� ����]\n" +  e.getStackTrace());
		}
		catch(Exception e){
			System.out.println(e.toString());
		}
	}
	
	
	public void closeDatabase()
	{
		try{
			if( connection != null ){
				connection.close();
			}
			
			if( statement != null ){
				statement.close();
			}
			
			if( resultSet != null ){
				resultSet.close();
			}
		}catch (SQLException e){
			System.out.println("[�ݱ� ����]\n" +  e.getStackTrace());
		}
	}
}

import java.util.Scanner;

//update는 수정할 일이 없어서 구현하지 않았음
public class main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("기능 뭐쓸거야 개자시가");
		System.out.print("INSERT");
		System.out.print("\tSELECT");
		System.out.println("\tDELETE");	
		System.out.println("이 4개중에 골라라");
			
		new JDBCexam(scan.nextLine());
		scan.close();
	}
}

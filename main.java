import java.util.Scanner;

//update�� ������ ���� ��� �������� �ʾ���
public class main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("��� �����ž� ���ڽð�");
		System.out.print("INSERT");
		System.out.print("\tSELECT");
		System.out.println("\tDELETE");	
		System.out.println("�� 4���߿� ����");
			
		new JDBCexam(scan.nextLine());
		scan.close();
	}
}

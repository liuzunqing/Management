package mainfunction;
import jdbc.Login;
import jdbc.SQLFunction;

import java.util.Scanner;

public class LoginFunction {
	public static boolean Login(String flag) {
		Scanner sc = new Scanner(System.in);
		Login user = new Login();
		
		System.out.println("�˺ţ�");
		user.setAccount(sc.nextLine());
		System.out.println("���룺");
		user.setPassword(sc.nextLine());
//		sc.close();
		
		user.setFlag(flag);
		if(SQLFunction.login(user)) {
			mainfunction.nowAccount = user.getAccount();
			return true;
		}
//		System.out.println("��½ʧ�ܣ�");
		return false;
	}
}

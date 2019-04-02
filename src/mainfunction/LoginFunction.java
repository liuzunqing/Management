package mainfunction;
import jdbc.Login;
import jdbc.SQLFunction;

import java.util.Scanner;

public class LoginFunction {
	public static boolean Login(String flag) {
		Scanner sc = new Scanner(System.in);
		Login user = new Login();
		
		System.out.println("ÕËºÅ£º");
		user.setAccount(sc.nextLine());
		System.out.println("ÃÜÂë£º");
		user.setPassword(sc.nextLine());
//		sc.close();
		
		user.setFlag(flag);
		if(SQLFunction.login(user)) {
			mainfunction.nowAccount = user.getAccount();
			return true;
		}
//		System.out.println("µÇÂ½Ê§°Ü£¡");
		return false;
	}
}

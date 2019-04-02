package mainfunction;

import java.util.Scanner;

public class mainfunction {

	static String nowAccount = "";

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner sc = new Scanner(System.in);
		String str = "";
		boolean flag = true;
		while (flag) {
			System.out.println("请选择登陆身份（序号）：\n1.教师\t2.学生\t3.退出");
			str = sc.nextLine();
			switch (str) {
			case "1":
				System.out.println("您选择的是教师！");
				if (LoginFunction.Login("Teacher")) {
					teacherView();
					flag = false;
					System.out.println("谢谢使用！");
				} else {
					System.out.println("登陆失败！请重试！");
				}
				break;
			case "2":
				System.out.println("您选择的是学生！");
				if (LoginFunction.Login("Student")) {
					studentView();
					flag = false;
					System.out.println("谢谢使用！");
				} else {
					System.out.println("登陆失败！请重试！");
				}
				break;
			case "3":
				System.out.println("谢谢使用！");
				flag = false;
				break;
			default:
				System.out.println("错误的选项！请重新选择！");
			}
		}
		sc.close();
	}

	public static void studentView() {
		System.out.println(nowAccount + " ，欢迎使用！");
		Scanner sc = new Scanner(System.in);
		String str = "";
		boolean flag = true;
		while (flag) {
			System.out
					.println("请选择需要的功能：\n1.个人信息\n2.成绩查询\n3.课程表\n4.选修课报名\n5.退出");
			str = sc.nextLine();
			switch (str) {
			case "1":
				StudentFunction.studentInfo();
				break;
			case "2":
				StudentFunction.gradeQuery();
				break;
			case "3":
				StudentFunction.courseInfo();
				break;
			case "4":
				StudentFunction.courseSignIn();
				break;
			case "5":
				flag = false;
				break;
			default:
				System.out.println("错误的选项！请重新选择！");
			}
		}
	}

	public static void teacherView() {
		System.out.println(nowAccount + " ，欢迎使用！");
		Scanner sc = new Scanner(System.in);
		String str = "";
		boolean flag = true;
		while (flag) {
			System.out.println("请选择需要的功能：\n1.学生信息管理\n2.学生成绩查询\n3.学生账号管理\n4.退出");
			str = sc.nextLine();
			switch (str) {
			case "1":
				TeacherFunction.studentInffoManagement();
				break;
			case "2":
				TeacherFunction.studentGradeQuery();
				break;
			case "3":
				TeacherFunction.studentAccountManagement();
				break;
			case "4":
				flag = false;
				break;
			default:
				System.out.println("错误的选项！请重新选择！");
			}
		}

	}
}

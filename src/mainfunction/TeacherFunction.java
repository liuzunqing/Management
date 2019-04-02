package mainfunction;

import java.util.Scanner;
import jdbc.Student;
import jdbc.Login;
import jdbc.SQLFunction;
import jdbc.Grade;
import java.util.ArrayList;
import java.util.List;

public class TeacherFunction {
	// 学生信息管理
	public static void studentInffoManagement() {
		Scanner sc = new Scanner(System.in);
		String str = "";
		boolean flag = true;
		while (flag) {
			System.out
					.println("请选择需要的功能：\n1.查询学生信息（按学号）\n2.查询学生信息（按姓名）\n3.添加学生信息\n4.删除学生信息\n5.修改学生信息\n6.返回");
			str = sc.nextLine();
			switch (str) {
			case "1":
				queryStudentInfoBySNO();
				break;
			case "2":
				queryStudentInfoBySName();
				break;
			case "3":
				addStudentInfo();
				break;
			case "4":
				deleteStudentInfo();
				break;
			case "5":
				updateStudentInfo();
				break;
			case "6":
				flag = false;
				break;
			default:
				System.out.println("错误的选项！请重新选择！");
			}
		}
		// sc.close();
	}

	// 学生成绩查询
	public static void studentGradeQuery() {
		Scanner sc = new Scanner(System.in);
		String str = "";
		boolean flag = true;
		while (flag) {
			System.out.println("请选择需要的功能：\n1.查询学生成绩（按学号）\n2.查询学生成绩（按姓名）\n3.返回");
			str = sc.nextLine();
			switch (str) {
			case "1":
				queryStudentGradeBySNO();
				break;
			case "2":
				queryStudentGradeBySName();
				break;
			case "3":
				flag = false;
				break;
			default:
				System.out.println("错误的选项！请重新选择！");
			}
		}
		// sc.close();
	}

	// 学生账号管理
	public static void studentAccountManagement() {
		Scanner sc = new Scanner(System.in);
		String str = "";
		boolean flag = true;
		while (flag) {
			System.out
					.println("请选择需要的功能：\n1.添加学生账号\n2.删除学生账号\n3.修改学生账号密码\n4.返回");
			str = sc.nextLine();
			switch (str) {
			case "1":
				addStudentAccount();
				break;
			case "2":
				deleteStudentAccount();
				break;
			case "3":
				updateStudentPassword();
				break;
			case "4":
				flag = false;
				break;
			default:
				System.out.println("错误的选项！请重新选择！");
			}
		}
		// sc.close();
	}

	// 查询学生信息（按学号）
	public static void queryStudentInfoBySNO() {
		Scanner sc = new Scanner(System.in);
		Student stu = new Student();
		System.out.println("输入学生学号：");
		stu.setSNO(sc.nextLine());

		Student retStu = new Student();
		retStu = SQLFunction.queryStudentInfoBySNO(stu);
		if (retStu == null) {
			System.out.println("未找到该生信息！");
		} else {
			System.out.println("学号：" + retStu.getSNO());
			System.out.println("姓名：" + retStu.getSName());
			System.out.println("出生日期：" + retStu.getBirthday());
			System.out.println("年龄：" + retStu.getAge());
			System.out.println("性别：" + retStu.getSex());
			System.out.println("政治面貌：" + retStu.getIdentity());
			System.out.println("入学时间：" + retStu.getSchool());
			System.out.println("个人简历：" + retStu.getIntroduction());
			System.out.println("照片：" + retStu.getPhoto());
			System.out.println("家庭住址：" + retStu.getAddress());
			System.out.println("邮编：" + retStu.getPostnum());
			System.out.println("所学专业：" + retStu.getMajor());
		}
		// sc.close();
	}

	// 查询学生信息（按姓名）
	public static void queryStudentInfoBySName() {
		Scanner sc = new Scanner(System.in);
		Student stu = new Student();
		System.out.println("输入学生姓名：");
		stu.setSName(sc.nextLine());
		// sc.close();

		List<Student> list = new ArrayList<Student>();
		list = SQLFunction.queryStudentInfoBySName(stu);
		if (list == null) {
			System.out.println("未找到学生信息！");
		} else {
			System.out
					.println("学号\t姓名\t出生日期\t年龄\t性别\t政治面貌\t入学时间\t个人简历\t照片\t家庭住址\t邮编\t所学专业");
			int i = 0;
			Student newStu = new Student();
			while (i < list.size()) {
				newStu = list.get(i);
				System.out.println(newStu.getSNO() + "\t" + newStu.getSName()
						+ "\t" + newStu.getBirthday() + "\t" + newStu.getAge()
						+ "\t" + newStu.getSex() + "\t" + newStu.getIdentity()
						+ "\t" + newStu.getSchool() + "\t"
						+ newStu.getIntroduction() + "\t" + newStu.getPhoto()
						+ "\t" + newStu.getAddress() + "\t"
						+ newStu.getPostnum() + "\t" + newStu.getMajor());
				i++;
			}
		}
	}

	// 添加学生信息
	public static void addStudentInfo() {
		Scanner sc = new Scanner(System.in);
		Student stu = new Student();

		System.out.println("输入以下信息：\n学号：");
		stu.setSNO(sc.nextLine());
		System.out.println("姓名：");
		stu.setSName(sc.nextLine());
		System.out.println("出生日期：");
		stu.setBirthday(sc.nextLine());
		System.out.println("年龄：");
		stu.setAge(Integer.parseInt(sc.nextLine()));
		System.out.println("性别：");
		stu.setSex(sc.nextLine());
		System.out.println("政治面貌：");
		stu.setIdentity(sc.nextLine());
		System.out.println("入学时间：");
		stu.setSchool(sc.nextLine());
		System.out.println("个人简历：");
		stu.setIntroduction(sc.nextLine());
		System.out.println("照片：");
		stu.setPhoto(sc.nextLine());
		System.out.println("家庭住址：");
		stu.setAddress(sc.nextLine());
		System.out.println("邮编：");
		stu.setPostnum(sc.nextLine());
		System.out.println("所学专业：");
		stu.setMajor(sc.nextLine());
		// sc.close();
		if (SQLFunction.addStudentInfo(stu)) {
			System.out.println("添加学生信息成功！");
		} else {
			System.out.println("添加学生信息失败！");
		}
	}

	// 删除学生信息
	public static void deleteStudentInfo() {
		Scanner sc = new Scanner(System.in);
		Student stu = new Student();
		System.out.println("输入需要删除的学生学号：");
		stu.setSNO(sc.nextLine());
		// sc.close();

		if (SQLFunction.deleteStudentInfo(stu)) {
			System.out.println("删除学生信息成功！");
		} else {
			System.out.println("删除学生信息失败！");
		}
	}

	// 修改学生信息
	public static void updateStudentInfo() {
		Scanner sc = new Scanner(System.in);
		Student stu = new Student();

		System.out.println("输入需要修改的学生信息的学生学号：");
		stu.setSNO(sc.nextLine());
		System.out.println("输入以下信息：\n姓名：");
		stu.setSName(sc.nextLine());
		System.out.println("出生日期：");
		stu.setBirthday(sc.nextLine());
		System.out.println("年龄：");
		stu.setAge(Integer.parseInt(sc.nextLine()));
		System.out.println("性别：");
		stu.setSex(sc.nextLine());
		System.out.println("政治面貌：");
		stu.setIdentity(sc.nextLine());
		System.out.println("入学时间：");
		stu.setSchool(sc.nextLine());
		System.out.println("个人简历：");
		stu.setIntroduction(sc.nextLine());
		System.out.println("照片：");
		stu.setPhoto(sc.nextLine());
		System.out.println("家庭住址：");
		stu.setAddress(sc.nextLine());
		System.out.println("邮编：");
		stu.setPostnum(sc.nextLine());
		System.out.println("所学专业：");
		stu.setMajor(sc.nextLine());
		// sc.close();
		if (SQLFunction.updateStudentInfo(stu)) {
			System.out.println("修改学生信息成功！");
		} else {
			System.out.println("修改学生信息失败！");
		}
	}

	// 查询学生成绩（按学号）
	public static void queryStudentGradeBySNO() {
		Scanner sc = new Scanner(System.in);
		Student stu = new Student();
		System.out.println("输入学生学号：");
		stu.setSNO(sc.nextLine());
		// sc.close();

		List<Grade> list = new ArrayList<Grade>();
		list = SQLFunction.queryGradeBySNO(stu);
		if (list == null) {
			System.out.println("未找到学生成绩信息！");
		} else {
			System.out.println("学期\t学号\t姓名\t课程号\t课程名\t成绩");
			int i = 0;
			Grade grade = new Grade();
			while (i < list.size()) {
				grade = list.get(i);
				System.out.println(grade.getTerm() + "\t" + grade.getSNO()
						+ "\t" + grade.getSName() + "\t" + grade.getCNO()
						+ "\t" + grade.getCName() + "\t" + grade.getGrade());
				i++;
			}
		}
	}

	// 查询学生成绩（按姓名）
	public static void queryStudentGradeBySName() {
		Scanner sc = new Scanner(System.in);
		Student stu = new Student();
		System.out.println("输入学生姓名：");
		stu.setSName(sc.nextLine());
		// sc.close();

		List<Grade> list = new ArrayList<Grade>();
		list = SQLFunction.queryGradeBySName(stu);
		if (list == null) {
			System.out.println("未找到学生成绩信息！");
		} else {
			System.out.println("学期\t学号\t姓名\t课程号\t课程名\t成绩");
			int i = 0;
			Grade grade = new Grade();
			while (i < list.size()) {
				grade = list.get(i);
				System.out.println(grade.getTerm() + "\t" + grade.getSNO()
						+ "\t" + grade.getSName() + "\t" + grade.getCNO()
						+ "\t" + grade.getCName() + "\t" + grade.getGrade());
				i++;
			}
		}
	}

	// 添加学生账户
	public static void addStudentAccount() {
		Scanner sc = new Scanner(System.in);
		Login login = new Login();
		System.out.println("输入学生账户:");
		login.setAccount(sc.nextLine());
		System.out.println("输入学生账户密码：");
		login.setPassword(sc.nextLine());
		// sc.close();
		login.setFlag("Student");

		if (SQLFunction.addStudentAccount(login)) {
			System.out.println("添加学生账户成功！");
		} else {
			System.out.println("添加学生账户失败！");
		}
	}

	// 删除学生账户
	public static void deleteStudentAccount() {
		Scanner sc = new Scanner(System.in);
		Login login = new Login();
		System.out.println("输入学生账户:");
		login.setAccount(sc.nextLine());
		// sc.close();
		login.setFlag("Student");

		if (SQLFunction.deleteStudentAccount(login)) {
			System.out.println("删除学生账户成功！");
		} else {
			System.out.println("删除学生账户失败！");
		}
	}

	// 修改学生账户密码
	public static void updateStudentPassword() {
		Scanner sc = new Scanner(System.in);
		Login login = new Login();
		System.out.println("输入学生账户:");
		login.setAccount(sc.nextLine());
		System.out.println("输入学生账户新密码：");
		login.setPassword(sc.nextLine());
		// sc.close();
		login.setFlag("Student");

		if (SQLFunction.updateStudentAccount(login)) {
			System.out.println("更改学生账户密码成功！");
		} else {
			System.out.println("更改学生账户密码失败！");
		}
	}

}

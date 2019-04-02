package mainfunction;

import jdbc.Student;
import jdbc.SQLFunction;
import jdbc.Grade;
import jdbc.Course;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentFunction {
	// 个人信息
	public static void studentInfo() {
		Scanner sc = new Scanner(System.in);
		String str = "";
		boolean flag = true;
		while (flag) {
			System.out.println("请选择需要的功能：\n1.查看个人信息\n2.修改个人信息\n3.返回");
			str = sc.nextLine();
			switch (str) {
			case "1":
				queryStudentInfo();
				break;
			case "2":
				updateStudentInfo();
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

	// 成绩查询
	public static void gradeQuery() {
		Student stu = new Student();
		stu.setSNO(mainfunction.nowAccount);

		List<Grade> list = new ArrayList<Grade>();
		list = SQLFunction.queryGradeBySNO(stu);
		if (list == null) {
			System.out.println("未找到成绩信息！");
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

	// 课程表
	public static void courseInfo() {
		Student stu = new Student();
		stu.setSNO(mainfunction.nowAccount);

		List<Course> list = new ArrayList<Course>();
		list = SQLFunction.queryCourse(stu);
		if (list == null) {
			System.out.println("未找到课程信息！");
		} else {
			System.out.println("课程号\t课程名\t学分\t课程类型");
			int i = 0;
			Course cou = new Course();
			while (i < list.size()) {
				cou = list.get(i);
				System.out.println(cou.getCNO() + "\t" + cou.getCName() + "\t"
						+ cou.getCredit() + "\t" + cou.getType());
				i++;
			}
		}
	}

	// 选修课报名
	public static void courseSignIn() {
		System.out.println("选修课列表如下，请根据提示报名选修课：");

		List<Course> list = new ArrayList<Course>();
		list = SQLFunction.queryCourseChoice();
		if (list == null) {
			System.out.println("未找到选修课信息！");
		} else {
			System.out.println("课程号\t课程名\t学分\t课程类型");
			int i = 0;
			Course cou = new Course();
			while (i < list.size()) {
				cou = list.get(i);
				System.out.println(cou.getCNO() + "\t" + cou.getCName() + "\t"
						+ cou.getCredit() + "\t" + cou.getType());
				i++;
			}
		}

		Scanner sc = new Scanner(System.in);
		Student stuInfo = new Student();
		Student retStu = new Student();
		Course couInfo = new Course();
		Course retCou = new Course();
		System.out.println("输入报名的选修课课程号：");
		couInfo.setCNO(sc.nextLine());
		// sc.close();
		stuInfo.setSNO(mainfunction.nowAccount);

		System.out.println("处理中...请稍等...");

		retCou = SQLFunction.queryCourseInfo(couInfo);
		retStu = SQLFunction.queryStudentInfoBySNO(stuInfo);
		if (retCou == null || retStu == null) {
			System.out.println("缺少相关信息！请重试！");
		}
		if (SQLFunction.updateGrade(retStu, retCou)) {
			System.out.println("报名选修课成功！");
		} else {
			System.out.println("报名选修课失败！请检查是否已经报名该课程！");
		}

	}

	// 查看个人信息
	public static void queryStudentInfo() {
		Student stu = new Student();
		stu.setSNO(mainfunction.nowAccount);

		Student retStu = new Student();
		retStu = SQLFunction.queryStudentInfoBySNO(stu);
		if (retStu == null) {
			System.out.println("未找到信息！");
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
	}

	// 修改个人信息
	public static void updateStudentInfo() {
		Scanner sc = new Scanner(System.in);
		Student stu = new Student();

		stu.setSNO(mainfunction.nowAccount);
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
			System.out.println("修改个人信息成功！");
		} else {
			System.out.println("修改个人信息失败！");
		}
	}

}

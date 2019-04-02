package mainfunction;

import jdbc.Student;
import jdbc.SQLFunction;
import jdbc.Grade;
import jdbc.Course;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentFunction {
	// ������Ϣ
	public static void studentInfo() {
		Scanner sc = new Scanner(System.in);
		String str = "";
		boolean flag = true;
		while (flag) {
			System.out.println("��ѡ����Ҫ�Ĺ��ܣ�\n1.�鿴������Ϣ\n2.�޸ĸ�����Ϣ\n3.����");
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
				System.out.println("�����ѡ�������ѡ��");
			}
		}
		// sc.close();
	}

	// �ɼ���ѯ
	public static void gradeQuery() {
		Student stu = new Student();
		stu.setSNO(mainfunction.nowAccount);

		List<Grade> list = new ArrayList<Grade>();
		list = SQLFunction.queryGradeBySNO(stu);
		if (list == null) {
			System.out.println("δ�ҵ��ɼ���Ϣ��");
		} else {
			System.out.println("ѧ��\tѧ��\t����\t�γ̺�\t�γ���\t�ɼ�");
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

	// �γ̱�
	public static void courseInfo() {
		Student stu = new Student();
		stu.setSNO(mainfunction.nowAccount);

		List<Course> list = new ArrayList<Course>();
		list = SQLFunction.queryCourse(stu);
		if (list == null) {
			System.out.println("δ�ҵ��γ���Ϣ��");
		} else {
			System.out.println("�γ̺�\t�γ���\tѧ��\t�γ�����");
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

	// ѡ�޿α���
	public static void courseSignIn() {
		System.out.println("ѡ�޿��б����£��������ʾ����ѡ�޿Σ�");

		List<Course> list = new ArrayList<Course>();
		list = SQLFunction.queryCourseChoice();
		if (list == null) {
			System.out.println("δ�ҵ�ѡ�޿���Ϣ��");
		} else {
			System.out.println("�γ̺�\t�γ���\tѧ��\t�γ�����");
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
		System.out.println("���뱨����ѡ�޿ογ̺ţ�");
		couInfo.setCNO(sc.nextLine());
		// sc.close();
		stuInfo.setSNO(mainfunction.nowAccount);

		System.out.println("������...���Ե�...");

		retCou = SQLFunction.queryCourseInfo(couInfo);
		retStu = SQLFunction.queryStudentInfoBySNO(stuInfo);
		if (retCou == null || retStu == null) {
			System.out.println("ȱ�������Ϣ�������ԣ�");
		}
		if (SQLFunction.updateGrade(retStu, retCou)) {
			System.out.println("����ѡ�޿γɹ���");
		} else {
			System.out.println("����ѡ�޿�ʧ�ܣ������Ƿ��Ѿ������ÿγ̣�");
		}

	}

	// �鿴������Ϣ
	public static void queryStudentInfo() {
		Student stu = new Student();
		stu.setSNO(mainfunction.nowAccount);

		Student retStu = new Student();
		retStu = SQLFunction.queryStudentInfoBySNO(stu);
		if (retStu == null) {
			System.out.println("δ�ҵ���Ϣ��");
		} else {
			System.out.println("ѧ�ţ�" + retStu.getSNO());
			System.out.println("������" + retStu.getSName());
			System.out.println("�������ڣ�" + retStu.getBirthday());
			System.out.println("���䣺" + retStu.getAge());
			System.out.println("�Ա�" + retStu.getSex());
			System.out.println("������ò��" + retStu.getIdentity());
			System.out.println("��ѧʱ�䣺" + retStu.getSchool());
			System.out.println("���˼�����" + retStu.getIntroduction());
			System.out.println("��Ƭ��" + retStu.getPhoto());
			System.out.println("��ͥסַ��" + retStu.getAddress());
			System.out.println("�ʱࣺ" + retStu.getPostnum());
			System.out.println("��ѧרҵ��" + retStu.getMajor());
		}
	}

	// �޸ĸ�����Ϣ
	public static void updateStudentInfo() {
		Scanner sc = new Scanner(System.in);
		Student stu = new Student();

		stu.setSNO(mainfunction.nowAccount);
		System.out.println("����������Ϣ��\n������");
		stu.setSName(sc.nextLine());
		System.out.println("�������ڣ�");
		stu.setBirthday(sc.nextLine());
		System.out.println("���䣺");
		stu.setAge(Integer.parseInt(sc.nextLine()));
		System.out.println("�Ա�");
		stu.setSex(sc.nextLine());
		System.out.println("������ò��");
		stu.setIdentity(sc.nextLine());
		System.out.println("��ѧʱ�䣺");
		stu.setSchool(sc.nextLine());
		System.out.println("���˼�����");
		stu.setIntroduction(sc.nextLine());
		System.out.println("��Ƭ��");
		stu.setPhoto(sc.nextLine());
		System.out.println("��ͥסַ��");
		stu.setAddress(sc.nextLine());
		System.out.println("�ʱࣺ");
		stu.setPostnum(sc.nextLine());
		System.out.println("��ѧרҵ��");
		stu.setMajor(sc.nextLine());
		// sc.close();
		if (SQLFunction.updateStudentInfo(stu)) {
			System.out.println("�޸ĸ�����Ϣ�ɹ���");
		} else {
			System.out.println("�޸ĸ�����Ϣʧ�ܣ�");
		}
	}

}

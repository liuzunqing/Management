package mainfunction;

import java.util.Scanner;
import jdbc.Student;
import jdbc.Login;
import jdbc.SQLFunction;
import jdbc.Grade;
import java.util.ArrayList;
import java.util.List;

public class TeacherFunction {
	// ѧ����Ϣ����
	public static void studentInffoManagement() {
		Scanner sc = new Scanner(System.in);
		String str = "";
		boolean flag = true;
		while (flag) {
			System.out
					.println("��ѡ����Ҫ�Ĺ��ܣ�\n1.��ѯѧ����Ϣ����ѧ�ţ�\n2.��ѯѧ����Ϣ����������\n3.���ѧ����Ϣ\n4.ɾ��ѧ����Ϣ\n5.�޸�ѧ����Ϣ\n6.����");
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
				System.out.println("�����ѡ�������ѡ��");
			}
		}
		// sc.close();
	}

	// ѧ���ɼ���ѯ
	public static void studentGradeQuery() {
		Scanner sc = new Scanner(System.in);
		String str = "";
		boolean flag = true;
		while (flag) {
			System.out.println("��ѡ����Ҫ�Ĺ��ܣ�\n1.��ѯѧ���ɼ�����ѧ�ţ�\n2.��ѯѧ���ɼ�����������\n3.����");
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
				System.out.println("�����ѡ�������ѡ��");
			}
		}
		// sc.close();
	}

	// ѧ���˺Ź���
	public static void studentAccountManagement() {
		Scanner sc = new Scanner(System.in);
		String str = "";
		boolean flag = true;
		while (flag) {
			System.out
					.println("��ѡ����Ҫ�Ĺ��ܣ�\n1.���ѧ���˺�\n2.ɾ��ѧ���˺�\n3.�޸�ѧ���˺�����\n4.����");
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
				System.out.println("�����ѡ�������ѡ��");
			}
		}
		// sc.close();
	}

	// ��ѯѧ����Ϣ����ѧ�ţ�
	public static void queryStudentInfoBySNO() {
		Scanner sc = new Scanner(System.in);
		Student stu = new Student();
		System.out.println("����ѧ��ѧ�ţ�");
		stu.setSNO(sc.nextLine());

		Student retStu = new Student();
		retStu = SQLFunction.queryStudentInfoBySNO(stu);
		if (retStu == null) {
			System.out.println("δ�ҵ�������Ϣ��");
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
		// sc.close();
	}

	// ��ѯѧ����Ϣ����������
	public static void queryStudentInfoBySName() {
		Scanner sc = new Scanner(System.in);
		Student stu = new Student();
		System.out.println("����ѧ��������");
		stu.setSName(sc.nextLine());
		// sc.close();

		List<Student> list = new ArrayList<Student>();
		list = SQLFunction.queryStudentInfoBySName(stu);
		if (list == null) {
			System.out.println("δ�ҵ�ѧ����Ϣ��");
		} else {
			System.out
					.println("ѧ��\t����\t��������\t����\t�Ա�\t������ò\t��ѧʱ��\t���˼���\t��Ƭ\t��ͥסַ\t�ʱ�\t��ѧרҵ");
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

	// ���ѧ����Ϣ
	public static void addStudentInfo() {
		Scanner sc = new Scanner(System.in);
		Student stu = new Student();

		System.out.println("����������Ϣ��\nѧ�ţ�");
		stu.setSNO(sc.nextLine());
		System.out.println("������");
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
		if (SQLFunction.addStudentInfo(stu)) {
			System.out.println("���ѧ����Ϣ�ɹ���");
		} else {
			System.out.println("���ѧ����Ϣʧ�ܣ�");
		}
	}

	// ɾ��ѧ����Ϣ
	public static void deleteStudentInfo() {
		Scanner sc = new Scanner(System.in);
		Student stu = new Student();
		System.out.println("������Ҫɾ����ѧ��ѧ�ţ�");
		stu.setSNO(sc.nextLine());
		// sc.close();

		if (SQLFunction.deleteStudentInfo(stu)) {
			System.out.println("ɾ��ѧ����Ϣ�ɹ���");
		} else {
			System.out.println("ɾ��ѧ����Ϣʧ�ܣ�");
		}
	}

	// �޸�ѧ����Ϣ
	public static void updateStudentInfo() {
		Scanner sc = new Scanner(System.in);
		Student stu = new Student();

		System.out.println("������Ҫ�޸ĵ�ѧ����Ϣ��ѧ��ѧ�ţ�");
		stu.setSNO(sc.nextLine());
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
			System.out.println("�޸�ѧ����Ϣ�ɹ���");
		} else {
			System.out.println("�޸�ѧ����Ϣʧ�ܣ�");
		}
	}

	// ��ѯѧ���ɼ�����ѧ�ţ�
	public static void queryStudentGradeBySNO() {
		Scanner sc = new Scanner(System.in);
		Student stu = new Student();
		System.out.println("����ѧ��ѧ�ţ�");
		stu.setSNO(sc.nextLine());
		// sc.close();

		List<Grade> list = new ArrayList<Grade>();
		list = SQLFunction.queryGradeBySNO(stu);
		if (list == null) {
			System.out.println("δ�ҵ�ѧ���ɼ���Ϣ��");
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

	// ��ѯѧ���ɼ�����������
	public static void queryStudentGradeBySName() {
		Scanner sc = new Scanner(System.in);
		Student stu = new Student();
		System.out.println("����ѧ��������");
		stu.setSName(sc.nextLine());
		// sc.close();

		List<Grade> list = new ArrayList<Grade>();
		list = SQLFunction.queryGradeBySName(stu);
		if (list == null) {
			System.out.println("δ�ҵ�ѧ���ɼ���Ϣ��");
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

	// ���ѧ���˻�
	public static void addStudentAccount() {
		Scanner sc = new Scanner(System.in);
		Login login = new Login();
		System.out.println("����ѧ���˻�:");
		login.setAccount(sc.nextLine());
		System.out.println("����ѧ���˻����룺");
		login.setPassword(sc.nextLine());
		// sc.close();
		login.setFlag("Student");

		if (SQLFunction.addStudentAccount(login)) {
			System.out.println("���ѧ���˻��ɹ���");
		} else {
			System.out.println("���ѧ���˻�ʧ�ܣ�");
		}
	}

	// ɾ��ѧ���˻�
	public static void deleteStudentAccount() {
		Scanner sc = new Scanner(System.in);
		Login login = new Login();
		System.out.println("����ѧ���˻�:");
		login.setAccount(sc.nextLine());
		// sc.close();
		login.setFlag("Student");

		if (SQLFunction.deleteStudentAccount(login)) {
			System.out.println("ɾ��ѧ���˻��ɹ���");
		} else {
			System.out.println("ɾ��ѧ���˻�ʧ�ܣ�");
		}
	}

	// �޸�ѧ���˻�����
	public static void updateStudentPassword() {
		Scanner sc = new Scanner(System.in);
		Login login = new Login();
		System.out.println("����ѧ���˻�:");
		login.setAccount(sc.nextLine());
		System.out.println("����ѧ���˻������룺");
		login.setPassword(sc.nextLine());
		// sc.close();
		login.setFlag("Student");

		if (SQLFunction.updateStudentAccount(login)) {
			System.out.println("����ѧ���˻�����ɹ���");
		} else {
			System.out.println("����ѧ���˻�����ʧ�ܣ�");
		}
	}

}

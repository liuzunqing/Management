package mainfunction;

import java.util.Scanner;

public class mainfunction {

	static String nowAccount = "";

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Scanner sc = new Scanner(System.in);
		String str = "";
		boolean flag = true;
		while (flag) {
			System.out.println("��ѡ���½��ݣ���ţ���\n1.��ʦ\t2.ѧ��\t3.�˳�");
			str = sc.nextLine();
			switch (str) {
			case "1":
				System.out.println("��ѡ����ǽ�ʦ��");
				if (LoginFunction.Login("Teacher")) {
					teacherView();
					flag = false;
					System.out.println("ллʹ�ã�");
				} else {
					System.out.println("��½ʧ�ܣ������ԣ�");
				}
				break;
			case "2":
				System.out.println("��ѡ�����ѧ����");
				if (LoginFunction.Login("Student")) {
					studentView();
					flag = false;
					System.out.println("ллʹ�ã�");
				} else {
					System.out.println("��½ʧ�ܣ������ԣ�");
				}
				break;
			case "3":
				System.out.println("ллʹ�ã�");
				flag = false;
				break;
			default:
				System.out.println("�����ѡ�������ѡ��");
			}
		}
		sc.close();
	}

	public static void studentView() {
		System.out.println(nowAccount + " ����ӭʹ�ã�");
		Scanner sc = new Scanner(System.in);
		String str = "";
		boolean flag = true;
		while (flag) {
			System.out
					.println("��ѡ����Ҫ�Ĺ��ܣ�\n1.������Ϣ\n2.�ɼ���ѯ\n3.�γ̱�\n4.ѡ�޿α���\n5.�˳�");
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
				System.out.println("�����ѡ�������ѡ��");
			}
		}
	}

	public static void teacherView() {
		System.out.println(nowAccount + " ����ӭʹ�ã�");
		Scanner sc = new Scanner(System.in);
		String str = "";
		boolean flag = true;
		while (flag) {
			System.out.println("��ѡ����Ҫ�Ĺ��ܣ�\n1.ѧ����Ϣ����\n2.ѧ���ɼ���ѯ\n3.ѧ���˺Ź���\n4.�˳�");
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
				System.out.println("�����ѡ�������ѡ��");
			}
		}

	}
}

package jdbc;

public class Teacher {
	private String TNO;//��ʦ����
	private String TName;//��ʦ��
	
	//����ֵ
	public void setTNO(String set_TNO) {
		this.TNO = set_TNO;
	}
	public void setTName(String set_TName) {
		this.TName = set_TName;
	}
	
	//��ȡֵ
	public String getTNO() {
		return TNO;
	}
	public String getTName() {
		return TName;
	}
	
}

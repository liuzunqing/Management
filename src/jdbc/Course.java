package jdbc;

public class Course {
	private String CNO;//�γ̺�
	private String CName;//�γ���
	private int Credit;//ѧ��
	private String Type;//�γ�����
	
	//����ֵ
	public void setCNO(String set_CNO) {
		this.CNO = set_CNO;
	}
	public void setCName(String set_CName) {
		this.CName = set_CName;
	}
	public void setCredit(int set_Credit) {
		this.Credit = set_Credit;
	}
	public void setType(String set_Type) {
		this.Type = set_Type;
	}
	
	//��ȡֵ
	public String getCNO() {
		return CNO;
	}
	public String getCName() {
		return CName;
	}
	public int getCredit() {
		return Credit;
	}
	public String getType() {
		return Type;
	}
	
}

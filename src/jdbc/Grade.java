package jdbc;

public class Grade {
	private String Term;//ѧ��
	private String SNO;//ѧ��
	private String SName;//ѧ������
	private String CNO;//�γ̺�
	private String CName;//�γ���
	private int Grade;//�ɼ�
	
	//����ֵ
	public void setTerm(String set_Term) {
		this.Term = set_Term;
	}
	public void setSNO(String set_SNO) {
		this.SNO = set_SNO;
	}
	public void setSName(String set_SName) {
		this.SName = set_SName;
	}
	public void setCNO(String set_CNO) {
		this.CNO = set_CNO;
	}
	public void setCName(String set_CName) {
		this.CName = set_CName;
	}
	public void setGrade(int set_Grade) {
		this.Grade = set_Grade;
	}
	
	//��ȡֵ
	public String getTerm() {
		return Term;
	}
	public String getSNO() {
		return SNO;
	}
	public String getSName() {
		return SName;
	}
	public String getCNO() {
		return CNO;
	}
	public String getCName() {
		return CName;
	}
	public int getGrade() {
		return Grade;
	}
	
}

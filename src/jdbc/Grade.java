package jdbc;

public class Grade {
	private String Term;//学期
	private String SNO;//学号
	private String SName;//学生姓名
	private String CNO;//课程号
	private String CName;//课程名
	private int Grade;//成绩
	
	//设置值
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
	
	//获取值
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

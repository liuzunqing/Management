package jdbc;

public class Course {
	private String CNO;//课程号
	private String CName;//课程名
	private int Credit;//学分
	private String Type;//课程类型
	
	//设置值
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
	
	//获取值
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

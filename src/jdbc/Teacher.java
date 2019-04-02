package jdbc;

public class Teacher {
	private String TNO;//教师工号
	private String TName;//教师名
	
	//设置值
	public void setTNO(String set_TNO) {
		this.TNO = set_TNO;
	}
	public void setTName(String set_TName) {
		this.TName = set_TName;
	}
	
	//获取值
	public String getTNO() {
		return TNO;
	}
	public String getTName() {
		return TName;
	}
	
}

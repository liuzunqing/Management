package jdbc;

public class Login {
	private String Account;//账号
	private String Password;//密码
	private String Flag;//标志位
	
	//设置值
	public void setAccount(String set_Account) {
		this.Account = set_Account;
	}
	public void setPassword(String set_Password) {
		this.Password = set_Password;
	}
	public void setFlag(String set_Flag) {
		this.Flag = set_Flag;
	}
	
	//获取值
	public String getAccount() {
		return Account;
	}
	public String getPassword() {
		return Password;
	}
	public String getFlag() {
		return Flag;
	}
	
}

package jdbc;

public class Login {
	private String Account;//�˺�
	private String Password;//����
	private String Flag;//��־λ
	
	//����ֵ
	public void setAccount(String set_Account) {
		this.Account = set_Account;
	}
	public void setPassword(String set_Password) {
		this.Password = set_Password;
	}
	public void setFlag(String set_Flag) {
		this.Flag = set_Flag;
	}
	
	//��ȡֵ
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

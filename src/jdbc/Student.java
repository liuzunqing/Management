package jdbc;

public class Student {
	private String SNO;//ѧ��
	private String SName;//ѧ������
	private String Birthday;//��������
	private int Age;//����
	private String Sex;//�Ա�
	private String Identity;//������ò
	private String School;//��ѧʱ��
	private String Introduction;//���˼���
	private String Photo;//��Ƭ
	private String Address;//��ͥסַ
	private String Postnum;//�ʱ�
	private String Major;//��ѧרҵ
	
	//����ֵ
	public void setSNO(String set_SNO) {
		this.SNO = set_SNO;
	}
	public void setSName(String set_SName) {
		this.SName = set_SName;
	}
	public void setBirthday(String set_Birthday) {
		this.Birthday = set_Birthday;
	}
	public void setAge(int set_Age) {
		this.Age = set_Age;
	}
	public void setSex(String set_Sex) {
		this.Sex = set_Sex;
	}
	public void setIdentity(String set_Identity) {
		this.Identity = set_Identity;
	}
	public void setSchool(String set_School) {
		this.School = set_School;
	}
	public void setIntroduction(String set_Introduction) {
		this.Introduction = set_Introduction;
	}
	public void setPhoto(String set_Photo) {
		this.Photo = set_Photo;
	}
	public void setAddress(String set_Address) {
		this.Address = set_Address;
	}
	public void setPostnum(String set_Postnum) {
		this.Postnum = set_Postnum;
	}
	public void setMajor(String set_Major) {
		this.Major = set_Major;
	}
	
	//��ȡֵ
	public String getSNO() {
		return SNO;
	}
	public String getSName() {
		return SName;
	}
	public String getBirthday() {
		return Birthday;
	}
	public int getAge() {
		return Age;
	}
	public String getSex() {
		return Sex;
	}
	public String getIdentity() {
		return Identity;
	}
	public String getSchool() {
		return School;
	}
	public String getIntroduction() {
		return Introduction;
	}
	public String getPhoto() {
		return Photo;
	}
	public String getAddress() {
		return Address;
	}
	public String getPostnum() {
		return Postnum;
	}
	public String getMajor() {
		return Major;
	}
}

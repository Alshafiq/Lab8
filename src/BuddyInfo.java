
public class BuddyInfo {

	private String name;
	private long phoneNum;
	private int stu_num;
	
	public BuddyInfo(String name, long num, int stu)
	{
		this.name = name;
		this.phoneNum = num;
		this.stu_num = stu;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public long getPhoneNum() {
		return phoneNum;
	}
	
	public void setPhoneNum(long phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	public int getStu_num() {
		return stu_num;
	}
	
	public void setStu_num(int stu_num) {
		this.stu_num = stu_num;
	}
	
}

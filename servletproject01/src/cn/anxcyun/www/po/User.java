package cn.anxcyun.www.po;


    /**
    * @ClassName: User
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author Anxc
    * @date 2019年8月22日
    *
    */
    
public class User {
	
	protected String u_name;
	protected String u_classes;
	protected String u_number;
	protected String u_sex;
	protected String u_tel;
	
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getU_classes() {
		return u_classes;
	}
	public void setU_classes(String u_classes) {
		this.u_classes = u_classes;
	}
	public String getU_number() {
		return u_number;
	}
	public void setU_number(String u_number) {
		this.u_number = u_number;
	}
	public String getU_sex() {
		return u_sex;
	}
	public void setU_sex(String u_sex) {
		this.u_sex = u_sex;
	}
	public String getU_tel() {
		return u_tel;
	}
	public void setU_tel(String u_tel) {
		this.u_tel = u_tel;
	}
	@Override
	public String toString() {
		return "User [u_name=" + u_name + ", u_classes=" + u_classes + ", u_number=" + u_number + ", u_sex=" + u_sex
				+ ", u_tel=" + u_tel + "]";
	}
	public User(String u_name, String u_classes, String u_number, String u_sex, String u_tel) {
		super();
		this.u_name = u_name;
		this.u_classes = u_classes;
		this.u_number = u_number;
		this.u_sex = u_sex;
		this.u_tel = u_tel;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}

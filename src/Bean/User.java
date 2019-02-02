package Bean;

/**
 * @Author: StarsOne
 * @Description:
 * @Date: Create in  2019/1/21 0021 13:44
 */
class User {
	String userName,password;

	public User() {
	}

	public User(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}

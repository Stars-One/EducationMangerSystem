package Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: StarsOne
 * @Description:
 * @Date: Create in  2019/1/21 0021 13:49
 */
public class Student extends User {
	private String name,number,sex,phoneNumber,agddress,QQ;
	int age;
	List<Friend> friendslist = new ArrayList<>();
	public Student(String userName, String password) {
		super(userName, password);
	}

	public Student(String userName, String password,String name, String number, String sex, String phoneNumber, String agddress, String QQ, int age) {
		super(userName, password);
		this.name = name;
		this.number = number;
		this.sex = sex;
		this.phoneNumber = phoneNumber;
		this.agddress = agddress;
		this.QQ = QQ;
		this.age = age;
	}

	public String getQQ() {
		return QQ;
	}

	public void setQQ(String QQ) {
		this.QQ = QQ;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAgddress() {
		return agddress;
	}

	public void setAgddress(String agddress) {
		this.agddress = agddress;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	public boolean loginCheck(String userName,String password){
		if (userName.equals(this.userName) && password.equals(this.password)) {
			return true;
		}
		return false;

	}

	public List<Friend> getFriendslist() {
		return friendslist;
	}

	//输出当前学生的信息
	public void getInformation(){
		System.out.printf(getQQ()+"\t"+getName()+"\t"+getAge()+"\t"+getSex()+"\t "+getPhoneNumber()+"\t "+getAgddress()+"         "+friendslist.size()+"    "+getNumber()+"\n");
	}
	//当作朋友输出信息
	public void getInformationForFriend(Student friend,String remarks){
		System.out.printf(friend.getQQ()+"\t"+friend.getName()+"\t"+friend.getAge()+"\t"+friend.getSex()+"\t "+friend.getPhoneNumber()+"\t "+friend.getAgddress()+"         "+remarks+"    "+friend.getNumber()+"\n");
	}
	//老师查询
	public void getInformationOfTeacher(){
		System.out.printf(getUserName()+"    \t"+getPassword()+"    \t"+getQQ()+"\t"+getName()+"\t"+getAge()+"\t"+getSex()+"\t "+getPhoneNumber()+"\t "+getAgddress()+"         "+friendslist.size()+"    "+getNumber()+"\n");
	}
	//修改密码
	public boolean alterPassword(){
		System.out.println("请输入与旧密码：");
		Scanner scanner = new Scanner(System.in);
		String oldPassword = scanner.nextLine();
		if (oldPassword.equals(this.password)) {
			System.out.println("请输入新密码：");
			String newPassword = scanner.nextLine();
			System.out.println("再次输入新密码：");
			String confirmPassword = scanner.nextLine();
			if (newPassword.equals(confirmPassword)) {
				this.setPassword(newPassword);
				System.out.println("修改密码成功！");
				return true;
			} else {
				System.out.println("两次密码不相同！");
				return false;
			}
		}else {
			System.out.println("密码错误！");
			return false;
		}
	}

	//删除好友
	public void deleteFriend(){
		System.out.println("输入编号：");
		Scanner scanner = new Scanner(System.in);
		String number = scanner.nextLine();
		for (Friend friend : friendslist) {
			if (friend.getFriendNumber().equals(number)) {
				friendslist.remove(friend);
				System.out.println("删除成功！");
				break;
			}
		}
	}
	public void editRemarks(){
		System.out.println("输入需要修改备注的好友编号：");
		Scanner scanner = new Scanner(System.in);
		String number = scanner.nextLine();
		for (Friend friend : friendslist) {
			if (friend.getFriendNumber().equals(number)) {
				Friend temp = friend;
				friendslist.remove(friend);
				System.out.println("输入修改的备注名：");
				String newRemarks = scanner.nextLine();
				temp.setRemarks(newRemarks);
				friendslist.add(temp);
				break;
			}
		}
	}
	//添加好友
	public void addFriend(String friendNumber) {
		Friend friend = new Friend(number, friendNumber);
		System.out.println("输入好友备注：");
		Scanner scanner = new Scanner(System.in);
		String remarks = scanner.nextLine();
		friend.setRemarks(remarks);
		friendslist.add(friend);
		System.out.println("添加好友成功！！");
	}
	//查询是否为好友
	public boolean isFriend(String number){
		for (Friend friend : friendslist) {
			if (friend.friendNumber.equals(number)) {
				return true;
			}
		}
		return false;
	}
	public int getMaxStringLength(){
		int max = 0;
		int[] length = new int[8];
		length[0] = getUserName().length();
		length[1] = getPassword().length();
		length[2] = getName().length();
		length[3] = getSex().length();
		length[4] = getNumber().length();
		length[5] = getPhoneNumber().length();
		length[6] = getAgddress().length();
		length[7] = getQQ().length();
		for (int i = 0; i < length.length; i++) {
			if (length[i] > max) {
				max = length[i];
			}
		}
		return max;
		}
}

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Bean.Friend;
import Bean.Student;
import Bean.Teacher;

/**
 * @Author: StarsOne
 * @Description:
 * @Date: Create in  2019/1/21 0021 13:46
 */
class Manager {
	List<Student> students = new ArrayList<>();
	Teacher administrator = new Teacher("admin", "123456");//初始管理员
	public Manager() {
		System.out.println("------欢迎使用教务管理系统------");
		Student student = new Student("te", "t","离里","45","男","223333","广东","1053894518",23);
		Student student1 = new Student("tff", "t","刘建立","5","男","223333","广西","1053894518",8);
		Student student2 = new Student("tffe", "t","琉璃河","4","男","223333","福建","1053894518",14);
		Student student3 = new Student("tse", "t","李梦丽","2","男","223333","江苏","1053894518",54);
		Student student4 = new Student("tec", "t","丽丽","42","男","223333","淮河江苏","1053894518",27);
		students.add(student);
		students.add(student1);
		students.add(student2);
		students.add(student3);
		students.add(student4);
		chooseLogin();

	}
	public void chooseLogin(){
		System.out.println("***用户登录***");
		System.out.println("1.学生登录\n2.老师登录\n3.退出");
		Scanner scanner = new Scanner(System.in);
		int i = scanner.nextInt();
		switch (i) {
			case 1:
				studentLogin();
				break;
			case 2:
				teacherLogin();
				break;
			case 3:
				System.exit(0);
				break;
		}
	}
	//老师登录验证
	private void teacherLogin() {
		System.out.println("输入账号：");
		Scanner scanner = new Scanner(System.in);
		String name = scanner.nextLine();
		System.out.println("输入密码");
		String password = scanner.nextLine();
		if (name.equals(administrator.getUserName()) && password.equals(administrator.getPassword())) {
			chooseOptionOfTeacher();
		}else {
			System.out.println("登录失败，请重新登录！");
			chooseLogin();
		}
	}
	//老师功能选择
	private void chooseOptionOfTeacher() {
		System.out.println("*****功能选择*****");
		System.out.println("1.添加学生信息");
		System.out.println("2.修改学生信息");
		System.out.println("3.删除学生信息");
		System.out.println("4.查询学生信息");
		Scanner scanner = new Scanner(System.in);
		int i = scanner.nextInt();
		switch (i) {
			case 1:
				addStudent();
				break;
			case 2:
				queryStudentAll();
				editStudent();
				break;
			case 3:
				queryStudentAll();
				deleteStudent();
				break;
			case 4:
				queryStudent();
				break;
		}
		chooseOptionOfTeacher();
	}
	//修改学生信息
	private void editStudent() {
		System.out.println("输入要修改的学生编号：");
		Scanner scanner = new Scanner(System.in);
		String number = scanner.nextLine();
		for (Student student : students) {
			if (number.equals(student.getNumber())) {
				students.remove(student);
				break;
			}
		}
		alterStudent(scanner);
	}

	private void alterStudent(Scanner scanner) {
		String name,number,sex,phoneNumber,address,QQ,userName,password;
		int age;
		System.out.println("输入新的用户名：");
		userName = scanner.nextLine();
		boolean flag = true;
		for (Student student : students) {
			if (userName.equals(student.getUserName())) {

				flag = false;
				break;
			}
		}
		if (flag) {
			System.out.println("输入新的密码：");
			password = scanner.nextLine();
			System.out.println("输入新的名字：");
			name = scanner.nextLine();
			System.out.println("输入新的编号：");
			number = scanner.nextLine();
			System.out.println("输入新的性别：");
			sex = scanner.nextLine();
			System.out.println("输入新的地址：");
			address = scanner.nextLine();
			System.out.println("输入新的电话：");
			phoneNumber = scanner.nextLine();
			System.out.println("输入新的QQ号：");
			QQ = scanner.nextLine();
			System.out.println("输入新的年龄：");
			age = scanner.nextInt();
			Student student = new Student(userName, password, name, number, sex, phoneNumber, address, QQ, age);
			students.add(student);
			System.out.println("修改成功！");
		} else {
			System.out.println("用户名已存在");
			alterStudent(scanner);
		}
	}

	//删除学生信息
	private void deleteStudent() {
		System.out.println("输入删除的学生编号：");
		Scanner scanner = new Scanner(System.in);
		String number = scanner.nextLine();
		boolean flag = false;
		for (Student student : students) {
			if (number.equals(student.getNumber())) {
				students.remove(student);
				flag = true;
				break;
			}
		}
		if (flag) {
			System.out.println("删除成功！");
		} else {
			System.out.println("该编号不存在！");
		}
	}

	//查询学生信息
	private void queryStudent() {
		System.out.println("1.查询所有学生信息");
		System.out.println("2.指定编号查询");
		System.out.println("3.姓名模糊查询");
		System.out.println("4.地址模糊查询");
		System.out.println("5.年龄段查询");
		Scanner scanner = new Scanner(System.in);
		int i = scanner.nextInt();
		switch (i) {
			case 1:
				queryStudentAll();
				break;
			case 2:
				queryStudentOfNumber();
				break;
			case 3:
				queryStudentOfName();
				break;
			case 4:
				queryStudentOfAddress();
				break;
			case 5:
				queryStudentOfAge();
				break;
		}
	}

	private void queryStudentOfAddress() {
		System.out.println("请输入模糊地址：");
		Scanner scanner = new Scanner(System.in);
		String address = scanner.nextLine();
		System.out.printf("用户名"+"\t"+"密码"+"  "+"QQ号"+"        "+"姓名"+"   "+"年龄"+"\t"+"性别"+" "+"电话"+"\t "+"地址"+"                "+"好友"+"    "+"编号"+"\n");
		for (Student student : students) {

				if (student.getAgddress().contains(address)) {
					student.getInformationOfTeacher();
				}

		}
	}

	private void queryStudentOfAge() {
		System.out.println("请输入年龄段（10岁到20岁，格式为10-20）：");
		Scanner scanner = new Scanner(System.in);
		String age = scanner.nextLine();
		String[] temp = age.split("-");
		int minAge  = Integer.parseInt(temp[0]);
		int maxAge  = Integer.parseInt(temp[1]);
		System.out.printf("用户名"+"\t"+"密码"+"  "+"QQ号"+"        "+"姓名"+"   "+"年龄"+"\t"+"性别"+" "+"电话"+"\t "+"地址"+"                "+"好友"+"    "+"编号"+"\n");
		for (Student student : students) {
				if (student.getAge() >= minAge && student.getAge() <=maxAge) {
					student.getInformationOfTeacher();
				}
		}
	}

	private void queryStudentOfName() {
		System.out.println("请输入模糊的姓名");
		Scanner scanner = new Scanner(System.in);
		String name = scanner.nextLine();
		System.out.printf("用户名"+"\t"+"密码"+"  "+"QQ号"+"        "+"姓名"+"   "+"年龄"+"\t"+"性别"+" "+"电话"+"\t "+"地址"+"                "+"好友"+"    "+"编号"+"\n");
		for (Student student : students) {
				if (student.getName().contains(name)) {
					student.getInformationOfTeacher();
				}
		}
	}

	private void queryStudentOfNumber() {
		Scanner scanner = new Scanner(System.in);
		String number = scanner.nextLine();
		boolean flag = false;
		for (Student student : students) {
			if (student.getNumber().equals(number)) {
				System.out.printf("用户名"+"\t"+"密码"+"  "+"QQ号"+"        "+"姓名"+"   "+"年龄"+"\t"+"性别"+" "+"电话"+"\t "+"地址"+"                "+"好友"+"    "+"编号"+"\n");
				student.getInformationOfTeacher();
				flag = true;
				break;
			}
		}
		if (!flag) {
			System.out.println("该编号不存在！");
		}

	}

	private void queryStudentAll(){
		System.out.printf("用户名"+"\t"+"密码"+"  "+"QQ号"+"        "+"姓名"+"   "+"年龄"+"\t"+"性别"+" "+"电话"+"\t "+"地址"+"                "+"好友"+"    "+"编号"+"\n");
		for (Student student : students) {
			student.getInformationOfTeacher();
		}
	}

	//添加学生信息
	private void addStudent() {
		Scanner scanner = new Scanner(System.in);
		String name,number,sex,phoneNumber,address,QQ,userName,password;
		int age;
		System.out.println("输入用户名：");
		userName = scanner.nextLine();
		boolean flag = true;
		for (Student student : students) {
			if (userName.equals(student.getUserName())) {

				flag = false;
				break;
			}
		}
		if (flag) {
			System.out.println("输入密码：");
			password = scanner.nextLine();
			System.out.println("输入名字：");
			name = scanner.nextLine();
			System.out.println("输入编号：");
			number = scanner.nextLine();
			System.out.println("输入性别：");
			sex = scanner.nextLine();
			System.out.println("输入地址：");
			address = scanner.nextLine();
			System.out.println("输入电话：");
			phoneNumber = scanner.nextLine();
			System.out.println("输入QQ号：");
			QQ = scanner.nextLine();
			System.out.println("输入年龄：");
			age = scanner.nextInt();
			Student student = new Student(userName, password, name, number, sex, phoneNumber, address, QQ, age);
			students.add(student);
			System.out.println("添加成功！");
		} else {
			System.out.println("用户名已存在");
			addStudent();
		}

	}

	//学生登录验证
	private void studentLogin() {
		System.out.println("输入账号：");
		Scanner scanner = new Scanner(System.in);
		String name = scanner.nextLine();
		System.out.println("输入密码");
		String password = scanner.nextLine();
		Student user = null;
		boolean flag = false;
		for (Student student : students) {
			if (student.loginCheck(name, password)) {
				flag = true;
				user = student;
				break;
			}
		}
		if (!flag) {
			System.out.println("登录失败！请重新登录！");
			chooseLogin();
		}else {
			System.out.println("登陆成功！");
			chooseOptionOfTStudent(user);
		}

	}
	//学生功能选择
	private void chooseOptionOfTStudent(Student user) {
		System.out.println("*****功能选择*****");
		System.out.println("1.查询个人信息");
		System.out.println("2.修改密码");
		System.out.println("3.查询同学信息");
		System.out.println("4.添加好友");
		System.out.println("5.显示我的所有好友信息");
		System.out.println("6.删除好友");
		System.out.println("7.修改好友备注");
		System.out.println("0.退出");

		Scanner scanner = new Scanner(System.in);
		int i = scanner.nextInt();
		switch (i) {
			case 1:
				show();
				user.getInformation();
				chooseOptionOfTStudent(user);
				break;
			case 2:
				while (!user.alterPassword());
				chooseOptionOfTStudent(user);
				break;
			case 3:
				queryClassmateInformation(user);
				chooseOptionOfTStudent(user);
				break;
			case 4:
				queryAllClassmate(user);
				addFriends(user);
				showFriends(user);
				chooseOptionOfTStudent(user);
				break;
			case 5:
				showFriends(user);
				chooseOptionOfTStudent(user);
				break;
			case 6:
				showFriends(user);
				user.deleteFriend();
				showFriends(user);
				chooseOptionOfTStudent(user);
				break;
			case 7:
				showFriends(user);
				user.editRemarks();
				showFriends(user);
				chooseOptionOfTStudent(user);
				break;
			case 0:
				chooseLogin();
				break;
		}

	}
	//显示不是不是好友
	private void queryAllClassmate(Student user) {
		show();
		for (Student student : students) {
			//排除自己
			if (student != user) {
				if (!user.isFriend(student.getNumber())) {
					student.getInformation();
				}
			}
		}
	}

	private void showFriends(Student user) {
		List<Friend> friends = user.getFriendslist();
		System.out.printf("QQ号"+"        "+"姓名"+"   "+"年龄"+"\t"+"性别"+" "+"电话"+"\t "+"地址"+"                "+"备注"+"    "+"编号"+"\n");
		for (Friend friend : friends) {
			user.getInformationForFriend(queryOfNumber(friend.getFriendNumber()),friend.getRemarks());
		}
	}

	private void addFriends(Student user) {
		System.out.println("输入编号查找好友：");
		Scanner scanner = new Scanner(System.in);
		Student friend = queryOfNumber();
		System.out.println("是否添加为好友？（Y/N）");
		String flag = scanner.nextLine();
		if (flag.equalsIgnoreCase("y")) {
			user.addFriend(friend.getNumber());
		}
	}

	//查询同学信息
	private void queryClassmateInformation(Student user) {
		System.out.println("1.查看所有同学");
		System.out.println("2.指定编号查询");
		System.out.println("3.姓名模糊查询");
		System.out.println("4.地址模糊查询");
		System.out.println("5.年龄段查询");
		Scanner scanner = new Scanner(System.in);
		int i = scanner.nextInt();
		switch (i) {
			case 1:
				queryAll(user);
				break;
			case 2:
				System.out.println("请输入要查询的编号：");
				queryOfNumber();
				break;
			case 3:
				queryOfName(user);
				break;
			case 4:
				queryOfAddress(user);
				break;
			case 5:
				queryOfAge(user);
				break;
		}
	}

	private void queryOfAge(Student user) {
		System.out.println("请输入年龄段（10岁到20岁，格式为10-20）：");
		Scanner scanner = new Scanner(System.in);
		String age = scanner.nextLine();
		String[] temp = age.split("-");
		int minAge  = Integer.parseInt(temp[0]);
		int maxAge  = Integer.parseInt(temp[1]);
		show();
		for (Student student : students) {
			if (student != user) {
				if (student.getAge() >= minAge && student.getAge() <=maxAge) {
					student.getInformation();
				}
			}
		}
	}

	private void show() {
		System.out.printf("QQ号"+"        "+"姓名"+"   "+"年龄"+"\t"+"性别"+" "+"电话"+"\t "+"地址"+"                "+"好友"+"    "+"编号"+"\n");
	}

	private void queryOfAddress(Student user) {
		System.out.println("请输入模糊地址：");
		Scanner scanner = new Scanner(System.in);
		String address = scanner.nextLine();
		show();
		for (Student student : students) {
			if (student != user) {
				if (student.getAgddress().contains(address)) {
					student.getInformation();
				}
			}
		}
	}

	private void queryOfName(Student user) {
		System.out.println("请输入模糊的姓名");
		Scanner scanner = new Scanner(System.in);
		String name = scanner.nextLine();
		show();
		for (Student student : students) {
			if (student != user) {
				if (student.getName().contains(name)) {
					student.getInformation();
				}
			}
		}
	}

	private Student queryOfNumber(String number) {

		boolean flag = false;
		Student temp = null;
		for (Student student : students) {
			if (student.getNumber().equals(number)) {
				flag = true;
				temp = student;
				break;
			}
		}
		if (!flag) {
			System.out.println("该编号不存在！");

		}
		return temp;
	}

	//指定编号查询
	private Student queryOfNumber() {

		Scanner scanner = new Scanner(System.in);
		String number = scanner.nextLine();
		boolean flag = false;
		Student temp = null;
		for (Student student : students) {
			if (student.getNumber().equals(number)) {
				show();
				student.getInformation();
				flag = true;
				temp = student;
				break;
			}
		}
		if (!flag) {
			System.out.println("该编号不存在！");

		}
		return temp;
	}


	//查看所有学生
	private void queryAll(Student user) {
		show();
		for (Student student : students) {
			//排除自己
			if (student != user) {
				student.getInformation();
			}
		}
	}
}

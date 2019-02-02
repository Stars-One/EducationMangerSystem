/**
 * @Author: StarsOne
 * @Description:
 * @Date: Create in  2019/1/21 0021 13:49
 */
class Test {
	public static void main(String[] args) {
		new Manager();
		/*String s = "1053894518";

		String str = null;
		str = String.format("%-"+s.length()+"s%-10s%-10s","QQ号","电话号码","地址");
		System.out.println(str);
		System.out.println("-----");
		System.out.printf("%-"+s.length()+"s%-10s%-10s\n","QQ号","电话号码","地址");
		System.out.printf("%-"+(s.length()+1)+"s%-11s%-10s\n","12132412","1256454","广西来来来了解");
		System.out.println("----");
		str = String.format("%-11s%-10s%-10s","105384518","147926","广西桂林");
		System.out.println(str);
		Student student = new Student("te", "t","万兴兴","45","男","223333","广东","1053894518",23);
		int maxLength = student.getMaxStringLength();
		String name,number,sex,phoneNumber,address,QQ,age,friend,userName,password;
		name = "姓名";
		number = "编号";
		address = "地址";
		friend = "好友";
		QQ = "QQ号";
		userName = "用户名";
		password = "密码";
		phoneNumber = "电话号码";
		sex = "性别";
		age = "年龄";
		//System.out.printf(QQ+""+"姓名"+"   "+"年龄"+"\t"+"性别"+" "+"电话"+"\t "+"地址"+"                "+"好友"+"    "+"编号"+"\n");

		printSpace(QQ,maxLength);
		printSpace(name,maxLength);
		printSpace(age,maxLength);
		printSpace(sex,maxLength);
		printSpace(phoneNumber,maxLength);
		printSpace(address,maxLength);
		printSpace(friend,maxLength);
		printSpace(number,maxLength);
		System.out.println();

		printSpace(student.getQQ(),maxLength);
		printSpace(student.getName(),maxLength);
		printSpace(String.valueOf(student.getAge()),maxLength);
		printSpace(student.getSex(),maxLength);
		printSpace(student.getPhoneNumber(),maxLength);
		printSpace(student.getAgddress(),maxLength);
		printSpace(student.getNumber(),maxLength);
		System.out.println();*/
		//System.out.printf(student.getQQ()+"\t"+student.getName()+"\t"+student.getAge()+"\t"+student.getSex()+"\t "+student.getPhoneNumber()+"\t "+student.getAgddress()+"         "+student.getFriendslist().size()+"    "+student.getNumber()+"\n");
	}

	public static void printSpace(String string,int maxLength) {
		String temp = String.format("%-" + maxLength + "s", string);
		System.out.printf(temp);
	}
}

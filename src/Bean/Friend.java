package Bean;

/**
 * @Author: StarsOne
 * @Description:
 * @Date: Create in  2019/1/23 0023 15:26
 */
public class Friend {
	String myNumber,friendNumber;
	String remarks;//备注

	public Friend(String myNumber, String friendNumber, String remarks) {
		this.myNumber = myNumber;
		this.friendNumber = friendNumber;
		this.remarks = remarks;
	}

	public Friend(String myNumber, String friendNumber) {
		this.myNumber = myNumber;
		this.friendNumber = friendNumber;
	}

	public String getMyNumber() {
		return myNumber;
	}

	public void setMyNumber(String myNumber) {
		this.myNumber = myNumber;
	}

	public String getFriendNumber() {
		return friendNumber;
	}

	public void setFriendNumber(String friendNumber) {
		this.friendNumber = friendNumber;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}

/**
 * 
 */
package memberpublisher.Model;

/**
 * @author Harini
 *
 */
public class Member {
	private int MemID;
	private String name;
	private String tel;
	private String RegDate;
	private String city;
	public int getMemID() {
		return MemID;
	}
	public void setMemID(int memID) {
		MemID = memID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getRegDate() {
		return RegDate;
	}
	public void setRegDate(String regDate) {
		RegDate = regDate;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

}

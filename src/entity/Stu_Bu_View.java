package entity;

public class Stu_Bu_View {
	private String id;
	private int bid;
	private String bname;
	private String content;
	
	public Stu_Bu_View() {
	}
	public Stu_Bu_View(String id, int bid, String bname, String content) {
		this.id = id;
		this.bid = bid;
		this.bname = bname;
		this.content = content;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}

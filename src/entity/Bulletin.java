package entity;

public class Bulletin {
	private Integer bid;
	private String bname;
	private String content;
	
	public Bulletin() {
	}
	public Bulletin(String bname,String content) {
		this.bname = bname;
		this.content = content;
	}
	public Bulletin(Integer bid, String content, String bname) {
		this.bid = bid;
		this.bname = bname;
		this.content = content;
	}
	public Integer getBid() {
		return bid;
	}
	public void setBid(Integer bid) {
		this.bid = bid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getBname(){
		return bname;
	}
	public void setBname(String bname){
		this.bname =  bname;
	}
}

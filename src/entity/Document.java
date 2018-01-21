package entity;

public class Document {
	String simplePath;
	String path;
	String name;
	
	
	public Document() {
	}
	public Document(String path, String name) {
		this.name = name;
		this.path = path;
	}
	public Document(String path, String name, String simplePath) {
		this.simplePath = simplePath;
		this.name = name;
		this.path = path;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getSimplePath() {
		return simplePath;
	}
	public void setSimplePath(String simplePath) {
		this.simplePath = simplePath;
	}
	
	@Override
	public String toString() {
		return path+"//"+name;
	}
	
}

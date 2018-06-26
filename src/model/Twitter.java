package model;

public class Twitter implements java.io.Serializable {
	private int id;
	private String twitterName;
	private String text;

	public Twitter() {}
	public Twitter(int id, String twitterName, String text) {
		this.id = id;
		this.twitterName = twitterName;
		this.text = text;
	}
	public Twitter(String twitterName, String text) {
		this.twitterName = twitterName;
		this.text = text;
	}

	public int getId() {
		return id;
	}
	public String getTwitterName() {
		return twitterName;
	}
	public String getText() {
		return text;
	}
}

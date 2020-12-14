package csmen.group.project.entity;

public class ForumInfo {
	private int id;
	private String topic;
	private String author;
	private String content;
	private int replynum;
	
	public ForumInfo()
	{
		
	}
	
	public ForumInfo(int id, String topic, String author, String content, int reply)
	{
		this.id = id;
		this.topic = topic;
		this.author = author;
		this.content = content;
		this.replynum = reply;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getReplynum() {
		return replynum;
	}
	public void setReplynum(int replynum) {
		this.replynum = replynum;
	}
	
	
}

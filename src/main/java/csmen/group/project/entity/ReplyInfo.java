package csmen.group.project.entity;

public class ReplyInfo {
	private String topic;
	private String sender;
	private String sendtime;
	private String content;
	
	public ReplyInfo()
	{
		
	}
	
	public ReplyInfo(String topic, String sender, String sendtime, String content)
	{
		this.topic = topic;
		this.sender = sender;
		this.sendtime = sendtime;
		this.content = content;
	}
	
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getSendtime() {
		return sendtime;
	}
	public void setSendtime(String sendtime) {
		this.sendtime = sendtime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}

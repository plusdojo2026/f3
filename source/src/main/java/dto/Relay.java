package dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Relay implements Serializable{
	private int relay_id;
	private String user_id;
	private int process_count;
	private int project_id;
	private int redraw_count;
	private String relay_image_url;
	private LocalDateTime assigned_at;
	private LocalDateTime deadline_at;
	
	public Relay() {
		
	}
	public int getRelay_id() {
		return relay_id;
	}
	public void setRelay_id(int relay_id) {
		this.relay_id = relay_id;
		
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id =user_id;
		
	}
	public int getProcess_count() {
		return process_count;
	}
	public void setProcess_count(int process_count) {
		this.process_count = process_count;
		
	}
	public int getProject_id() {
		return project_id;
	}
	public void setProject_id(int project_id) {
		this.project_id = project_id;
		
	}
	public int getRedraw_count() {
		return redraw_count;
	}
	public void setRedraw_count(int redraw_count) {
		this.redraw_count = redraw_count;
		
	}
	public String getRelay_image_url() {
		return relay_image_url;
	}
	public void setRelay_image_url(String relay_image_url) {
		this.relay_image_url = relay_image_url;
		
	}
	public LocalDateTime getAssigned_at() {
		return assigned_at;
	}
	public void setAssigned_at(LocalDateTime assigned_at) {
		this.assigned_at = assigned_at;
		
	}
	public LocalDateTime getDeadline_at() {
		return deadline_at;
	}
	public void setDeadline_at(LocalDateTime deadline_at) {
		this.deadline_at = deadline_at;
		
	}
	public Relay(int relay_id, String user_id, int process_count, int project_id, int redraw_count,
			String relay_image_url, LocalDateTime assigned_at, LocalDateTime deadline_at) {
		super();
		this.relay_id = relay_id;
		this.user_id = user_id;
		this.process_count = process_count;
		this.project_id = project_id;
		this.redraw_count = redraw_count;
		this.relay_image_url = relay_image_url;
		this.assigned_at = assigned_at;
		this.deadline_at = deadline_at;
	}

}

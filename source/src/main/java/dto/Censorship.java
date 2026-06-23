package dto;

import java.io.Serializable;

public class Censorship implements Serializable{
	private int censoring_id;
	private int project_id;
	private String user_id;
	private Boolean result;
	private int admin_id;
	
	public Censorship() {
		
	}
	public int getCensoring_id () {
		return censoring_id;
	}
	public void setCensoring_id (int censoring_id) {
		this.censoring_id = censoring_id;
		
	}
	public int getProject_id () {
		return project_id;
	}
	public void setProject_id (int project_id) {
		this.project_id = project_id;
		
	}
	public String getUser_id () {
		return user_id;
	}
	public void setUser_id (String user_id) {
		this.user_id = user_id;
		
	}
	public Boolean setResult () {
		return result;
	}
	public void setResult (Boolean result) {
		this.result = result;
		
	}
	public int getAdmin_id () {
		return admin_id;
	}
	public void setAdmin_id (int admin_id) {
		this.admin_id = admin_id;
		
	}

}

package dto;

public class Projects {
	private int projectId;
	private String userId;
	private String imageUrl;
	private String number;
	private String theme;
	private String postDate;
	
	
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public String getPostDate() {
		return postDate;
	}
	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}
	public Projects(int projectId, String userId, String imageUrl, String number, String theme, String postDate) {
		super();
		this.projectId = projectId;
		this.userId = userId;
		this.imageUrl = imageUrl;
		this.number = number;
		this.theme = theme;
		this.postDate = postDate;
	}
	
	

}

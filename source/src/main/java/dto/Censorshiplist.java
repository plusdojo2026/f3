package dto;

public class Censorshiplist {
	private int projectId;
    private String userId;
    private String imageUrl;
    private String voiceUrl;
    private String caption;
    private String source;
    
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
	public String getVoiceUrl() {
		return voiceUrl;
	}
	public void setVoiceUrl(String voiceUrl) {
		this.voiceUrl = voiceUrl;
	}
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}

}

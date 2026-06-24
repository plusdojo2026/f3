package dto;

import java.io.Serializable;

public class Review implements Serializable{
private int projectId;        // プロジェクトID
    private String thumbnailUrl;  // サムネイルURL
    private int good;             // いいね
    private int grossGood;        // きもいいね
    private int scaryGood;        // こわいいね
    
   
	
	public int getProjectId() {
		return projectId;
}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getThumbnailUrl() {
		return thumbnailUrl;
}
	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}
	
	public int getGood() {
		return good;
}
	public void setGood(int good) {
		this.good = good;
	}
	
	public int getGrossGood() {
		return grossGood;
}
	public void setGrossGood(int grossGood) {
		this.grossGood = grossGood;
	}
	
	public int getScaryGood() {
		return scaryGood;
}
	public void setScaryGood(int scaryGood) {
		this.scaryGood = scaryGood;
	}
	


	
	
	public Review() {
		this.projectId = 0;
		this.thumbnailUrl ="";
		this.good = 0;
		this.grossGood = 0;
		this.scaryGood = 0;
		
	}

	public Review(int projectId, String thumbnailUrl, int good,int grossGood,int scaryGood) {
		this.projectId = projectId;
		this.thumbnailUrl = thumbnailUrl;
		this.good = good;
		this.grossGood = grossGood;
		this.scaryGood = scaryGood;
		
	}
}
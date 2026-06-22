package dto;

import java.io.Serializable;

public class Review implements Serializable{
private int projectId;        // プロジェクトID
    private String thumbnailUrl;  // サムネイルURL
    private int good;             // いいね
    private int grossGood;        // きもいいね
    private int scaryGood;        // こわいいね

	
	public int getprojectId() {
		return projectId;
}
	public void setprojectId(int projectId) {
		this.projectId = projectId;
	}

	public String getthumbnailUrl() {
		return thumbnailUrl;
}
	public void setthumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}
	
	public int getgood() {
		return good;
}
	public void setgood(int good) {
		this.good = good;
	}
	
	public int getgrossGood() {
		return grossGood;
}
	public void setgrossGood(int grossGood) {
		this.grossGood = grossGood;
	}
	
	public int getscaryGood() {
		return scaryGood;
}
	public void setscaryGood(int scaryGood) {
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
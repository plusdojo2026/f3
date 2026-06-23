package dto;
import java.io.Serializable;
public class ProjectTags implements Serializable{

	private int tagId;        // タグID
	    private int projectId;  // プロジェクトID
	    private String tagName;    // タグ名
		
		public int gettagId() {
			return tagId;
	}
		public void settagId(int tagId ){
			this.tagId = tagId;
		}

		public int getprojectId() {
			return projectId;
	}
		public void setprojectId(int projectId) {
			this.projectId = projectId;
		}
		
		public String gettagName() {
			return tagName;
	}
		public void settagName(String tagName) {
			this.tagName = tagName;
		}
		
		
		public ProjectTags() {
			this.tagId = 0;
			this.projectId = 0;
			this.tagName = "";
		}

		public ProjectTags(int tagId, int projectId, String tagName) {
			this.tagId = tagId;
			this.projectId = projectId;
			this.tagName = tagName;
			
		}
	}
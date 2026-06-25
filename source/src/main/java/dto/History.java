package dto;

import java.time.LocalDateTime;

public class History {
	private int work_id;
	private String user_id;
	private String editedimage_url;
	private int process_count;
	private int project_id;
	private int voice_id;
	private String caption;
	private LocalDateTime processing_data;
	
	public History() {
		
	}
	
	public int getWork_id() {
		return work_id;
		
	}
	public void setWork_id(int work_id) {
		this.work_id = work_id;
	}
	
	public String getUser_id() {
		return user_id;
		
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getEditedimage_url() {
		return editedimage_url;
		
	}
	public void setEditedimage_url(String editedimage_url) {
		this.editedimage_url = editedimage_url;
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
	public int getVoice_id() {
		return voice_id;
		
	}
	public void setVoice_id(int voice_id) {
		this.voice_id = voice_id;
	}
	public String getCaption() {
		return caption;
		
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	public LocalDateTime getProcessing_data() {
		return processing_data;
		
	}
	public void setProcessing_data(LocalDateTime processing_data) {
		this.processing_data = processing_data;
	}

	public History(int work_id, String user_id, String editedimage_url, int process_count, int project_id, int voice_id,
			String caption, LocalDateTime processing_data) {
		super();
		this.work_id = work_id;
		this.user_id = user_id;
		this.editedimage_url = editedimage_url;
		this.process_count = process_count;
		this.project_id = project_id;
		this.voice_id = voice_id;
		this.caption = caption;
		this.processing_data = processing_data;
	}
	

}

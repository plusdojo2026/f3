package dto;

public class Report {
private int reportId;
private int relayId;
private String userId;
private String reason;
private String reportTime;
public int getReportId() {
	return reportId;
}
public void setReportId(int reportId) {
	this.reportId = reportId;
}
public int getRelayId() {
	return relayId;
}
public void setRelayId(int relayId) {
	this.relayId = relayId;
}
public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
public String getReason() {
	return reason;
}
public void setReason(String reason) {
	this.reason = reason;
}
public String getReportTime() {
	return reportTime;
}
public void setReportTime(String reportTime) {
	this.reportTime = reportTime;
}
public Report(int reportId, int relayId, String userId, String reason, String reportTime) {
	super();
	this.reportId = reportId;
	this.relayId = relayId;
	this.userId = userId;
	this.reason = reason;
	this.reportTime = reportTime;
}



}

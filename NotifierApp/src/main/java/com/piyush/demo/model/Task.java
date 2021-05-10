package com.piyush.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Task {

	@Id
	@GeneratedValue
	private int tid;
	private String tname;
	private Date startDate;
	private Date endDate;
	private Date reminderDate;
	private String status;
	private String tag;
	private String description;
	private int nbid;
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Date getReminderDate() {
		return reminderDate;
	}
	public void setReminderDate(Date reminderDate) {
		this.reminderDate = reminderDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getNbid() {
		return nbid;
	}
	public void setNbid(int nbid) {
		this.nbid = nbid;
	}
	@Override
	public String toString() {
		return "Task [tid=" + tid + ", tname=" + tname + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", reminderDate=" + reminderDate + ", status=" + status + ", tag=" + tag + ", description="
				+ description + ", nbid=" + nbid + "]";
	}
	
	
	
	
}

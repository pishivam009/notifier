package com.piyush.demo.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Notebook {

	@Id
	@GeneratedValue
	private String nbid;
	private String nbname;
	private String useremail;
	public String getNbid() {
		return nbid;
	}
	public void setNbid(String nbid) {
		this.nbid = nbid;
	}
	public String getNbname() {
		return nbname;
	}
	public void setNbname(String nbname) {
		this.nbname = nbname;
	}
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	@Override
	public String toString() {
		return "Notebook [nbid=" + nbid + ", nbname=" + nbname + ", useremail=" + useremail + "]";
	}
	
	
}

package com.piyush.demo.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Notebook {

	@Id
	@GeneratedValue
	private int nbid;
	private String nbname;
	private String useremail;
	
	public int getNbid() {
		return nbid;
	}
	public void setNbid(int nbid) {
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

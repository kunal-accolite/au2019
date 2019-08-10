package com.accolite.au;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="User")
public class User {
	
	@Id
	@Column(name="Username")
	private String username;
	
	@Column(name="Password")
	private String password;
	
	@Column(name="Attempt")
	private int count;
	
	@Column(name="Timestamp")
	Timestamp ts;
	
	@Column(name="Checked")
	private boolean checked;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	public Timestamp getTs() {
		return ts;
	}
	public void setTs(Timestamp ts) {
		this.ts = ts;
	}
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	public User() {
		
	}
	public User(String username, String password, int count, Timestamp ts, boolean checked) {
		super();
		this.username = username;
		this.password = password;
		this.count = count;
		this.ts=ts;
		this.checked=checked;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", count=" + count + ", ts=" + ts
				+ ", checked=" + checked + "]";
	}
	
}

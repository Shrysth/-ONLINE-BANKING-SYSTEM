package com.banking.banking_system.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String username;
	private String password;
	private String fullname;
	private String Address;
	private String branchId;
	private String branchName;

	public User(){

	}
	
	String branchName(){
		if (branchId == "00001") {
			this.branchName="homeBranch";
		}
		if (branchId == "00002") {
			this.branchName="mainBranch";
		}
		if (branchId == "00003") {
			this.branchName="foreignBranch";
		}
		else{
			this.branchName="null";
		}
		return branchName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public User(String username, String password, String fullname, String Address, String branchId) {
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.Address = Address;
		this.branchId = branchId;
		this.branchName = this.branchName(); // Call the branchName() method to set the branchName field
	}
	public User orElseThrow() {
		// TODO Auto-generated method stub
		return null;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getBranchId() {
		return branchId;
	}
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
	public String getBranchName() {
		return branchName();
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
}
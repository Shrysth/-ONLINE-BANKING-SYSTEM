package com.banking.banking_system.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
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

	String branchName(){
		if (branchId == "00001") {
			branchName="homeBranch";
		}
		if (branchId == "00002") {
			branchName="mainBranch";
		}
		if (branchId == "00003") {
			branchName="foreignBranch";
		}
		else{
			branchName="null";
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
}
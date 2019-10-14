package com.formation.model;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "user_id")
	private int id;

	@Column(name = "firstName")
	@Size(min = 2, max = 20)
	private String firstName;

	@Column(name = "lastName")
	@Size(min = 2, max = 20)
	private String lastName;

	@Column(name = "name")
	@Size(min = 2, max = 20)
	private String name;

	@Column(unique = true, name = "email")
	@Size(min = 10, max = 30)
	private String email;
	
	
	@Column(name = "password")
	@Size(min = 4, max = 20)
	private String password;

	@Column(name = "birthDate")
	private String birthDate;
	
	@Column(name = "role")
	private String role;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return firstName + " " + lastName;
	}

	
	public boolean newAccountfieldNotEmpty(){
		if(this.firstName != null && this.lastName != null && this.email != null && this.birthDate != null && this.password != null){
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", birthDate=" + birthDate + ", role=" + role + "]";
	}
}

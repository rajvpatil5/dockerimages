package com.docker.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Users {

	@Id
	@Column(nullable=false,length = 150)
	private String username;
	private String password;
	@Column(name="enabled")
	private int enable;

	@OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
	private List<Authorities> authorities;


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

	public int getEnable() {
		return enable;
	}

	public void setEnable(int enable) {
		this.enable = enable;
	}

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Authorities> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<Authorities> authorities) {
		this.authorities = authorities;
	}

	public Users(String username, String password, int enable, List<Authorities> authorities) {
		super();

		this.username = username;
		this.password = password;
		this.enable = enable;
		this.authorities = authorities;
	}



}

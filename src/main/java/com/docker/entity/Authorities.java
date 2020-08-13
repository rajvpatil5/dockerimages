package com.docker.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "authorities")
public class Authorities {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
	private int id;
	
	@Column(length = 150)
	private String username;
	private String authority;
	
	@ManyToOne(cascade = CascadeType.ALL,optional=false)
	@JoinColumn(name = "username", nullable=false, insertable = false, updatable = false)
	private Users users;
	
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public Authorities() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Authorities(int id, String username, String authority, Users users) {
		super();
		this.id = id;
		this.username = username;
		this.authority = authority;
		this.users = users;
	}


}

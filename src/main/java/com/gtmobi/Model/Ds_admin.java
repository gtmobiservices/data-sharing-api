package com.gtmobi.Model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ds_admin")
public class Ds_admin {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "admin_id")
	private Integer admin_id;

	@Column(name = "userName")
	private String userName;

	@Column(name = "password")
	private String password;

	@Column(name = "created_time")
	private Timestamp created_time;

	public Ds_admin() {
		super();
	}

	public Ds_admin(Integer admin_id, String userName, String password, Timestamp created_time, boolean is_active,
			boolean is_deleted, String ip_address) {
		super();
		this.admin_id = admin_id;
		this.userName = userName;
		this.password = password;
		this.created_time = created_time;
	}

	public Integer getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(Integer admin_id) {
		this.admin_id = admin_id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getCreated_time() {
		return created_time;
	}

	public void setCreated_time(Timestamp created_time) {
		this.created_time = created_time;
	}

}

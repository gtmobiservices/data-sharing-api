package com.gtmobi.Model;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ds_token")
public class Ds_token {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer token_id;
	private String token;
	private Boolean is_active;
	private Boolean is_deleted;
	private Integer admin_id;
	private Timestamp login_time;
	private Timestamp logout_time;

	public Ds_token() {
		super();
	}

	public Ds_token(Integer token_id, String token, Boolean is_active, Boolean is_deleted, Integer admin_id,
			Timestamp login_time, Timestamp logout_time) {
		super();
		this.token_id = token_id;
		this.token = token;
		this.is_active = is_active;
		this.is_deleted = is_deleted;
		this.admin_id = admin_id;
		this.login_time = login_time;
		this.logout_time = logout_time;
	}

	public Integer getToken_id() {
		return token_id;
	}

	public void setToken_id(Integer token_id) {
		this.token_id = token_id;
	}

	public Boolean getIs_active() {
		return is_active;
	}

	public void setIs_active(Boolean is_active) {
		this.is_active = is_active;
	}

	public Boolean getIs_deleted() {
		return is_deleted;
	}

	public void setIs_deleted(Boolean is_deleted) {
		this.is_deleted = is_deleted;
	}

	public Integer getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(Integer admin_id) {
		this.admin_id = admin_id;
	}

	public Timestamp getLogin_time() {
		return login_time;
	}

	public void setLogin_time(Timestamp login_time) {
		this.login_time = login_time;
	}

	public Timestamp getLogout_time() {
		return logout_time;
	}

	public void setLogout_time(Timestamp logout_time) {
		this.logout_time = logout_time;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}

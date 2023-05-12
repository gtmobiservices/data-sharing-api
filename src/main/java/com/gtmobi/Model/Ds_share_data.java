package com.gtmobi.Model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ds_share_data")
public class Ds_share_data {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer share_data_id;
	private Timestamp from_time;
	private Timestamp to_time;
	private String salt;
	private Timestamp created_time;
	private Boolean is_deleted;
	private Boolean is_active;
	private String ip_address;
	private Integer user_id;
	private Timestamp updated_time;
	private Timestamp deleted_time;
	private String update_info;

	public Ds_share_data() {
		super();
	}

	public Ds_share_data(Integer share_data_id, Timestamp from_time, Timestamp to_time, String salt,
			Timestamp created_time, Boolean is_deleted, Boolean is_active, String ip_address, Integer user_id,
			Timestamp updated_time, Timestamp deleted_time, String update_info) {
		super();
		this.share_data_id = share_data_id;
		this.from_time = from_time;
		this.to_time = to_time;
		this.salt = salt;
		this.created_time = created_time;
		this.is_deleted = is_deleted;
		this.is_active = is_active;
		this.ip_address = ip_address;
		this.user_id = user_id;
		this.updated_time = updated_time;
		this.deleted_time = deleted_time;
		this.update_info = update_info;
	}

	public Timestamp getUpdated_time() {
		return updated_time;
	}

	public void setUpdated_time(Timestamp updated_time) {
		this.updated_time = updated_time;
	}

	public Timestamp getDeleted_time() {
		return deleted_time;
	}

	public void setDeleted_time(Timestamp deleted_time) {
		this.deleted_time = deleted_time;
	}

	public Integer getShare_data_id() {
		return share_data_id;
	}

	public void setShare_data_id(Integer share_data_id) {
		this.share_data_id = share_data_id;
	}

	public Timestamp getFrom_time() {
		return from_time;
	}

	public void setFrom_time(Timestamp from_time) {
		this.from_time = from_time;
	}

	public Timestamp getTo_time() {
		return to_time;
	}

	public void setTo_time(Timestamp to_time) {
		this.to_time = to_time;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Timestamp getCreated_time() {
		return created_time;
	}

	public void setCreated_time(Timestamp created_time) {
		this.created_time = created_time;
	}

	public Boolean getIs_deleted() {
		return is_deleted;
	}

	public void setIs_deleted(Boolean is_deleted) {
		this.is_deleted = is_deleted;
	}

	public Boolean getIs_active() {
		return is_active;
	}

	public void setIs_active(Boolean is_active) {
		this.is_active = is_active;
	}

	public String getIp_address() {
		return ip_address;
	}

	public void setIp_address(String ip_address) {
		this.ip_address = ip_address;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getUpdate_info() {
		return update_info;
	}

	public void setUpdate_info(String update_info) {
		this.update_info = update_info;
	}

}

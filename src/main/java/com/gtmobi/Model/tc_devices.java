package com.gtmobi.Model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class tc_devices {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "uniqueid")
	private String uniqueid;

	@Column(name = "lastupdate")
	private Timestamp lastupdate;

	@OneToOne
	@JoinColumn(name = "positionid")
	private tc_positions positionid;

	@Column(name = "groupid")
	private Integer groupid;

	@Column(name = "attributes")
	private String attributes;

	@Column(name = "phone")
	private String phone;

	@Column(name = "model")
	private String model;

	@Column(name = "contact")
	private String contact;

	@Column(name = "category")
	private String category;

	@Column(name = "disabled")
	private Boolean disabled;

	@Column(name = "status")
	private char status;

	@Column(name = "geofenceids")
	private String geofenceids;

	@Column(name = "expirationtime")
	private Timestamp expirationtime;

	@Column(name = "motionstate")
	private Boolean motionstate;

	@Column(name = "motiontime")
	private Timestamp motiontime;

	@Column(name = "motiondistance")
	private Double motiondistance;

	@Column(name = "overspeedstate")
	private Boolean overspeedstate;

	@Column(name = "overspeedtime")
	private Timestamp overspeedtime;

	@Column(name = "overspeedgeofenceid")
	private Integer overspeedgeofenceid;

	@Column(name = "motionstreak")
	private Boolean motionstreak;

	public tc_devices() {
		super();
	}

	public tc_devices(Integer id, String name, String uniqueid, Timestamp lastupdate, tc_positions positionid,
			Integer groupid, String attributes, String phone, String model, String contact, String category,
			Boolean disabled, char status, String geofenceids, Timestamp expirationtime, Boolean motionstate,
			Timestamp motiontime, Double motiondistance, Boolean overspeedstate, Timestamp overspeedtime,
			Integer overspeedgeofenceid, Boolean motionstreak) {
		super();
		this.id = id;
		this.name = name;
		this.uniqueid = uniqueid;
		this.lastupdate = lastupdate;
		this.positionid = positionid;
		this.groupid = groupid;
		this.attributes = attributes;
		this.phone = phone;
		this.model = model;
		this.contact = contact;
		this.category = category;
		this.disabled = disabled;
		this.status = status;
		this.geofenceids = geofenceids;
		this.expirationtime = expirationtime;
		this.motionstate = motionstate;
		this.motiontime = motiontime;
		this.motiondistance = motiondistance;
		this.overspeedstate = overspeedstate;
		this.overspeedtime = overspeedtime;
		this.overspeedgeofenceid = overspeedgeofenceid;
		this.motionstreak = motionstreak;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUniqueid() {
		return uniqueid;
	}

	public void setUniqueid(String uniqueid) {
		this.uniqueid = uniqueid;
	}

	public Timestamp getLastupdate() {
		return lastupdate;
	}

	public void setLastupdate(Timestamp lastupdate) {
		this.lastupdate = lastupdate;
	}

	public tc_positions getPositionid() {
		return positionid;
	}

	public void setPositionid(tc_positions positionid) {
		this.positionid = positionid;
	}

	public Integer getGroupid() {
		return groupid;
	}

	public void setGroupid(Integer groupid) {
		this.groupid = groupid;
	}

	public String getAttributes() {
		return attributes;
	}

	public void setAttributes(String attributes) {
		this.attributes = attributes;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Boolean getDisabled() {
		return disabled;
	}

	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public String getGeofenceids() {
		return geofenceids;
	}

	public void setGeofenceids(String geofenceids) {
		this.geofenceids = geofenceids;
	}

	public Timestamp getExpirationtime() {
		return expirationtime;
	}

	public void setExpirationtime(Timestamp expirationtime) {
		this.expirationtime = expirationtime;
	}

	public Boolean getMotionstate() {
		return motionstate;
	}

	public void setMotionstate(Boolean motionstate) {
		this.motionstate = motionstate;
	}

	public Timestamp getMotiontime() {
		return motiontime;
	}

	public void setMotiontime(Timestamp motiontime) {
		this.motiontime = motiontime;
	}

	public Double getMotiondistance() {
		return motiondistance;
	}

	public void setMotiondistance(Double motiondistance) {
		this.motiondistance = motiondistance;
	}

	public Boolean getOverspeedstate() {
		return overspeedstate;
	}

	public void setOverspeedstate(Boolean overspeedstate) {
		this.overspeedstate = overspeedstate;
	}

	public Timestamp getOverspeedtime() {
		return overspeedtime;
	}

	public void setOverspeedtime(Timestamp overspeedtime) {
		this.overspeedtime = overspeedtime;
	}

	public Integer getOverspeedgeofenceid() {
		return overspeedgeofenceid;
	}

	public void setOverspeedgeofenceid(Integer overspeedgeofenceid) {
		this.overspeedgeofenceid = overspeedgeofenceid;
	}

	public Boolean getMotionstreak() {
		return motionstreak;
	}

	public void setMotionstreak(Boolean motionstreak) {
		this.motionstreak = motionstreak;
	}

}

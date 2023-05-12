package com.gtmobi.Model;

import java.sql.Timestamp;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class tc_users {

	@Id
	@GeneratedValue
	private Integer id;

	@Column(name = "name", length = 128)
	private String name;

	@Column(name = "email", length = 128)
	private String email;

	@Column(name = "hashedpassword", length = 128)
	private String hashedpassword;

	@Column(name = "salt", length = 128)
	private String salt;

	@Column(name = "readonly")
	private Boolean readonly;

	@Column(name = "administrator")
	private Boolean administrator;

	@Column(name = "map", length = 128)
	private String map;

	@Column(name = "latitude")
	private Double latitude;

	@Column(name = "longitude")
	private Double longitude;

	@Column(name = "zoom")
	private Integer zoom;

	@Column(name = "twelvehourformat")
	private Boolean twelvehourformat;

	@Column(name = "attributes", length = 4000)
	private String attributes;

	@Column(name = "coordinateformat")
	private String coordinateformat;

	@Column(name = "disabled")
	private Boolean disabled;

	@Column(name = "expirationtime")
	private Timestamp expirationtime;

	@Column(name = "devicelimit")
	private Integer devicelimit;

	@Column(name = "userlimit")
	private Integer userlimit;

	@Column(name = "devicereadonly")
	private Boolean devicereadonly;

	@Column(name = "phone", length = 128)
	private String phone;

	@Column(name = "limitcommands")
	private Boolean limitcommands;

	@Column(name = "login", length = 128)
	private String login;

	@Column(name = "poilayer", length = 512)
	private String poilayer;

	@Column(name = "disablereports")
	private Boolean disablereports;

	@Column(name = "fixedemail")
	private Boolean fixedemail;

	@Column(name = "token")
	private String token;

	@OneToMany()
	@JoinTable(name = "tc_user_device", joinColumns = @JoinColumn(name = "userid"), inverseJoinColumns = @JoinColumn(name = "deviceid"))
	private List<tc_devices> deviceList;

	public tc_users() {
		super();
	}

	public tc_users(int id, String name, String email, String hashedpassword, String salt, Boolean readonly,
			Boolean administrator, String map, Double latitude, Double longitude, Integer zoom,
			Boolean twelvehourformat, String attributes, String coordinateformat, Boolean disabled,
			Timestamp expirationtime, Integer devicelimit, Integer userlimit, Boolean devicereadonly, String phone,
			Boolean limitcommands, String login, String poilayer, Boolean disablereports, Boolean fixedemail,
			String token, List<tc_devices> deviceList) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.hashedpassword = hashedpassword;
		this.salt = salt;
		this.readonly = readonly;
		this.administrator = administrator;
		this.map = map;
		this.latitude = latitude;
		this.longitude = longitude;
		this.zoom = zoom;
		this.twelvehourformat = twelvehourformat;
		this.attributes = attributes;
		this.coordinateformat = coordinateformat;
		this.disabled = disabled;
		this.expirationtime = expirationtime;
		this.devicelimit = devicelimit;
		this.userlimit = userlimit;
		this.devicereadonly = devicereadonly;
		this.phone = phone;
		this.limitcommands = limitcommands;
		this.login = login;
		this.poilayer = poilayer;
		this.disablereports = disablereports;
		this.fixedemail = fixedemail;
		this.token = token;
		this.deviceList = deviceList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<tc_devices> getDeviceList() {
		return deviceList;
	}

	public void setDeviceList(List<tc_devices> deviceList) {
		this.deviceList = deviceList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHashedpassword() {
		return hashedpassword;
	}

	public void setHashedpassword(String hashedpassword) {
		this.hashedpassword = hashedpassword;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Boolean isReadonly() {
		return readonly;
	}

	public void setReadonly(Boolean readonly) {
		this.readonly = readonly;
	}

	public Boolean isAdministrator() {
		return administrator;
	}

	public void setAdministrator(Boolean administrator) {
		this.administrator = administrator;
	}

	public String getMap() {
		return map;
	}

	public void setMap(String map) {
		this.map = map;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Integer getZoom() {
		return zoom;
	}

	public void setZoom(Integer zoom) {
		this.zoom = zoom;
	}

	public Boolean isTwelvehourformat() {
		return twelvehourformat;
	}

	public void setTwelvehourformat(Boolean twelvehourformat) {
		this.twelvehourformat = twelvehourformat;
	}

	public String getAttributes() {
		return attributes;
	}

	public void setAttributes(String attributes) {
		this.attributes = attributes;
	}

	public String getCoordinateformat() {
		return coordinateformat;
	}

	public void setCoordinateformat(String coordinateformat) {
		this.coordinateformat = coordinateformat;
	}

	public Boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}

	public Timestamp getExpirationtime() {
		return expirationtime;
	}

	public void setExpirationtime(Timestamp expirationtime) {
		this.expirationtime = expirationtime;
	}

	public Integer getDevicelimit() {
		return devicelimit;
	}

	public void setDevicelimit(Integer devicelimit) {
		this.devicelimit = devicelimit;
	}

	public Integer getUserlimit() {
		return userlimit;
	}

	public void setUserlimit(Integer userlimit) {
		this.userlimit = userlimit;
	}

	public Boolean isDevicereadonly() {
		return devicereadonly;
	}

	public void setDevicereadonly(Boolean devicereadonly) {
		this.devicereadonly = devicereadonly;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Boolean isLimitcommands() {
		return limitcommands;
	}

	public void setLimitcommands(Boolean limitcommands) {
		this.limitcommands = limitcommands;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPoilayer() {
		return poilayer;
	}

	public void setPoilayer(String poilayer) {
		this.poilayer = poilayer;
	}

	public Boolean isDisablereports() {
		return disablereports;
	}

	public void setDisablereports(Boolean disablereports) {
		this.disablereports = disablereports;
	}

	public Boolean isFixedemail() {
		return fixedemail;
	}

	public void setFixedemail(Boolean fixedemail) {
		this.fixedemail = fixedemail;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}

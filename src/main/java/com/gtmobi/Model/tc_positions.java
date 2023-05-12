package com.gtmobi.Model;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class tc_positions {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "protocol", length = 128)
	private String protocol;
	@Column(name = "deviceid")
	private Integer deviceid;
	@Column(name = "servertime")
	private Timestamp servertime;
	@Column(name = "devicetime")
	private Timestamp devicetime;
	@Column(name = "fixtime")
	private Timestamp fixtime;
	@Column(name = "valid")
	private Boolean valid;
	@Column(name = "latitude")
	private Double latitude;
	@Column(name = "longitude")
	private Double longitude;
	@Column(name = "altitude")
	private Double altitude;
	@Column(name = "speed")
	private Double speed;
	@Column(name = "course")
	private Double course;
	@Column(name = "address", length = 512)
	private String address;
	@Column(name = "attributes", length = 4000)
	private String attributes;
	@Column(name = "accuracy")
	private Double accuracy;
	@Column(name = "network", length = 4000)
	private String network;

	public tc_positions() {
		super();
		// TODO Auto-generated constructor stub
	}

	public tc_positions(int id, String protocol, Integer deviceid, Timestamp servertime, Timestamp devicetime,
			Timestamp fixtime, Boolean valid, Double latitude, Double longitude, Double altitude, Double speed,
			Double course, String address, String attributes, Double accuracy, String network) {
		super();
		this.id = id;
		this.protocol = protocol;
		this.deviceid = deviceid;
		this.servertime = servertime;
		this.devicetime = devicetime;
		this.fixtime = fixtime;
		this.valid = valid;
		this.latitude = latitude;
		this.longitude = longitude;
		this.altitude = altitude;
		this.speed = speed;
		this.course = course;
		this.address = address;
		this.attributes = attributes;
		this.accuracy = accuracy;
		this.network = network;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public Integer getDeviceid() {
		return deviceid;
	}

	public void setDeviceid(Integer deviceid) {
		this.deviceid = deviceid;
	}

	public Timestamp getServertime() {
		return servertime;
	}

	public void setServertime(Timestamp servertime) {
		this.servertime = servertime;
	}

	public Timestamp getDevicetime() {
		return devicetime;
	}

	public void setDevicetime(Timestamp devicetime) {
		this.devicetime = devicetime;
	}

	public Timestamp getFixtime() {
		return fixtime;
	}

	public void setFixtime(Timestamp fixtime) {
		this.fixtime = fixtime;
	}

	public Boolean getValid() {
		return valid;
	}

	public void setValid(Boolean valid) {
		this.valid = valid;
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

	public Double getAltitude() {
		return altitude;
	}

	public void setAltitude(Double altitude) {
		this.altitude = altitude;
	}

	public Double getSpeed() {
		return speed;
	}

	public void setSpeed(Double speed) {
		this.speed = speed;
	}

	public Double getCourse() {
		return course;
	}

	public void setCourse(Double course) {
		this.course = course;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAttributes() {
		return attributes;
	}

	public void setAttributes(String attributes) {
		this.attributes = attributes;
	}

	public Double getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(Double accuracy) {
		this.accuracy = accuracy;
	}

	public String getNetwork() {
		return network;
	}

	public void setNetwork(String network) {
		this.network = network;
	}

}

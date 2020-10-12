package com.ondo.document;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "wearer")
public class WearerDOC {

	private String facilityId;
	private String wearerId;
	private String bandIdVal;
	private String skinTemp;
	private String ambTemp;
	private String accelometerVal;
	private String batteryLevel;
	private Date creationDate = new Date();

	/**
	 * @return the bandIdVal
	 */
	public String getBandIdVal() {
		return bandIdVal;
	}

	/**
	 * @param bandIdVal
	 *            the bandIdVal to set
	 */
	public void setBandIdVal(String bandIdVal) {
		this.bandIdVal = bandIdVal;
	}

	/**
	 * @return the skinTemp
	 */
	public String getSkinTemp() {
		return skinTemp;
	}

	/**
	 * @param skinTemp
	 *            the skinTemp to set
	 */
	public void setSkinTemp(String skinTemp) {
		this.skinTemp = skinTemp;
	}

	/**
	 * @return the ambTemp
	 */
	public String getAmbTemp() {
		return ambTemp;
	}

	/**
	 * @param ambTemp
	 *            the ambTemp to set
	 */
	public void setAmbTemp(String ambTemp) {
		this.ambTemp = ambTemp;
	}

	/**
	 * @return the accelometerVal
	 */
	public String getAccelometerVal() {
		return accelometerVal;
	}

	/**
	 * @param accelometerVal
	 *            the accelometerVal to set
	 */
	public void setAccelometerVal(String accelometerVal) {
		this.accelometerVal = accelometerVal;
	}

	/**
	 * @return the batteryLevel
	 */
	public String getBatteryLevel() {
		return batteryLevel;
	}

	/**
	 * @param batteryLevel
	 *            the batteryLevel to set
	 */
	public void setBatteryLevel(String batteryLevel) {
		this.batteryLevel = batteryLevel;
	}

	/**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate
	 *            the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * @return the facilityId
	 */
	public String getFacilityId() {
		return facilityId;
	}

	/**
	 * @param facilityId
	 *            the facilityId to set
	 */
	public void setFacilityId(String facilityId) {
		this.facilityId = facilityId;
	}

	/**
	 * @return the wearerId
	 */
	public String getWearerId() {
		return wearerId;
	}

	/**
	 * @param wearerId
	 *            the wearerId to set
	 */
	public void setWearerId(String wearerId) {
		this.wearerId = wearerId;
	}

}

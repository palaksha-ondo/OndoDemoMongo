package com.ondo.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class OndoResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3316733501404153973L;
	private Integer userId;
	private String wearerId;
	private String firstName;
	private String facilityId;
	private String batteryVal;
	private String lastName;
	private Float currentTemp;
	private Long timestamp;
	private Integer bandStatus;
	private List<ondoGraphPlot> graphDisplay;

	/**
	 * @return the userId
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the currentTemp
	 */
	public Float getCurrentTemp() {
		return currentTemp;
	}

	/**
	 * @param currentTemp the currentTemp to set
	 */
	public void setCurrentTemp(Float currentTemp) {
		this.currentTemp = currentTemp;
	}

	/**
	 * @return the bandStatus
	 */
	public Integer getBandStatus() {
		return bandStatus;
	}

	/**
	 * @param bandStatus the bandStatus to set
	 */
	public void setBandStatus(Integer bandStatus) {
		this.bandStatus = bandStatus;
	}

	/**
	 * @return the graphDisplay
	 */
	public List<ondoGraphPlot> getGraphDisplay() {
		return graphDisplay;
	}

	/**
	 * @param graphDisplay the graphDisplay to set
	 */
	public void setGraphDisplay(List<ondoGraphPlot> graphDisplay) {
		this.graphDisplay = graphDisplay;
	}

	/**
	 * @return the timestamp
	 */
	public Long getTimestamp() {
		return timestamp;
	}

	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * @return the facilityId
	 */
	public String getFacilityId() {
		return facilityId;
	}

	/**
	 * @param facilityId the facilityId to set
	 */
	public void setFacilityId(String facilityId) {
		this.facilityId = facilityId;
	}

	/**
	 * @return the batteryVal
	 */
	public String getBatteryVal() {
		return batteryVal;
	}

	/**
	 * @param batteryVal the batteryVal to set
	 */
	public void setBatteryVal(String batteryVal) {
		this.batteryVal = batteryVal;
	}

	/**
	 * @return the wearerId
	 */
	public String getWearerId() {
		return wearerId;
	}

	/**
	 * @param wearerId the wearerId to set
	 */
	public void setWearerId(String wearerId) {
		this.wearerId = wearerId;
	}

}

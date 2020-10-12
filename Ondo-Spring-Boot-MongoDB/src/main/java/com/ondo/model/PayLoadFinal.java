package com.ondo.model;

import java.io.Serializable;
import java.util.Date;

public class PayLoadFinal implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7050399113659307101L;
	private Integer bandId;
	private Float currentTemperature;
	private Float finalTemp;
	private Date time;
	private Date currentTime;
	private Integer brandTrendIndex;
	private String firstName;
	private String lastName;
	private Integer bandStatus;
	

	/**
	 * @return the bandId
	 */
	public Integer getBandId() {
		return bandId;
	}

	/**
	 * @param bandId
	 *            the bandId to set
	 */
	public void setBandId(Integer bandId) {
		this.bandId = bandId;
	}

	/**
	 * @return the currentTemperature
	 */
	public Float getCurrentTemperature() {
		return currentTemperature;
	}

	/**
	 * @param currentTemperature
	 *            the currentTemperature to set
	 */
	public void setCurrentTemperature(Float currentTemperature) {
		this.currentTemperature = currentTemperature;
	}

	/**
	 * @return the finalTemp
	 */
	public Float getFinalTemp() {
		return finalTemp;
	}

	/**
	 * @param finalTemp
	 *            the finalTemp to set
	 */
	public void setFinalTemp(Float finalTemp) {
		this.finalTemp = finalTemp;
	}

	/**
	 * @return the time
	 */
	public Date getTime() {
		return time;
	}

	/**
	 * @param time
	 *            the time to set
	 */
	public void setTime(Date time) {
		this.time = time;
	}

	/**
	 * @return the currentTime
	 */
	public Date getCurrentTime() {
		return currentTime;
	}

	/**
	 * @param currentTime
	 *            the currentTime to set
	 */
	public void setCurrentTime(Date currentTime) {
		this.currentTime = currentTime;
	}

	/**
	 * @return the brandTrendIndex
	 */
	public Integer getBrandTrendIndex() {
		return brandTrendIndex;
	}

	/**
	 * @param brandTrendIndex
	 *            the brandTrendIndex to set
	 */
	public void setBrandTrendIndex(Integer brandTrendIndex) {
		this.brandTrendIndex = brandTrendIndex;
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

}

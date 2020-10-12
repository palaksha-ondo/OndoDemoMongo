package com.ondo.document;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "dashboard")
public class DashboardDOC {

	private String userId;
	private String facilityId;
	private String firstName;
	private String lastName;
	private String userRole;
	private String bandId;
	private String wearerId;

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
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
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
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
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the userRole
	 */
	public String getUserRole() {
		return userRole;
	}

	/**
	 * @param userRole
	 *            the userRole to set
	 */
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	/**
	 * @return the bandId
	 */
	public String getBandId() {
		return bandId;
	}

	/**
	 * @param bandId
	 *            the bandId to set
	 */
	public void setBandId(String bandId) {
		this.bandId = bandId;
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

package com.ondo.persistence.dal;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "userinfo")
public class UserInfo {

	private String contact_name;
	private String age;
	private String sex;
	private String citizenship;

	/**
	 * @return the contact_name
	 */
	public String getContact_name() {
		return contact_name;
	}

	/**
	 * @param contact_name
	 *            the contact_name to set
	 */
	public void setContact_name(String contact_name) {
		this.contact_name = contact_name;
	}

	/**
	 * @return the age
	 */
	public String getAge() {
		return age;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(String age) {
		this.age = age;
	}

	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * @param sex
	 *            the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * @return the citizenship
	 */
	public String getCitizenship() {
		return citizenship;
	}

	/**
	 * @param citizenship
	 *            the citizenship to set
	 */
	public void setCitizenship(String citizenship) {
		this.citizenship = citizenship;
	}

}

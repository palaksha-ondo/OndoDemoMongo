package com.ondo.persistence.dal;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "address")
public class Address {

	private String name;
	private String blk_no;
	private String street;
	private String city;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the blk_no
	 */
	public String getBlk_no() {
		return blk_no;
	}

	/**
	 * @param blk_no
	 *            the blk_no to set
	 */
	public void setBlk_no(String blk_no) {
		this.blk_no = blk_no;
	}

	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param street
	 *            the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
}

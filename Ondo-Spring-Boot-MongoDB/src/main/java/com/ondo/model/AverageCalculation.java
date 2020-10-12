package com.ondo.model;

import java.util.Date;

public class AverageCalculation {

	private String skinTemp;
	private Date slicedHrs;

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
	 * @return the slicedHrs
	 */
	public Date getSlicedHrs() {
		return slicedHrs;
	}

	/**
	 * @param slicedHrs
	 *            the slicedHrs to set
	 */
	public void setSlicedHrs(Date slicedHrs) {
		this.slicedHrs = slicedHrs;
	}

}

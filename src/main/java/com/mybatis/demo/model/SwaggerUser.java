package com.mybatis.demo.model;

import java.sql.Date;

public class SwaggerUser {
	private String userName;
	private String eyeColor;
	private Integer height;
	private Integer weight;
	private Date birthday;

	/**
	 * @return the birthday
	 */
	public Date getBirthday() {
		return birthday;
	}

	/**
	 * @param birthday
	 *            the birthday to set
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	private Integer userAge;

	/**
	 * 
	 */
	public SwaggerUser() {
		super();
	}

	/**
	 * 
	 * @param userName
	 * @param eyeColor
	 * @param height
	 * @param weight
	 * @param birthday
	 * @param userAge
	 */
	public SwaggerUser(String userName, String eyeColor, Integer height, Integer weight, Date birthday,
			Integer userAge) {
		super();
		this.userName = userName;
		this.eyeColor = eyeColor;
		this.height = height;
		this.weight = weight;
		this.birthday = birthday;
		this.userAge = userAge;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the eyeColor
	 */
	public String getEyeColor() {
		return eyeColor;
	}

	/**
	 * @param eyeColor
	 *            the eyeColor to set
	 */
	public void setEyeColor(String eyeColor) {
		this.eyeColor = eyeColor;
	}

	/**
	 * @return the height
	 */
	public Integer getHeight() {
		return height;
	}

	/**
	 * @param height
	 *            the height to set
	 */
	public void setHeight(Integer height) {
		this.height = height;
	}

	/**
	 * @return the weight
	 */
	public Integer getWeight() {
		return weight;
	}

	/**
	 * @param weight
	 *            the weight to set
	 */
	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	/**
	 * @return the userAge
	 */
	public Integer getUserAge() {
		return userAge;
	}

	/**
	 * @param userAge
	 *            the userAge to set
	 */
	public void setUserAge(Integer userAge) {
		this.userAge = userAge;
	}

	@Override
	public String toString() {
		return "User [ userName=" + userName + ", eyeColor=" + eyeColor + ", height=" + height + ", weight=" + weight
				+ ", birthday=" + birthday + ", userAge=" + userAge + "]";
	}

}

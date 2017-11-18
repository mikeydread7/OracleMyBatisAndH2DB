package com.mybatis.demo.model;


public class User {
	private Integer userId;
	private String userName;
	private String eyeColor;
	private Integer height;
	private Integer weight;
	private Integer userAge;
	
	
	
	/**
	 * 
	 */
	public User() {
		super();
	}
	/**
	 * @param userId
	 * @param userName
	 * @param eyeColor
	 * @param height
	 * @param weight
	 * @param userAge
	 */
	public User(Integer userId, String userName, String eyeColor, Integer height, Integer weight, Integer userAge) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.eyeColor = eyeColor;
		this.height = height;
		this.weight = weight;
		this.userAge = userAge;
	}
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
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
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
	 * @param eyeColor the eyeColor to set
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
	 * @param height the height to set
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
	 * @param weight the weight to set
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
	 * @param userAge the userAge to set
	 */
	public void setUserAge(Integer userAge) {
		this.userAge = userAge;
	}
	
}




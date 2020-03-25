package com.keqi.springbootmapstruct.domain;

public class UserVO {

	private String username;

	private String userType;

	private String userTypeName;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserTypeName() {
		return userTypeName;
	}

	public void setUserTypeName(String userTypeName) {
		this.userTypeName = userTypeName;
	}

	@Override
	public String toString() {
		return "UserVO{" +
				"username='" + username + '\'' +
				", userType='" + userType + '\'' +
				", userTypeName='" + userTypeName + '\'' +
				'}';
	}
}

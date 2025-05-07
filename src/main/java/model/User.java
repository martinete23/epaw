package model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class User implements Serializable {

	private static final long serialVersionUID = -8465990321138923924L;

	private int id;
	private String name;
	private String password;
	private Date birthday;
	private String email;
	private String gender;
	private String platform;
	private String communitiesOfInterest;
	private String profilePicture;

	public User() {
		super();
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
        this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Date getBirthday() {
		return birthday;
	}
	
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getPlatform() {
		return platform;
	}
	
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	
	public String getCommunitiesOfInterest() {
		return communitiesOfInterest;
	}
	
	public void setCommunitiesOfInterest(String communitiesOfInterest) {
		this.communitiesOfInterest = communitiesOfInterest;
	}
	
	public String getProfilePicture() {
		return profilePicture;
	}
	
	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}

}
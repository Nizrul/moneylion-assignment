package moneylion.assignment.user;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import moneylion.assignment.common.BaseModel;

@Entity
@Table(name = "users")
public class User extends BaseModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -970824023544073803L;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "email")
	private String email;

	@Column(name = "roles")
	private String roles = "";
	
	@Column(name = "features")
	private String features = "";

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRoles() {
		if (!StringUtils.hasText(roles)) {
			return "";
		}
		return roles;
	}
	
	public List<String> getRolesAsList() {
		if (!StringUtils.hasText(roles)) {
			return new ArrayList<String>();
		}
		List<String> roleList = List.of(roles.split(",", -1));
		return roleList;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public String getFeatures() {
		if (!StringUtils.hasText(features)) {
			return "";
		}
		return features;
	}
	
	public List<String> getFeaturesAsList() {
		if (!StringUtils.hasText(features)) {
			return new ArrayList<String>();
		}
		List<String> featureList = List.of(features.split(",", -1));
		return featureList;
	}

	public void setFeatures(String features) {
		this.features = features;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override 
	public String toString() {
		return this.username + " | " + this.email + " | " + this.roles + " | " + this.features;
	}
}

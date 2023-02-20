package moneylion.assignment.feature;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;

public class FeatureRequestDTO {
	// only features available are feature and test
	@Pattern(regexp = "^feature|test$", message="Only available features are 'feature' and 'test'")
	private String featureName;
	
	@Email(message="Invalid email")
	private String email;
	
	private boolean enable;

	public String getFeatureName() {
		return featureName;
	}

	public void setFeatureName(String featureName) {
		this.featureName = featureName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}
}

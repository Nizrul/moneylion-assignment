package moneylion.assignment.feature;

public class FeatureResponseDTO {
	private boolean canAccess = false;
	
	public FeatureResponseDTO(boolean canAccess) {
		this.setCanAccess(canAccess);
	}

	public boolean isCanAccess() {
		return canAccess;
	}

	public void setCanAccess(boolean canAccess) {
		this.canAccess = canAccess;
	}
}

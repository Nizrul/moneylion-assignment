package moneylion.assignment.feature;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import moneylion.assignment.common.exception.ServiceUnavailableException;

@RestController
@RequestMapping("/feature")
public class FeatureController {
	@Autowired
	private FeatureService service;
	
	@GetMapping("")
	public FeatureResponseDTO hasAccess(@RequestParam("email") String email, 
			@RequestParam("featureName") String featureName, 
			Principal principal) throws ServiceUnavailableException {
		// NOTE: technically admins would have access to all features, but we'll return false since they might not explicitly have the feature enabled
		return new FeatureResponseDTO(service.canAccess(email, featureName));
	}
	
	@PostMapping("")
	public void updateFeatureAccess(@Valid @RequestBody() FeatureRequestDTO body) throws ServiceUnavailableException {
		service.updateFeatureAccess(body.getEmail(), body.getFeatureName(), body.isEnable());
	}
}

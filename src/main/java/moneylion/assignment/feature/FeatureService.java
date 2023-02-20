package moneylion.assignment.feature;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import moneylion.assignment.common.exception.NotModifiedException;
import moneylion.assignment.common.exception.ServiceUnavailableException;
import moneylion.assignment.common.helper.StringHelper;
import moneylion.assignment.user.User;
import moneylion.assignment.user.UserRepository;

@Service
public class FeatureService {
	@Autowired
	private UserRepository userRepository;
	
	public boolean canAccess(String email, String featureName) throws ServiceUnavailableException {
		try {
			Optional<User> user = userRepository.findByEmail(email);
			if (!user.isPresent()) {
	            throw new UsernameNotFoundException("User not found");
			}
			System.out.println(user.get().getFeatures());
			return user.get().getFeaturesAsList().contains(featureName);
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new ServiceUnavailableException();
		}
	}
	
	@Transactional
	public void updateFeatureAccess(String email, String featureName, boolean enable) throws ServiceUnavailableException {
		try {
			Optional<User> user = userRepository.findByEmail(email);
			if (!user.isPresent()) {
	            throw new UsernameNotFoundException("User not found");
			}
			List<String> featureList = new ArrayList<String>(user.get().getFeaturesAsList());
			if ((enable && featureList.contains(featureName)) || (!enable && !featureList.contains(featureName))) {
				throw new NotModifiedException("User feature access was not updated");
			}
			if (enable) {
				featureList.add(featureName);
			}
			else {
				featureList.remove(featureName);
			}
			String newFeatures = StringHelper.joinList(featureList);
			System.out.println(newFeatures);
			System.out.println(newFeatures == null);
			user.get().setFeatures(StringHelper.joinList(featureList));
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new ServiceUnavailableException();
		}
	}
}

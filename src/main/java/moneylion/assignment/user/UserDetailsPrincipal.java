package moneylion.assignment.user;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsPrincipal implements UserDetails {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1005;
	private User user;
	
	public UserDetailsPrincipal(User user) {
		System.out.println("Creating a new user");
		System.out.println(user);
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		List<GrantedAuthority> authorities
	      = new ArrayList<>();
		user.getRolesAsList().stream().map(role -> new SimpleGrantedAuthority("ROLE_"+role)).forEach(authorities::add);
		user.getFeaturesAsList().stream().map(role -> new SimpleGrantedAuthority("FEATURE_"+role)).forEach(authorities::add);
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUsername();
	}

	public String getEmail() {
		return user.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}

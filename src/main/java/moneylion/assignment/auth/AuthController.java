package moneylion.assignment.auth;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import moneylion.assignment.common.exception.UnauthenticatedException;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@GetMapping(value = "")
	public String healthCheck() {
		return "loggedIn";
	}

	@PostMapping(value = "/login")
    public String doLogin(HttpServletRequest request, String username, String password) throws UnauthenticatedException {
        try {
            request.login(username, password);
            return "Successfully logged in";
        } catch (ServletException e) {
        	e.printStackTrace();
            throw new UnauthenticatedException();
        }
    }
	
    @PostMapping(value = "/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        if (session != null) {
        	System.out.println(session.getServletContext());
            session.invalidate();
        }
        SecurityContextHolder.clearContext();
        return "Successfully logged out";
    }
}

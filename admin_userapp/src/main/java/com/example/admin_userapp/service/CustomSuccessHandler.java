package com.example.admin_userapp.service;

import java.io.IOException;
import java.util.Collection;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class CustomSuccessHandler implements AuthenticationSuccessHandler {

	private static final Logger logger = LoggerFactory.getLogger(CustomSuccessHandler.class);

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

		if (authorities == null || authorities.isEmpty()) {
			logger.error("Authorities collection is null or empty");
			response.sendRedirect("/error");
			return;
		}

		// Handling authorities safely
		Optional<String> role = authorities.stream().map(GrantedAuthority::getAuthority)
				.filter(roleStr -> roleStr != null && !roleStr.isEmpty()) // Filter out null and empty values
				.findFirst();

		if (role.isPresent()) {
			String r = role.get(); // Retrieve the role from the optional
			logger.info("User role: {}", r);
			try {
				if (r.equals("ADMIN")) {
					response.sendRedirect("/admin-page");
				} else if (r.equals("USER")) {
					response.sendRedirect("/user-page");
				} else {
					logger.warn("Unknown role: {}", r);
					response.sendRedirect("/error");
				}
			} catch (IOException e) {
				logger.error("Error redirecting user", e);
				throw new RuntimeException(e);
			}
		} else {
			logger.error("Role is not present in authorities");
			response.sendRedirect("/error");
		}
	}

}

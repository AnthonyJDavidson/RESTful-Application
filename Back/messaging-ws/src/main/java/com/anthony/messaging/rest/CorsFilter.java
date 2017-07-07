package com.anthony.messaging.rest;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

/**
 * cors filter
 * 
 * @author adavidso
 *
 */
public class CorsFilter extends OncePerRequestFilter {

	/**
	 * filter.
	 * @param request the request
	 * @param response the response
	 * @param filterChain the filterChain
	 * @throws ServletException the exception
	 * @throws IOException the exception
	 */
	@Override
	protected void doFilterInternal(final HttpServletRequest request,
											final HttpServletResponse response, final FilterChain filterChain)
																			throws ServletException, IOException {
		
		String origin = request.getHeader("Origin");
    	response.addHeader("Access-Control-Allow-Origin", origin);
    	response.addHeader("Access-Control-Allow-Credentials", "true");

		if (request.getHeader("Access-Control-Request-Method") != null && "OPTIONS".equals(request.getMethod())) {

			//CORS "pre-flight" request
        	response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
        	response.addHeader("Access-Control-Allow-Headers", "Content-Type");
    	}

    	filterChain.doFilter(request, response);

	}
}

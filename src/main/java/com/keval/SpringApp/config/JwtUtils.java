package com.keval.SpringApp.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.util.WebUtils;

import java.util.Collection;
import java.util.Date;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Component
public class JwtUtils {
    private static final String  SECRET_KEY = "@huoi#*sn!14SK";

    public String generateToken(UserDetails userDetails) {
        Date expirationDate = new Date(System.currentTimeMillis() + 1000*240);
        String token = Jwts.builder()
                .setSubject(userDetails.getUsername())
                .claim("roles", userDetails.getAuthorities())
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();

        return token;
    }

    public Claims getClaims(String token) {
    	return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }
    
    public String getUsername(String token) {    	
    	return getClaims(token).getSubject();
    }
    
    public Collection<? extends GrantedAuthority> getAuthorities(String token){
    	return (Collection<? extends GrantedAuthority>) getClaims(token).get("roles");
    }
    
    public boolean validateToken(String token) {
        try {
            Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
            return true;
        } catch (Exception e) {
        	System.out.println("Invalid Token");
            return false;
        }
    }
    
    public String getToken(HttpServletRequest request) {
    	 Cookie cookie = WebUtils.getCookie(request, "jwtToken");
    	 if(cookie!=null) {
    		 String token = cookie.getValue();
    		 return token;
    	 }
         return null;
    }
}
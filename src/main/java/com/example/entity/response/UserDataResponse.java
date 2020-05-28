package com.example.entity.response;

import java.util.Set;

public class UserDataResponse {
	
	private Long id;
	
	private String username;
	 
    private String email;
    
    private Set<String> roles;

    private String password;

    private boolean active;

    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
    
    public Set<String> getRoles() {
      return this.roles;
    }
    
    public void setRoles(Set<String> roles) {
      this.roles = roles;
    }
}	
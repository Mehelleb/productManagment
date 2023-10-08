package com.apiproduct.api.model;

import jakarta.persistence.Id;
import lombok.Data;

@Data
public class UsersRoles {
	@Id
	private String username;
	private String role;

}

package com.techelevator.message_board.services;

import com.techelevator.util.BasicLogger;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;

import com.techelevator.message_board.model.User;

public class UserService extends AuthenticatedApiService {

	public UserService(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public User[] retrieveAllUsers() {
        User[] users = null;
        try {
            ResponseEntity<User[]> response =
                    restTemplate.exchange(baseUrl + "users", HttpMethod.GET, makeAuthEntity(), User[].class);
            users = response.getBody();
        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
		return users;
	}
}

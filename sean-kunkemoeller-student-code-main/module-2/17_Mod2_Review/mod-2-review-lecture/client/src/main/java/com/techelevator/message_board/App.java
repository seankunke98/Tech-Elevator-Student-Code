package com.techelevator.message_board;


import java.util.ArrayList;
import java.util.List;

import com.techelevator.message_board.model.*;

import com.techelevator.message_board.services.AuthenticationService;

import com.techelevator.message_board.services.UserService;
import com.techelevator.message_board.services.ConsoleService;

public class App {
    private static final String API_BASE_URL = "http://localhost:8080/";

    private final ConsoleService consoleService = new ConsoleService();
    private final AuthenticationService authenticationService = new AuthenticationService(API_BASE_URL);
    private final UserService userService = new UserService(API_BASE_URL);

    private AuthenticatedUser currentUser;

    public static void main(String[] args) {
		App app = new App();
    	app.run();
    }

	private void run() {
        consoleService.printGreeting();
        loginMenu();
        if (currentUser != null) {
            mainMenu();
        }
	}

    private void loginMenu() {
        int menuSelection = -1;
        while (menuSelection != 0 && currentUser == null) {
            consoleService.printLoginMenu();
            menuSelection = consoleService.promptForMenuSelection("Please choose an option: ");
            if (menuSelection == 1) {
                handleRegister();
            } else if (menuSelection == 2) {
                handleLogin();
            } else if (menuSelection != 0) {
                System.out.println("Invalid Selection");
                consoleService.pause();
            }
        }
    }

    private void handleRegister() {
        System.out.println("Please register a new user account");
        UserCredentials credentials = consoleService.promptForCredentials();
        if (authenticationService.register(credentials)) {
            System.out.println("Registration successful. You can now login.");
        } else {
            consoleService.printErrorMessage();
        }
    }

    private void handleLogin() {
        UserCredentials credentials = consoleService.promptForCredentials();
        currentUser = authenticationService.login(credentials);
        if (currentUser != null) {
            String token = currentUser.getToken();
            userService.setAuthToken(token);
        } else {
           consoleService.printErrorMessage();
        }
    }

    private void mainMenu() {
        int menuSelection = -1;
        while (menuSelection != 0) {
            consoleService.printMainMenu();
            menuSelection = consoleService.promptForMenuSelection("Please choose an option: ");
            if (menuSelection == 1) {
                //viewAllMessages();
            } else if (menuSelection == 2) {
                //viewUsersMessages();
            } else if (menuSelection == 3) {
                //sendMessage();
            } else if (menuSelection == 0) {
                continue;
            } else {
                System.out.println("Invalid Selection");
            }
            consoleService.pause();
		}
	}


    private List<User> getAllUsers(User[] users){
        List<User> userList = new ArrayList<>();
        for (User u : users){
            if (u.getId() != currentUser.getUser().getId()){
                userList.add(u);
            }
        }
        return userList;
    }


}

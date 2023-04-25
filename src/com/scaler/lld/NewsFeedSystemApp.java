package com.scaler.lld;

import com.scaler.lld.controller.UserController;
import com.scaler.lld.exception.ExistingUserIdOrEmailIdException;
import com.scaler.lld.exception.InvalidUserIdOrPasswordException;
import com.scaler.lld.exception.PasswordReEnteredPasswordMismatch;
import com.scaler.lld.repository.UserRepository;
import com.scaler.lld.service.UserService;
import com.scaler.lld.service.impl.UserServiceImpl;

import java.util.Scanner;

public class NewsFeedSystemApp {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();
        UserService userService = new UserServiceImpl(userRepository);
        UserController userController = new UserController(userService);

        String command1 = "SignUp";
        String command2 = "Login";
        String command = command1;
        while(command.equals(command1) || command.equals(command2)) {
            System.out.println("Type Command. Available commands are:");
            System.out.println(command1);
            System.out.println(command2);
            Scanner scanner = new Scanner(System.in);
            command = scanner.next();

            if (command.equalsIgnoreCase(command1)) {
                System.out.println("Enter UserId:");
                String userId = scanner.next();
                System.out.println("Enter EmailId:");
                String emailId = scanner.next();
                System.out.println("Enter password:");
                String password = scanner.next();
                System.out.println("Re-Enter password:");
                String password1 = scanner.next();
                try {
                    userController.signUp(userId, emailId, password, password1);
                    System.out.println("User sign up successfully.......");
                } catch (ExistingUserIdOrEmailIdException e) {
                    System.out.println(e.getMessage());
                } catch (PasswordReEnteredPasswordMismatch passwordReEnteredPasswordMismatch) {
                    System.out.println(passwordReEnteredPasswordMismatch.getMessage());
                }
            } else if (command.equalsIgnoreCase(command2)) {
                System.out.println("Enter login UserId:");
                String userId = scanner.next();
                System.out.println("Enter login password:");
                String password = scanner.next();
                try {
                    String sessionId = userController.authentic(userId, password);
                    System.out.println("User Logged in successfully....." + sessionId);
                } catch (InvalidUserIdOrPasswordException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println("Invalid command. Try again.....");
            }
        }
    }
}

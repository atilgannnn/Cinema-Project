package com.runners.cinema.exception;

public class ErrorMessage {

    public static final String USER_NOT_FOUND = "User not found with email : %s";
    public static final String TOKEN_ERROR_MESSAGE = "JwtToken validation Error : %s";
    public static final String CONFLICT_EXCEPTION_MESSAGE = "This email address has already been registered  : %s";
    public static final String ROLE_NOT_FOUND = "Invalid roletype : %s";
    public static final String CURRENT_USER_NOT_FOUND_MESSAGE = "Current User not found";
}

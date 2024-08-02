package com.firstApp.person;

public record PersonRegistrationRequest(
    String name  , 
    String email, 
    String password,
    Integer age
) {
} 

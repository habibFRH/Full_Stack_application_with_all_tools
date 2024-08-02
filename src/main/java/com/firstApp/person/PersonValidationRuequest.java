package com.firstApp.person;

public record PersonValidationRuequest(
    String name , 
    String email, 
    String password,
    Integer age 
) {
    
}

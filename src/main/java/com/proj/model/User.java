package com.proj.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String city;
}

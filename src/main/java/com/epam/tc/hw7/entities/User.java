package com.epam.tc.hw7.entities;

import com.jdiai.tools.DataClass;

public class User extends DataClass<User> {
    public static final User ROMAN = new User("Roman", "Jdi1234");

    public String userName;
    public String password;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}

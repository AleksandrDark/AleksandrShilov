package com.epam.tc.hw7.entities;

import com.jdiai.tools.DataClass;

public class User extends DataClass<User> {
    public static final User ROMAN = new User("Roman", "Jdi1234", "ROMAN IOVLEV");
    public String expectedUserName;
    public String userName;
    public String password;

    public User(String userName, String password, String expectedUserName) {
        this.userName = userName;
        this.password = password;
        this.expectedUserName = expectedUserName;
    }

    public String getExpectedUserName() {
        return expectedUserName;
    }
}

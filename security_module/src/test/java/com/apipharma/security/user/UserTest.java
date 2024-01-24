package com.apipharma.security.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private User user;

    @BeforeEach
    void setUp() {
        user = User.builder()
                .id(1)
                .firstname("John")
                .lastname("Doe")
                .email("john.doe@example.com")
                .password("password")
                .role(Role.USER)
                .build();
    }

    @Test
    void testUserInitialization() {
        assertNotNull(user);
    }


    @Test
    void testgetUserId() {
        assertEquals(1,user.getId(), "not equals");
    }


    @Test
    void testgetFirstname() {
        assertEquals("John",user.getFirstname(), "not equals");
    }

    @Test
    void getLastname() {
        assertEquals("Doe",user.getLastname(), "not equals");
    }

    @Test
    void getEmail() {
        assertEquals("john.doe@example.com",user.getEmail(), "not equals");

    }

    @Test
    void getRole() {
        assertEquals("USER",user.getRole().toString(), "not equals");
    }

    @Test
    void setId() {
        int newId = 2;
        user.setId(newId);
        assertEquals(newId, user.getId(), "not equals");
    }

    @Test
    void setFirstname() {
        String newFirstname = "Jane";
        user.setFirstname(newFirstname);
        assertEquals(newFirstname, user.getFirstname(), "not equals");
    }

    @Test
    void setLastname() {
        String newLastname = "Smith";
        user.setLastname(newLastname);
        assertEquals(newLastname, user.getLastname(), "not equals");
    }

    @Test
    void setEmail() {
        String newEmail = "jane.smith@example.com";
        user.setEmail(newEmail);
        assertEquals(newEmail, user.getEmail(), "not equals");
    }

    @Test
    void setPassword() {
        String newPassword = "newpassword";
        user.setPassword(newPassword);
        assertEquals(newPassword, user.getPassword(), "not equals");
    }

    @Test
    void setRole() {
        Role newRole = Role.ADMIN;
        user.setRole(newRole);
        assertEquals(newRole.toString(), user.getRole().toString(), "not equals");
    }
}
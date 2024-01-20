package com.apipharma.security.user;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.*;

class RoleTest {

    @Test
    void enumValues() {
        // Ensure the correct number of enum values
        assertEquals(2, Role.values().length);
    }

    @Test
    void testUser() {
        assertEquals(Role.USER, Role.valueOf("USER"));
    }

    @Test
    void testAdmin() {
        assertEquals(Role.ADMIN, Role.valueOf("ADMIN"));
    }


}
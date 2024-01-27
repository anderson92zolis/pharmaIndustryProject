package com.apipharma.security.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest()
class DemoControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
    }

    @Test
    @DisplayName("greeting test")
    void testSayHello() throws Exception {

        //when
        mockMvc.perform(get("/api/v1/demo-controller/test")
                        .contentType(MediaType.APPLICATION_JSON))

                //then
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().string(equalTo("Hello from your Api")));
    }

    @Test
    @DisplayName("bye test")
    void testSayGoodBye() throws Exception {

        //when
        mockMvc.perform(get("/api/v1/demo-controller/say-good-bye")
                        .contentType(MediaType.APPLICATION_JSON))

                //then
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().string(equalTo("Bye Bye from your Api")));
    }
}
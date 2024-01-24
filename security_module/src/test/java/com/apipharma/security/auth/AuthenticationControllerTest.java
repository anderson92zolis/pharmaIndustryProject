package com.apipharma.security.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AuthenticationController.class)
class AuthenticationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Mock
    private AuthenticationService authenticationService;

    @InjectMocks
    private AuthenticationController authenticationController;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(authenticationController).build();
    }


    @Test
    void testRegister() throws Exception {
        // Arrange
        RegisterRequest registerRequest = new RegisterRequest("username", "password","email@gmail.com","12345789");
        AuthenticationResponse authenticationResponse = new AuthenticationResponse("token");

        when(authenticationService.register(any(RegisterRequest.class))).thenReturn(authenticationResponse);

        // Act
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/api/v1/auth/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(registerRequest));

        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andReturn();

        // Assert
        String responseBody = result.getResponse().getContentAsString();
        AuthenticationResponse response = objectMapper.readValue(responseBody, AuthenticationResponse.class);

        // Perform additional assertions as needed
        // For example, assert that the response token matches the expected value
        // assertEquals("expectedTokenValue", response.getToken());
    }

    @Test
    void testAuthenticate() throws Exception {
        // Arrange
        AuthenticationRequest authenticationRequest = new AuthenticationRequest("username", "password");
        AuthenticationResponse authenticationResponse = new AuthenticationResponse("token");

        when(authenticationService.authenticate(any(AuthenticationRequest.class))).thenReturn(authenticationResponse);

        // Act
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/api/v1/auth/authenticate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(authenticationRequest));

        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andReturn();

        // Assert
        String responseBody = result.getResponse().getContentAsString();
        AuthenticationResponse response = objectMapper.readValue(responseBody, AuthenticationResponse.class);

        // Perform additional assertions as needed
        // For example, assert that the response token matches the expected value
        // assertEquals("expectedTokenValue", response.getToken());
    }

    private static String asJsonString(final Object obj) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
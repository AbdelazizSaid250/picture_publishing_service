package com.example.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.example.model.dto.AuthDto;
import com.example.service.user.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {AuthUserController.class})
@ExtendWith(SpringExtension.class)
class AuthUserControllerTest {
    @Autowired
    private AuthUserController authUserController;

    /**
     * Method under test: {@link AuthUserController#signUp(AuthDto.SignUpDto)}
     */
    @Test
    void testSignUp() {
        UserService userService = mock(UserService.class);
        doNothing().when(userService).saveOrUpdate(any());
        AuthUserController authUserController = new AuthUserController(userService);
        authUserController.signUp(new AuthDto.SignUpDto("Abdelaziz", "abdelaziz.said@example.org", "my_password"));
        verify(userService).saveOrUpdate(any());
    }

    /**
     * Method under test: {@link AuthUserController#welcome()}
     */
    @Test
    void testWelcome() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/logout");
        MockMvcBuilders.standaloneSetup(authUserController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("<h1>Successfully Logged Out</h1>"));
    }

    /**
     * Method under test: {@link AuthUserController#welcome()}
     */
    @Test
    void testWelcome2() throws Exception {
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/logout");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(authUserController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("<h1>Successfully Logged Out</h1>"));
    }
}


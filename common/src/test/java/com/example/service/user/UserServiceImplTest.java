package com.example.service.user;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.dao.UserRepository;
import com.example.model.dto.AuthDto;
import com.example.model.entity.User;

import java.util.UUID;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {UserServiceImpl.class})
@ExtendWith(SpringExtension.class)
class UserServiceImplTest {
    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserServiceImpl userServiceImpl;

    /**
     * Method under test: {@link UserServiceImpl#saveOrUpdate(AuthDto.SignUpDto)}
     */
    @Test
    void testSaveOrUpdate() {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setId(UUID.randomUUID());
        user.setName("Name");
        user.setPassword("iloveyou");
        when(userRepository.save((User) any())).thenReturn(user);
        userServiceImpl.saveOrUpdate(new AuthDto.SignUpDto("Name", "jane.doe@example.org", "iloveyou"));
        verify(userRepository).save((User) any());
    }
}


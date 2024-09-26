package group25.group25;

import group25.group25.usermanagement.controller.UserController;
import group25.group25.usermanagement.model.User;
import group25.group25.usermanagement.repository.UserRepository;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ForgetPasswordTest {

    @MockBean
    UserRepository userRepository;

    @Autowired
    UserController controller;

    @Test
    void testShowUserByPassword(){
        String mail = "testPassword@test.com";
        User tempUser = new User("testPassword@test.com","testFname","testLname","testPassword","testUsername", "answer");
        when(controller.showUserByPassword(mail)).thenReturn(tempUser);
        assertEquals(tempUser, controller.showUserByPassword(mail),"wrong testShowUserByPassword");
    }

    @Test
    void testUpdateUserPasswordByEmail(){

        String newPassword = "newPassword";
        String mail = "testPassword@test.com";
        userRepository.updateUserPasswordByEmail(newPassword,mail);
        verify(userRepository).updateUserPasswordByEmail(newPassword,mail);
    }


}

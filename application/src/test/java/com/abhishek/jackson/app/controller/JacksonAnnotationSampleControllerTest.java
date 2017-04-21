package com.abhishek.jackson.app.controller;

import com.abhishek.jackson.types.CreditCard;
import com.abhishek.jackson.types.User;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author Abhishek Bhardwaj
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JacksonAnnotationSampleControllerTest {
    
    @Autowired
    private JacksonAnnotationSampleController controller;
    
    @Test
    public void contextLoads() throws Exception {
        Assertions.assertThat(controller).isNotNull();
    }
    
    @Test
    public void getUser() throws Exception {
        User user = controller.getUser();
        
        Assertions.assertThat(user).isNotNull();
        Assertions.assertThat(user.getFirstName()).isEqualTo("Jane");
        Assertions.assertThat(user.getLastName()).isEqualTo("Doe");
        Assertions.assertThat(user.getAge()).isEqualTo("24");
    }
    
    @Test
    public void getCardInfo() throws Exception {
        CreditCard card = controller.getCC();
        
        Assertions.assertThat(card).isNotNull();
        Assertions.assertThat(card.getCardAlias()).isEqualTo("Abhishek");
        Assertions.assertThat(card.getCardHolderFirstName()).isEqualTo("Abhishek");
        Assertions.assertThat(card.getCardHolderLastName()).isEqualTo("Bhardwaj");
    }
}

package com.abhishek.jackson.app.controller;

import com.abhishek.jackson.types.CreditCard;
import com.abhishek.jackson.types.User;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author Abhishek Bhardwaj
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class JacksonAnnotationSampleControllerRestTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getUser() throws Exception {
        User user = this.restTemplate.getForObject("http://localhost:" + this.port + "/user", User.class);

        Assertions.assertThat(user).isNotNull();
        Assertions.assertThat(user.getFirstName()).isEqualTo("Jane");
        Assertions.assertThat(user.getLastName()).isEqualTo("Doe");
        Assertions.assertThat(user.getAge()).isEqualTo("24");
    }

    @Test
    public void getCreditCard() throws Exception {
        CreditCard card = this.restTemplate.getForObject("http://localhost:" + this.port + "/cardInfo", CreditCard.class);
        
        Assertions.assertThat(card).isNotNull();
        Assertions.assertThat(card.getCardAlias()).isEqualTo("Abhishek");
        Assertions.assertThat(card.getCardHolderFirstName()).isEqualTo("Abhishek");
        Assertions.assertThat(card.getCardHolderLastName()).isEqualTo("Bhardwaj");
        Assertions.assertThat(card.getCvv()).isEqualTo("123");
        Assertions.assertThat(card.getCardNumber()).isNull();
    }
}

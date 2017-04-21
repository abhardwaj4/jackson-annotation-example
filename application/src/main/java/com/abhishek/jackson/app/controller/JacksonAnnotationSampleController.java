package com.abhishek.jackson.app.controller;

import com.abhishek.jackson.types.CreditCard;
import com.abhishek.jackson.types.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Abhishek Bhardwaj
 */
@RestController
public class JacksonAnnotationSampleController {
    
    @GetMapping("/user")
    public User getUser() {
        User usr = new User();
        usr.setAge("24");
        usr.setFirstName("Jane");
        usr.setLastName("Doe");
        return usr;
    }
    
    @GetMapping("/cardInfo")
    public CreditCard getCC() {
        CreditCard card = new CreditCard();
        card.setCardAlias("Abhishek");
        card.setCardNumber("1111111111111111");
        card.setCardHolderFirstName("Abhishek");
        card.setCardHolderLastName("Bhardwaj");
        card.setCvv("123");
        return card;
    }
    
}

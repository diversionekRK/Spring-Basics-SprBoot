package com.div.spring;

import com.div.spring.dao.OfferRepository;
import com.div.spring.dao.User;
import com.div.spring.dao.UserRepository;
import com.div.spring.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Div on 2018-05-10.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootApplication.class)
public class UserTests {
    @Autowired
    private UserRepository userRepository;
    private static final Logger log = LoggerFactory.getLogger(SpringbootApplication.class);

    @Before
    public void init() {
        userRepository.deleteAll();
    }

    @Test
    public void givenUserRepository_whenSaveAndRetrieveUserEntity_thenOK() {
//        List<User> users = userRepository.findAll();
//        User user = userRepository.findByUsername("testuser2");

        User userEntity = userRepository.save(
                new User("testuser", "testuser",
                        "testuser@gmail.com", "testuser",
                        true, "ROLE_USER")
        );

        User retrievedEntity = userRepository.findByUsername("testuser");

        assertNotNull("Retrieved entity is not null", retrievedEntity);
        assertEquals("Saved and retrieved entity should be equal", userEntity, retrievedEntity);
        log.info(retrievedEntity.toString());
    }
}

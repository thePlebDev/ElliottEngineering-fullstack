package com.Elliott.Engineering.Website.Repositories;

import com.Elliott.Engineering.Website.Models.User;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class UserRepositoryTest {


    @Autowired
    private UserRepository underTest;

    @Test
    public void testFindByEmailTrue(){
        //GIVEN
        String EXPECTED_USERNAME ="BOB";
        User user = new User(EXPECTED_USERNAME,"12345","bob@bobamil.com");

        //WHEN
        User foundUser = underTest.save(user);


        //THEN
        assertThat(foundUser.getUsername()).isEqualTo(EXPECTED_USERNAME);

    }
}

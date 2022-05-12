package com.Elliott.Engineering.Website.Repositories;

import com.Elliott.Engineering.Website.Models.Calf;
import com.Elliott.Engineering.Website.Models.Types.CalfTypes;
import com.Elliott.Engineering.Website.Models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;

@DataJpaTest
public class CalfRepositoryTest {
    //get all calves that belong to certain user
    //get calves by tag number
    //save calf
    //delete calf

    @Autowired
    private CalfRepository underTest;

    @Autowired
    private UserRepository userRepository;




    @Test
    public void findAllCalvesByUserId(){
        //GIVEN
        User user = new User("bob","12345","bob@bobmail.com","meat");
        Calf calf = new Calf("22de","3243d","another one",CalfTypes.BULL,23423);
        Calf calf1 = new Calf("22de","3243d","another one",CalfTypes.BULL,3243243);

        //WHEN
        User savedUser = userRepository.save(user);
        Calf savedCalf = underTest.save(calf);
        Calf savedCalf1 = underTest.save(calf1);

        savedCalf.setUser(savedUser);
        savedCalf1.setUser(savedUser);

        //THEN
        Long savedId = savedUser.getId();
        List<Calf> calfList = underTest.findAllCalvesByUserId(savedId).get();
        assertThat(calfList.size()).isEqualTo(2);

    }

    @Test
    public void findAllCalvesByCowTag(){
        //GIVEN
        String EXPECTED_COW_TAG = "meatball3";
        Calf calf = new Calf("22de",EXPECTED_COW_TAG,"another one",CalfTypes.BULL,432432);

        //WHEN
        underTest.save(calf);

        //THEN
        List<Calf> savedCalf = underTest.findAllCalvesByCowTag(EXPECTED_COW_TAG).get();
        assertThat(savedCalf.size()).isEqualTo(1);
    }

    @Test
    public void findCalfByTagNumber(){
        //GIVEN
        String EXPECTED_CALF_TAG = "meatball3";
        Calf calf = new Calf(EXPECTED_CALF_TAG,"33e4","another one",CalfTypes.BULL,2432432);

        //WHEN
        underTest.save(calf);
        List<Calf> calfList = underTest.findCalfByTagNumber(EXPECTED_CALF_TAG).get();

        //THEN
        assertThat(calfList.size()).isEqualTo(1);
    }

}

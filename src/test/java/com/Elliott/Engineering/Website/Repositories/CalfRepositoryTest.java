package com.Elliott.Engineering.Website.Repositories;

import com.Elliott.Engineering.Website.Models.Calf;
import com.Elliott.Engineering.Website.Models.Cow;
import com.Elliott.Engineering.Website.Models.Types.CalfTypes;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Date;
import java.util.List;

@DataJpaTest
public class CalfRepositoryTest {

    @Autowired
    private CalfRepository underTest;


    @Test
    public void findByTagNumberTest(){
        //GIVEN
        String EXPECTED_TAGNUMBER = "112dr";
        Cow cow = new Cow();
        Calf calf = new Calf(EXPECTED_TAGNUMBER,cow,"antoher one", CalfTypes.BULL);

        //WHEN
        underTest.save(calf);
        Calf foundCalf = underTest.findCalfByTagNumber(EXPECTED_TAGNUMBER).orElseThrow(()-> new IllegalStateException("not found"));


        //THEN
        assertThat(foundCalf.getTagNumber()).isEqualTo(EXPECTED_TAGNUMBER);


    }

    @Test
    public void findBySex(){
        //GIVEN
        CalfTypes EXPECTED_SEX = CalfTypes.BULL;
        Cow cow = new Cow();
        Calf calf = new Calf("12wdew",cow,"antoher one",EXPECTED_SEX);

        //WHEN
        underTest.save(calf);
        List<Calf> bulls = underTest.findCalfBySex(EXPECTED_SEX.toString()).orElseThrow(()-> new IllegalStateException("not found"));

        //THEN
        assertThat(bulls.get(0).getSex()).isEqualTo(EXPECTED_SEX);
    }

    @Test
    public void findByCowId(){
        //GIVEN
        String EXPECTED_TAG_NUMBER = "DSAF8";
        Cow cow = new Cow();
        Calf calf = new Calf(EXPECTED_TAG_NUMBER,cow,"antoher one",CalfTypes.BULL);

        //WHEN
        Calf savedCalf = underTest.save(calf);
        Long cowId = savedCalf.getCow().getId();

        List<Calf> returnedCalves = underTest.findCalfByCowId(cowId).orElseThrow(()-> new IllegalStateException("not found"));
        Calf returnedCalf = returnedCalves.get(0);

        //THEN
        assertThat(returnedCalf.getTagNumber()).isEqualTo(EXPECTED_TAG_NUMBER);

    }
}

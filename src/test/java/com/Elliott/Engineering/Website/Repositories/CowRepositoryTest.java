package com.Elliott.Engineering.Website.Repositories;

import com.Elliott.Engineering.Website.Models.Cow;
import com.Elliott.Engineering.Website.Models.Herd;
import com.Elliott.Engineering.Website.Models.Types.CowTypes;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class CowRepositoryTest {

    @Autowired
    CowRepository underTest;

    @Test
    public void findCowByTagNumberTest(){
        //GIVEN
        Herd herd = new Herd();
        String EXPECTED_TAG_NUMBER = "432TRE";
        Cow cow = new Cow(herd,EXPECTED_TAG_NUMBER, CowTypes.OPEN);

        //WHEN
        underTest.save(cow);
        Cow returnedCow = underTest.findCowByTagNumber(EXPECTED_TAG_NUMBER).orElseThrow(()-> new IllegalStateException("not found"));

        //THEN
        assertThat(returnedCow.getTagNumber()).isEqualTo(EXPECTED_TAG_NUMBER);

    }

    @Test
    public void findCowsByStatus(){
        //GIVEN
        Herd herd = new Herd();
        String EXPECTED_TAG_NUMBER = "432TRE";
        Cow cow1 = new Cow(herd,EXPECTED_TAG_NUMBER, CowTypes.OPEN);
        Cow cow2 = new Cow(herd,EXPECTED_TAG_NUMBER, CowTypes.OPEN);

        //WHEN
        underTest.save(cow1);
        underTest.save(cow2);
        List<Cow> cowList = underTest.findCowsByStatus(CowTypes.OPEN.toString()).orElseThrow(()-> new IllegalStateException("NOT FOUND"));

        //THEN
        assertThat(cowList.size()).isEqualTo(2);
    }

    @Test
    public void findAllCows(){
        //GIVEN
        Herd herd = new Herd();
        String EXPECTED_TAG_NUMBER = "432TRE";
        Cow cow1 = new Cow(herd,EXPECTED_TAG_NUMBER, CowTypes.OPEN);
        Cow cow2 = new Cow(herd,EXPECTED_TAG_NUMBER, CowTypes.OPEN);

        //WHEN
        underTest.save(cow1);
        underTest.save(cow2);
        List<Cow> cowList = underTest.findAllCows().orElseThrow(()-> new IllegalStateException("NOT FOUND"));

        //THEN
        assertThat(cowList.size()).isEqualTo(2);
    }


}

package com.Elliott.Engineering.Website.Repositories;

import com.Elliott.Engineering.Website.Models.Herd;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;

@DataJpaTest
public class HerdRepositoryTest {

    @Autowired
    HerdRepository underTest;


    @Test
    public void findAllHerdTest(){
        //GIVEN
        Herd herd1 = new Herd();
        Herd herd2 = new Herd();

        //WHEN
        underTest.save(herd1);
        underTest.save(herd2);
        List<Herd> herdList = underTest.findAllHerd().orElseThrow(()->new IllegalStateException("Not found"));


        //THEN
        assertThat(herdList.size()).isEqualTo(2);


    }
}

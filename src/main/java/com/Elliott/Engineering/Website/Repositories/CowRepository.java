package com.Elliott.Engineering.Website.Repositories;

import com.Elliott.Engineering.Website.Models.Cow;
import com.Elliott.Engineering.Website.Models.Types.CowTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface CowRepository extends JpaRepository<Cow,Long> {



    @Query(value="SELECT * FROM cow WHERE cow.tag_number = ?1",nativeQuery = true)
    Optional<Cow> findCowByTagNumber(String tagNumber);

    @Query(value ="SELECT * FROM cow WHERE cow.status = ?1",nativeQuery = true)
    Optional<List<Cow>> findCowsByStatus(String status);

    @Query(value="SELECT * FROM cow", nativeQuery = true)
    Optional<List<Cow>> findAllCows();
}

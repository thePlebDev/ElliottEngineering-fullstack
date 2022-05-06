package com.Elliott.Engineering.Website.Repositories;

import com.Elliott.Engineering.Website.Models.Calf;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CalfRepository extends JpaRepository<Calf,Long> {

    @Query(value = "SELECT * FROM calf WHERE calf.tagNumber = ?1",nativeQuery = true)
    public Optional<Calf> findCalfByTagNumber(String tagNumber);
}

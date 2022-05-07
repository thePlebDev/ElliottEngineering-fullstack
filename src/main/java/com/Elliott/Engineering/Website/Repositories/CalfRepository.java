package com.Elliott.Engineering.Website.Repositories;

import com.Elliott.Engineering.Website.Models.Calf;
import com.Elliott.Engineering.Website.Models.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface CalfRepository extends JpaRepository<Calf,Long> {


    @Query(value = "SELECT * FROM calf WHERE calf.tag_number = ?1",nativeQuery = true)
    public Optional<Calf> findCalfByTagNumber(String tagNumber);


    @Query(value = "SELECT * FROM calf WHERE calf.sex = ?1",nativeQuery = true)
    public Optional<List<Calf>> findCalfBySex(String sex);

    @Query(value = "SELECT * FROM calf WHERE calf.cow_id = ?1",nativeQuery = true)
    public Optional<List<Calf>> findCalfByCowId(Long id);

}

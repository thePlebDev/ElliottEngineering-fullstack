package com.Elliott.Engineering.Website.Repositories;

import com.Elliott.Engineering.Website.Models.Herd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HerdRepository extends JpaRepository<Herd,Long> {

    @Query(value="SELECT * FROM herd",nativeQuery = true)
    public Optional<List<Herd>> findAllHerd();
}

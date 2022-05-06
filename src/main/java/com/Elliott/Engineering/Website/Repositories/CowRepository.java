package com.Elliott.Engineering.Website.Repositories;

import com.Elliott.Engineering.Website.Models.Cow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CowRepository extends JpaRepository<Cow,Long> {
}

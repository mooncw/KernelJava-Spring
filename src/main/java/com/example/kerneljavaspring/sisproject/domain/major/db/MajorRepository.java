package com.example.kerneljavaspring.sisproject.domain.major.db;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MajorRepository extends JpaRepository<MajorEntity, Long> {
    MajorEntity findByTitle(String Title);
}

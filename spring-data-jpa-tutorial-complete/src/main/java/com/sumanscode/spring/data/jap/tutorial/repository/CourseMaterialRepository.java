package com.sumanscode.spring.data.jap.tutorial.repository;

import com.sumanscode.spring.data.jap.tutorial.entity.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMaterialRepository extends JpaRepository<CourseMaterial, Long> {

}

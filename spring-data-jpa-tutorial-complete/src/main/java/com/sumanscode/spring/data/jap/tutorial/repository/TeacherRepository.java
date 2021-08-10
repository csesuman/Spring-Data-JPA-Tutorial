package com.sumanscode.spring.data.jap.tutorial.repository;

import com.sumanscode.spring.data.jap.tutorial.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {


}

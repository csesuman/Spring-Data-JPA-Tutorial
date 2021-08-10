package com.sumanscode.spring.data.jap.tutorial.repository;

import com.sumanscode.spring.data.jap.tutorial.entity.Course;
import com.sumanscode.spring.data.jap.tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher() {

        Course courseCSE = Course.builder()
                .title("CSE")
                .credit(10)
                .build();

        Course courseJAVA = Course.builder()
                .title("Java")
                .credit(15)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Aloke")
                .lastName("Saha")
//                .courses(List.of(courseCSE,courseJAVA))
                .build();


        teacherRepository.save(teacher);
    }
}
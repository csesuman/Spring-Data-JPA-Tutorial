package com.sumanscode.spring.data.jap.tutorial.repository;

import com.sumanscode.spring.data.jap.tutorial.entity.Course;
import com.sumanscode.spring.data.jap.tutorial.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void SaveCourseMaterial() {

        Course course = Course.builder()
                .title(".net")
                .credit(7)
                .build();

        CourseMaterial courseMaterial =
                CourseMaterial.builder()
                        .url("www.dailySuman.com")
                        .course(course)
                        .build();

        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    public void printAllCourseMaterials() {
        List<CourseMaterial>  courseMaterials =
                courseMaterialRepository.findAll();

        System.out.println("courseMaterials = " + courseMaterials);
    }
}
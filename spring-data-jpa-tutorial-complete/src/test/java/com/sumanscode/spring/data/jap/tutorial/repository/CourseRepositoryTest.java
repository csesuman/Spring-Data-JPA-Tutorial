package com.sumanscode.spring.data.jap.tutorial.repository;

import com.sumanscode.spring.data.jap.tutorial.entity.Course;
import com.sumanscode.spring.data.jap.tutorial.entity.Student;
import com.sumanscode.spring.data.jap.tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;


@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourses() {
        List<Course> courses = courseRepository.findAll();
        System.out.println("courses = " + courses);
    }

    @Test
    public void saveCourseWithTeacher() {
        Teacher teacher = Teacher.builder()
                .firstName("Priyanka")
                .lastName("Singh")
                .build();

        Course course = Course.builder()
                .title("Kotlin")
                .credit(9)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }

    @Test
    public void findAllPagination() {

        Pageable firstPageWithThreeRecords = PageRequest.of(0, 3);
        Pageable secondPageWithTwoRecords = PageRequest.of(1, 2);

        List<Course> courses =
                courseRepository.findAll(secondPageWithTwoRecords).getContent();

        Long totalElements = courseRepository.findAll(secondPageWithTwoRecords).getTotalElements();

        long totalPages = courseRepository.findAll(secondPageWithTwoRecords).getTotalPages();

        System.out.println("totalPages = " + totalPages);

        System.out.println("totalElements = " + totalElements);

        System.out.println("courses = " + courses);
    }

    @Test
    public void findAllSorting() {
        Pageable sortByTitle =
                PageRequest.of(0, 2,
                        Sort.by("title"));


        Pageable sortByCreditDesc =
                PageRequest.of(
                        0,
                        2,
                        Sort.by("credit").descending()
                );

        Pageable sortByTitleAndCredit =
                PageRequest.of(
                    0,2,
                     Sort.by("title")
                        .descending()
                        .and(Sort.by("credit").descending())
                );


        List<Course> courses
                = courseRepository.findAll(sortByTitle).getContent();

        System.out.println("courses = " + courses);
    }

    @Test
    public void printfindBytitleContaining() {
        Pageable firstPageTenRecords =
                PageRequest.of(0,10);

        List<Course> courses = courseRepository.findByTitleContaining("D",
                firstPageTenRecords).getContent();


        System.out.println("courses = " + courses);
    }

    @Test
    public void saveCourseWithStudentsAdnTeacher() {

        Teacher teacher = Teacher.builder()
                .firstName("Asit")
                .lastName("Kumar")
                .build();

        Student student = Student.builder()
                .firstName("Akib")
                .lastName("Shaki")
                .emailId("akib@usa.com")
                .build();

        Course course = Course.builder()
                .title("AI")
                .credit(12)
                .teacher(teacher)
                .build();

        course.addStudents(student);

        courseRepository.save(course);
    }
}
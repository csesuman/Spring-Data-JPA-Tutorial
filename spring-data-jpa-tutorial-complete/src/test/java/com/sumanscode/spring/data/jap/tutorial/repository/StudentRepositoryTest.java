package com.sumanscode.spring.data.jap.tutorial.repository;

import com.sumanscode.spring.data.jap.tutorial.entity.Guardian;
import com.sumanscode.spring.data.jap.tutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("suman@gmail.com")
                .firstName("Suman")
                .lastName("Bhadra")
//                .guardianName("Sunil")
//                .guardianEmail("sunil@gmail.com")
//                .guardianMobile("01791034094")

                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {


        Guardian guardian = Guardian.builder()
                .email("sunsun@hotmail.com")
                .mobile("01817099879")
                .name("HASI")
                .build();

        Student student = Student.builder()

                .firstName("Bhadra")
                .emailId("sum@hotmail.com")
                .lastName("Kerala")
                .guardian(guardian)

                .build();


        studentRepository.save(student);
    }

    @Test
    public void printAllStudent() {

        List<Student> studentList =
                studentRepository.findAll();

        System.out.println("studentList = " + studentList);
    }


    @Test
    public void printStudentByFirstName() {
        List<Student> students =
                studentRepository.findByFirstName("Suman");

        System.out.println("students = " + students);
    }

    @Test
    public void printStudentByFirstNameContaining() {
        List<Student> students =
                studentRepository.findByFirstNameContaining("Sum");

        System.out.println("students = " + students);
    }

    @Test
    public void printStudentBasedOnGuardianName() {
        List<Student> students =
                studentRepository.findByGuardianName("Sunil");
        System.out.println("students = " + students);
    }

    @Test
    public void printStudentByEmailAddress() {
        Student student =
                studentRepository.getStudentByEmailAddress("suman@gmail.com");

        System.out.println("student = " + student);
    }

    @Test
    public void printgetStudentFirstNameByEmailAddress() {
        String firstName =
                studentRepository.getStudentFirstNameByEmailAddress(
                        "suman@gmail.com"
                );

        System.out.println("firstName = " + firstName);
    }

    @Test
    public void printgetStudentByEmailAddressNative() {
        Student student =
                studentRepository.getStudentByEmailAddressNative(
                        "suman@gmail.com"
                );

        System.out.println("student = " + student);
    }


    @Test
    public void printgetStudentByEmailAddressNativeNamedParam() {
        Student student =
                studentRepository.getStudentByEmailAddressNativeNativeParam(
                        "suman@gmail.com"
                );

        System.out.println("student = " + student);
    }


    @Test
    public void updateStudentNameByEmailAddressIdTest() {
        studentRepository.updateStudentByEmailId(
                "Another",
                "suman@gmail.com");


    }
}
package com.kre.springjpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kre.springjpa.entity.Course;
import com.kre.springjpa.entity.Teacher;
import com.kre.springjpa.repositery.TeacherRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class Test3_TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher() {

        Course courseDBA = Course.builder()
                .title("DBA")
                .credit(5)
                .build();

        Course courseJava = Course.builder()
                .title("Java")
                .credit(6)
                .build();

        Teacher teacher =
                Teacher.builder()
                        .firstName("sarap")
                        .lastName("Sir")
                        //.courses(List.of(courseDBA,courseJava))  //@OneToMany handel in teacher Entity
                        .build();

        teacherRepository.save(teacher);
    }
}
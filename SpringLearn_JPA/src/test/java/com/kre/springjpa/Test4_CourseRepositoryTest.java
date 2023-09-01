package com.kre.springjpa;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.kre.springjpa.entity.Course;
import com.kre.springjpa.entity.Student;
import com.kre.springjpa.entity.Teacher;
import com.kre.springjpa.repositery.CourseRepository;


@SpringBootTest
class Test4_CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;
    
    //@Test
    public void printCourses() {
        List<Course> courses = courseRepository.findAll(); // null value also avaliable
       
        System.out.println("courses1----->" + courses.get(0).getTitle());
        System.out.println("courses2----->" + courses.get(0).getCourseMaterial());
        System.out.println("courses3----->" + courses.get(0).getTeacher());
    }

   // @Test
    public void saveCourseWithTeacher() {
        Teacher teacher = Teacher.builder()
                .firstName("sarap")
                .lastName("SirCR")
                .build();

        Course course = Course
                .builder()
                .title("Tamil")
                .credit(6)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
        System.out.println("----->saveCourseWithTeacher()");
    }

   // @Test
    public void findAllPagination(){
    	
        Pageable page1_with5Records = PageRequest.of(0, 5); // page 1,  5 record in i page
        //Pageable page2_With2Records = PageRequest.of(1,2);
        
        List<Course> courses = courseRepository.findAll(page1_with5Records).getContent();

        long totalEle_Count   = courseRepository.findAll(page1_with5Records).getTotalElements();
        long totalPages      = courseRepository.findAll(page1_with5Records).getTotalPages();

        System.out.println("totalPages = " + totalPages);         //5= 23/5
        System.out.println("totalEle_Count = " + totalEle_Count); //23
        System.out.println("coursesId = " + courses.get(4).getCourseId());
    }

    //@Test
    public void findAllSorting() {   /// M:M get issue in student detail for course
        Pageable sortByTitle = PageRequest.of( 0, 2,Sort.by("title"));
        Pageable sortByCreditDesc = PageRequest.of( 0,2, Sort.by("credit").descending());

        Pageable sortByTitleAndCreditDesc = PageRequest.of(0,2, Sort.by("title")
        															.descending()
        															.and(Sort.by("credit")) );
        
        List<Course> courses = courseRepository.findAll(sortByTitle).getContent();
        for(Course course:courses) {
        	System.out.println("courses1 = " + course.getCourseId()+course.getTitle()+course.getCredit());
        	System.out.println("courses2 = " + course.getCourseMaterial());
        	System.out.println("courses3 = " + course.getTeacher());
        	//System.out.println("courses4 = " + course.getStudents().get(0).getFirstName());  // problan in Student Loading M:M
        }
        
    }

    //@Test
    public void printfindByTitleContaining() {
        Pageable firstPageTenRecords =PageRequest.of(0,10);

        List<Course> courses =courseRepository.findByTitleContaining("P", firstPageTenRecords).getContent();
      
        System.out.println("courses-----> " + courses);  // witth out student working (coure entity Lazy loading for Student Entity]
        
        
    }

    @Test
    public void saveCourseWithStudentAndTeacher() {

        Teacher teacher = Teacher.builder()
                .firstName("nifra")
                .lastName("nifra mawanela")
                .build();

        Student student1 = Student.builder()
                .firstName("kowsik")
                .lastName("kre")
                .emailId("kow@gmail.com")
                .build();
        Student student2 = Student.builder()
                .firstName("Dharanik")
                .lastName("kre")
                .emailId("dhar@gmail.com")
                .build();
        

        Course course = Course
                .builder()
                .title("UKG")
                .credit(12)
                .teacher(teacher)
                .build();

        course.addStudents(student1);
        course.addStudents(student2);

        courseRepository.save(course);
    }
}
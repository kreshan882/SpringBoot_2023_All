package com.kre.springjpa;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kre.springjpa.entity.Course;
import com.kre.springjpa.entity.CourseMaterial;
import com.kre.springjpa.repositery.CourseMaterialRepository;


@SpringBootTest
public class Test2_CourseMaterialRepositoryTest {
	
	  	@Autowired
	    private CourseMaterialRepository courMeterialRepository;

	    @Test
	    public void SaveCourseMaterial() {
	        Course course =
	                Course.builder()
	                .title(".net")
	                .credit(6)
	                .build();

	        CourseMaterial courseMaterial =
	                CourseMaterial.builder()
	                .url("www.dailycodebuffer.com")
	                .course(course)
	                .build();

	        courMeterialRepository.save(courseMaterial);
	    }
	    
	    @Test
	    public void printAllCourseMaterials() {
	        List<CourseMaterial> courseMaterials = courMeterialRepository.findAll();

	        System.out.println("courseMaterials1----->" + courseMaterials.get(0));
	        
	        //EAGER Loading (load child table data also
	        Course course=courseMaterials.get(0).getCourse();
	        System.out.println("courseMaterials2----->" + course.getTitle()+":"+course.getCredit()+":"+course.getTeacher());
	    }
	
}

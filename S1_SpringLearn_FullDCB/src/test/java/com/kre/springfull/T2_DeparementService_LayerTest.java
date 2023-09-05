package com.kre.springfull;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.kre.springfull.entity.Department;
import com.kre.springfull.repository.DepartmentRepository;
import com.kre.springfull.service.DepartmentService;

@SpringBootTest
public class T2_DeparementService_LayerTest {

	@Autowired
	private DepartmentService departmentService;
	
	@MockBean // mock this layer
	private DepartmentRepository departmentRepository;
	
	@BeforeEach
	void setUp() {
		
		Department department=Department.builder()
								.departmentName("ucsc22")
								.departmentAddress("kandy")
								.departmentCode("00123")
								.departmentId(1L)
								.build();
		
		Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("ucsc22"))
			   .thenReturn(department); // when call this function , it will mock this hardcoded value
		
	}
	
	@Test
	@DisplayName("Get Data based on Valida Department Name")
	public void whenValidDeparementName_thenDeparementShouldFound() {
		String DEPARTMENT_NAME="ucsc22";
		
		//this will call repository layer, in Repository we mock the function() same as above
		Department found= departmentService.getDepartmentwithName(DEPARTMENT_NAME);
		
		assertEquals("ucsc22", found.getDepartmentName());
	}
	
}

package com.kre.springfull;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.kre.springfull.controller.DepartmentController;
import com.kre.springfull.entity.Department;
import com.kre.springfull.service.DepartmentService;


@WebMvcTest(DepartmentController.class)  // create end point to test
public class T1_DepartmentController_LayerTest {

	private Department department; // department object created
	
	 @MockBean // service calls is mocked
	 private DepartmentService departmentService;
	 
	@Autowired
    private MockMvc mockMvc;  // create end point to call webService

   

    

    @BeforeEach
    void setUp() {
        department = Department.builder()
                .departmentAddress("Ahmedabad")
                .departmentCode("IT-06")
                .departmentName("IT")
                .departmentId(1L)
                .build();
    }

    @Test
    void saveDepartment() throws Exception {
        Department inputDepartment = Department.builder()
                .departmentAddress("Ahmedabad")
                .departmentCode("IT-06")
                .departmentName("IT")
                .build();

        Mockito.when(departmentService.saveDepartment(inputDepartment))
                				      .thenReturn(department);

        //send post request test
        mockMvc.perform(post("/departments")
				       .contentType(MediaType.APPLICATION_JSON)
				       .content("{\n" +
		                "\t\"departmentName\":\"IT\",\n" +
		                "\t\"departmentAddress\":\"Ahmedabad\",\n" +
		                "\t\"departmentCode\":\"IT-06\"\n" +
		                "}")
				       ).andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    void fetchDepartmentById() throws Exception {
        Mockito.when(departmentService.getDepartmentwithid(1L))
               .thenReturn(department);

        //GET request test
        mockMvc.perform(get("/departments/1")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.departmentName").
                value(department.getDepartmentName()));
    }
}

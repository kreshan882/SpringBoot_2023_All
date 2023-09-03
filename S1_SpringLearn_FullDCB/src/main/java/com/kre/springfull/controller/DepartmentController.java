package com.kre.springfull.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kre.springfull.entity.Department;
import com.kre.springfull.service.DepartmentService;

@RestController
public class DepartmentController {

	//2 way @Autowired: constractor base??? & referance base
	// DepartmentService object from spring container , assign to this reference
	
	@Autowired  
	private DepartmentService departmentService;
	
	private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
	
	//@RequestBody --> http request body --> Json Body-> Department object
	//http://localhost:8082/departments
	/*
		{
		    "departmentName":"ucsc",
		    "departmentAddress":"colombo",
		    "departmentCode":"001"
		}
	 */
	@PostMapping("/departments")
    public Department saveDepartment( @RequestBody Department department) {  
        LOGGER.info("Inside saveDepartment of DepartmentController"+department);
        System.out.println("DepartmentController"+department);
        return departmentService.saveDepartment(department);
    }
	
	
    @GetMapping("/departments")
    public List<Department> fetchDepartmentList() {
        LOGGER.info("get Department List");
        return departmentService.fetchDepartmentList();
    }
	
    //with path variable
    @GetMapping("/departments/{idk}")
    public Department getDepartmentwithid(@PathVariable("idk") Long departmentId) {
        LOGGER.info("Get Department by Id");
        return departmentService.getDepartmentwithid(departmentId);
    }
    
    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
        departmentService.deleteDepartmentById(departmentId);
        return "Department deleted Successfully!!";
    }

  //with path variable & request body
    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId,
                                       @RequestBody Department department) {
        return departmentService.updateDepartment(departmentId,department);
    }
    
    
  //with path variable & request body
    @GetMapping("/departments/name/{name}")
    public Department updateDepartment(@PathVariable("name") String departmentName) {
        return departmentService.getDepartmentwithName(departmentName);
    }
}

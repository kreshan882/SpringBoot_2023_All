package com.kre.springfull.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kre.springfull.entity.Department;
import com.kre.springfull.repository.DepartmentRepository;

//new DepartmentService()-> objact create and loaded to spring container( with @AutoWired can use it) 
@Service 
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	private DepartmentRepository departmentRepository;
	
	
	public Department saveDepartment(Department department) {
		// TODO Auto-generated method stub
		return departmentRepository.save(department);
	}



	public List<Department> fetchDepartmentList() {
		return departmentRepository.findAll();
	}




	public Department getDepartmentwithid(Long departmentId) {
		return departmentRepository.findById(departmentId).get();
	}



	public void deleteDepartmentById(Long departmentId) {
		 departmentRepository.deleteById(departmentId);
		
	}



	public Department updateDepartment(Long departmentId, Department department) {
		Department depDb=departmentRepository.findById(departmentId).get();
		
		if(!department.getDepartmentName().isBlank() && !department.getDepartmentName().isEmpty()) {
			depDb.setDepartmentName(department.getDepartmentName());
		}
		if(!department.getDepartmentAddress().isBlank() && !department.getDepartmentAddress().isEmpty()) {
			depDb.setDepartmentAddress(department.getDepartmentAddress());
		}
		if(!department.getDepartmentCode().isBlank() && !department.getDepartmentCode().isEmpty()) {
			depDb.setDepartmentCode(department.getDepartmentCode());
		}
		
		return departmentRepository.save(depDb);
	}




	public Department getDepartmentwithName(String departmentName) {
		
		return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
	}

}

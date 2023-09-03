package com.kre.springfull.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kre.springfull.entity.Department;

 
public interface DepartmentService {

	public Department saveDepartment(Department department);

	public List<Department> fetchDepartmentList();

	public Department getDepartmentwithid(Long departmentId);

	public void deleteDepartmentById(Long departmentId);

	public Department updateDepartment(Long departmentId, Department department);

	public Department getDepartmentwithName(String departmentName);

}

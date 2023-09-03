package com.kre.springfull.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kre.springfull.entity.Department;
import com.kre.springfull.error.DepartmentNotFoundException;

 
public interface DepartmentService {

	public Department saveDepartment(Department department);

	public List<Department> fetchDepartmentList();

	public Department getDepartmentwithid(Long departmentId) throws DepartmentNotFoundException;

	public void deleteDepartmentById(Long departmentId);

	public Department updateDepartment(Long departmentId, Department department);

	public Department getDepartmentwithName(String departmentName);

}

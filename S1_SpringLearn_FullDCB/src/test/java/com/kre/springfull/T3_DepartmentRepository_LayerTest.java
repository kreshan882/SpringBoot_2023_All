package com.kre.springfull;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.kre.springfull.entity.Department;
import com.kre.springfull.repository.DepartmentRepository;

@DataJpaTest // db test layer
public class T3_DepartmentRepository_LayerTest {
	
	@Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager entityManager;  // spring boot function(avaliable in jUnit & Mokito)

    @BeforeEach
    void setUp() {
        Department department =
                Department.builder()
                .departmentName("Sw kre")
                .departmentCode("CS1234")
                .departmentAddress("colombo07")
                .build();

        entityManager.persist(department); //insert to mock db with [TestEntityManager] .and flush out after complete
    }

    @Test
    public void whenFindById_thenReturnDepartment() {
        Department department = departmentRepository.findById(1L).get();
        System.out.println("test insert department id:"+department.getDepartmentId());
        assertEquals(department.getDepartmentName(), "Sw kre");
    }
}

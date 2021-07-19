package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Account;
import com.example.demo.entity.Employee;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class EmployeeRepositoryTests {

	@Autowired
	private EmployeeRepository erepo;
	
	@Test
	@Order(1)
	public void testSaveEmployee()
	{
		Account account1=Account.builder().bname("Canara").build();
		Employee e=Employee.builder()
				           .ename("Kiran")
				           .email("kiran@gmail.com")
				           .account(List.of(account1)).build();
		Employee savedEmployee=erepo.save(e);
		System.out.println("Saved Employee:"+savedEmployee);
		Assertions.assertThat(savedEmployee).isNotNull();
		Assertions.assertThat(savedEmployee.getEid()).isGreaterThan(0);
		
	}
	
	@Test
	@Order(3)
	public void testGetAllEmployees()
	{
		List<Employee> allEmployees=(List<Employee>)erepo.findAll();
		System.out.println("All Employees:"+allEmployees);
		Assertions.assertThat(allEmployees).isNotNull();
	}
	
	
	@Test
	@Order(2)
	public void testGetSingleEmployee()
	{
		Optional<Employee> opt=erepo.findById(1);
		Employee employee=opt.get();
		System.out.println("Single Employee By ID :"+employee);
		Assertions.assertThat(employee).isNotNull();
	}
	
	@Test
	@Order(4)
	public void testFindEmployeesByName()
	{
		List<Employee> allEmployees=erepo.findByEname("Prudhvi");
		System.out.println("All Employees By Name :"+allEmployees);
		Assertions.assertThat(allEmployees).isNotNull();
	}
	
	
	
}

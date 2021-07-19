package com.example.demo.repository;

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
public class AccountRepositoryTest {

	@Autowired
	private AccountRepository erepo;
	
	@Test
	@Order(1)
	public void testSaveAccount()
	{
		Employee emp=Employee.builder().ename("Rajeev").email("rajeev@gmail.com").build();
		Account acc2=Account.builder().bname("Bank Of Baroda Bank").employee(emp).build();
		
		Account savedAccount2=erepo.save(acc2);
			
		System.out.println("Saved Account2 :"+savedAccount2);

		Assertions.assertThat(savedAccount2).isNotNull();
		Assertions.assertThat(savedAccount2.getAccno()).isGreaterThan(0);
		
	}
	
}

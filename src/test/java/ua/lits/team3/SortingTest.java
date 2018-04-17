package ua.lits.team3;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

import ua.lits.team3.model.Employee;

public class SortingTest {

	
	@Test 
	public void sortByName () {
		
		Employee first = new Employee(); 
		first.setName("AAAAA");
	
		Employee second = new Employee(); 
		second.setName("BBBB");
		
		List <Employee> employees = new ArrayList <Employee> ();
		employees.add(second);
		employees.add(first);
		
		EmployeeComparator empComparator = new EmployeeComparator ();
		
		Collections.sort(employees, empComparator);

		assertEquals(employees.get(0).getName(), "AAAAA");
	}
	@Test 
	public void sortByPosition () {
		
		Employee first = new Employee(); 
		first.setName("AAAAA");
		first.setPosition("teacher");
	
		Employee second = new Employee(); 
		second.setName("AAAA");
		second.setPosition("saler");
		
		List <Employee> employees = new ArrayList <Employee> ();
		employees.add(first);
		employees.add(second);
		
		EmployeeComparator empComparator = new EmployeeComparator ();
		
		Collections.sort(employees, empComparator);

		assertEquals(employees.get(0).getPosition(), "saler");
	}
}

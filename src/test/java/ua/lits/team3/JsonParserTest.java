package ua.lits.team3;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ua.lits.team3.model.Employee;

public class JsonParserTest {

	
	@Test	
	public void lala () throws JsonProcessingException {
		
		final Employee first = new Employee(); 
		first.setName("AAAAA");
		first.setPosition("lecturer");
		first.setSalary(2000);
		
		final Employee second = new Employee(); 
		second.setName("BBBB");
		
		
		List <Employee> employees = new ArrayList <Employee> ();
		employees.add(second);
		employees.add(first);
		
	    ObjectMapper objectMapper = new ObjectMapper();
	    String json= objectMapper.writeValueAsString(employees);
	    serialize(json);
	    
	    List <Employee> result =  Application.retrieveEmployeesFromFile(new File ("temp.json"));
	    
	    Employee result1 = result.stream().filter(e -> e.getName().equals(first.getName())).findFirst().orElse(null);
	    
	    assertNotNull(result1);
	    assertEquals(result1.getPosition(), first.getPosition());
	    assertEquals(result1.getSalary(), first.getSalary());
	    
	    Employee result2 = result.stream().filter(e -> e.getName().equals(second.getName())).findFirst().orElse(null);
	    
	    assertNotNull(result2);
	    assertEquals(result2.getPosition(), second.getPosition());
	    assertEquals(result2.getSalary(), second.getSalary());
	      
	    System.out.println(result.toString());
	}
	

	public void serialize(String content) {
		try {
			Files.write(Paths.get("temp.json"), content.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}

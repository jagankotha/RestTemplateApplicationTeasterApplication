package com.example.RestTemplateApplicationTeaster;

import com.example.RestTemplateApplicationTeaster.entities.Employee;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

//@SpringBootApplication
public class RestTemplateApplicationTeasterApplication {

	public static void main(String[] args) throws Exception{
//		SpringApplication.run(RestTemplateApplicationTeasterApplication.class, args);
		System.out.println ("before calling the program" );
		//createEmployee ();
		//getEmployee (2);
		//getAllEmployees ();
		deleteEmployees ( 6 );
		System.out.println ("after calling the program" );

	}

	public static void createEmployee() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate (  );
		//ResponseEntity<Employee> employee  restTemplate.getForObject ( "http://localhost:9090/employee/v1/employees/1",Employee.class);
		Employee employe = new  Employee (  );
		employe.setEmpAddr ( "Chennekotha Palli" );
		employe.setEmpCode ( "AWX1013483" );
		employe.setEmpName ( "Anjali" );
		URI uri = new URI ( "http://localhost:9090/employee/v1/employees" );
		HttpHeaders headers = new HttpHeaders (  );
		headers.setContentType ( MediaType.APPLICATION_JSON );
		HttpEntity<Employee> httpEntity = new HttpEntity<Employee> (employe,headers );
		ResponseEntity<Employee> responseEntity = restTemplate.exchange ( uri,HttpMethod.POST,httpEntity,Employee.class);
		System.out.println ( responseEntity.getBody ());
	}
	public static void getEmployee(Integer integer) throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate (  );
		URI uri = new URI ( "http://localhost:9090/employee/v1/employees/"+integer );
		HttpHeaders headers = new HttpHeaders (  );
		headers.setContentType ( MediaType.APPLICATION_JSON );
		HttpEntity<Employee> httpEntity = new HttpEntity<Employee> (headers );
		ResponseEntity<Employee> responseEntity = restTemplate.exchange ( uri,HttpMethod.GET,httpEntity,Employee.class);
		System.out.println ("Name of the Employee :"+responseEntity.getBody ().getEmpName ());
	}
	public static void getAllEmployees() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate (  );
		URI uri = new URI ( "http://localhost:9090/employee/v1/employees/all" );
		HttpHeaders headers = new HttpHeaders (  );
		headers.setContentType ( MediaType.APPLICATION_JSON );
		HttpEntity<Employee> httpEntity = new HttpEntity<Employee> (headers );
		ResponseEntity<Employee[]> responseEntity = restTemplate.exchange ( uri,HttpMethod.GET,httpEntity,Employee[].class);
		System.out.println ("Name of the Employee :"+responseEntity.getBody ().length);
		Arrays.stream ( responseEntity.getBody () ).forEach ( System.out :: println );
	}
	public static void deleteEmployees(Integer empId) throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate (  );
		URI uri = new URI ( "http://localhost:9090/employee/v1/employees/"+empId );
		HttpHeaders headers = new HttpHeaders (  );
		headers.setContentType ( MediaType.APPLICATION_JSON );
		HttpEntity<String> httpEntity = new HttpEntity<String> (headers );
		ResponseEntity<String> responseEntity = restTemplate.exchange ( uri,HttpMethod.DELETE,httpEntity,String.class);
		System.out.println ("Name of the Employee :"+responseEntity.getBody ());

	}

}

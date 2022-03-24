package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.helper.Binshelper;
import com.example.demo.model.Bins;
import com.example.demo.services.BinsService;

@RestController
public class BinsController {
	@Autowired
	BinsService employeeService;

	// build create employee REST API
	@PostMapping("/post")
	public ResponseEntity<Bins> saveEmployee(@RequestBody Bins employee) {

		return new ResponseEntity<Bins>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
	}

	// building get all employees rest api
	@GetMapping("/get")
	public List<Bins> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	// get employee by id restapi
	// http://localhost"8080/api/employee/1
	@GetMapping("/get/{id}")
	public ResponseEntity<Bins> getEmployeeId(@PathVariable("id") long id) {
		return new ResponseEntity<Bins>(employeeService.getEmployeeById(id), HttpStatus.OK);

	}

	// build update employee restapi
	@PutMapping("/put/{id}")
	public ResponseEntity<Bins> updateEmployee(@PathVariable("id") long id, @RequestBody Bins employee) {
		return new ResponseEntity<Bins>(employeeService.updateEmployee(employee, id), HttpStatus.OK);
	}

	// build delete employee restapi
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id) {

		employeeService.deleteEmployee(id);

		return new ResponseEntity<String>("employee deleted successfully", HttpStatus.OK);

	}
	
	@PostMapping("/bi/upload")
	public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file)
	{
		if(Binshelper.checkExcelFormate(file)) 
		{
			//true
		
			this.employeeService.save(file);
			return ResponseEntity.ok(Map.of("message", "file is uploaded and data is saved to db"));
		}
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please Uploade Excel File Only");
		}
	
	
	}
	


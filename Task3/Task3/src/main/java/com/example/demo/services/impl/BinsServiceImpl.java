package com.example.demo.services.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.exception.ResourseNotFoundException;
import com.example.demo.helper.Binshelper;
import com.example.demo.model.Bins;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.services.BinsService;

@Service
public class BinsServiceImpl implements BinsService {
	@Autowired
	CustomerRepository employeeRepository;

	@Override
	public Bins saveEmployee(Bins employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Bins> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Bins getEmployeeById(long id) {
	//lambda expression
		return employeeRepository.findById(id).orElseThrow(() -> new ResourseNotFoundException("Employee", "Id", id));
	}

	@Override
	public Bins updateEmployee(Bins employee, long id) {
		
		//we need to check whether a employee with a given id exist in DB or not
		Bins existEmployee = employeeRepository.findById(id).orElseThrow(()-> new ResourseNotFoundException("Employee", "ID", id));
		
		existEmployee.setBar_code(employee.getBar_code());
		existEmployee.setWeight_capacity(employee.getWeight_capacity());
		existEmployee.setWidth(employee.getWidth());
		existEmployee.setLength(employee.getLength());
		existEmployee.setHeight(employee.getHeight());
		
		//save existing employee to db
		employeeRepository.save(existEmployee);
		return existEmployee;
	}
	

	@Override
	
	public void deleteEmployee(long id) {
		//we need to check whether a employee with a given id exist in DB or not
		employeeRepository.findById(id).orElseThrow(()->new ResourseNotFoundException("Employee", "ID", id));
		employeeRepository.deleteById(id);
	}

	@Override
	public void save(MultipartFile file) {
		try {
	    List<Bins> bins=Binshelper.convertExcelToListOfBins(file.getInputStream());
	      this.employeeRepository.saveAll(bins);
		}catch(IOException e) 
		{
			e.printStackTrace();
		}
	}

}

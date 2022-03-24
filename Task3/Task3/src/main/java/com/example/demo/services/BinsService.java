package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.Bins;

@Service
public interface BinsService
{
	Bins saveEmployee(Bins employee);
	List<Bins> getAllEmployees();
	Bins getEmployeeById(long id);
	Bins updateEmployee(Bins employee, long id);
	void deleteEmployee(long id);
	void save(MultipartFile file);
	
}

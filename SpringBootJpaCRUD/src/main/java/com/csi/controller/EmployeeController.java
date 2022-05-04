package com.csi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csi.model.Employee;
import com.csi.repository.EmployeeRepositoryImpl;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeRepositoryImpl employeeService;

	@PostMapping("/saveData")
	public ResponseEntity<String> saveData(@RequestBody Employee employee) {
		employeeService.saveData(employee);
		return ResponseEntity.ok("Data Saved");
	}

	@PostMapping("/saveAllData")
	public ResponseEntity<String> saveMultipleData(@RequestBody List<Employee> employees) {
		employeeService.saveAllData(employees);
		return ResponseEntity.ok("All data saved");
	}

	@GetMapping("/getDataById/{empId}")
	public ResponseEntity<Optional<Employee>> getDataById(@PathVariable("empId") int empId) {
		return ResponseEntity.ok(employeeService.getDataById(empId));
	}

	@GetMapping("/getAllData")
	public ResponseEntity<List<Employee>> getAllData() {
		return ResponseEntity.ok(employeeService.getAllData());
	}

	@PutMapping("/updateData/{empId}")
	public ResponseEntity<String> updateData(@RequestBody Employee employee, @PathVariable("empId") int empId) {
		employeeService.updateData(empId, employee);
		return ResponseEntity.ok("Data Updated");
	}

	@DeleteMapping("/deleteDataById/{empId}")
	public ResponseEntity<String> deleteDataById(@PathVariable("empId") int empId) {
		employeeService.deleteDataById(empId);
		return ResponseEntity.ok("Data Delete");
	}

	@DeleteMapping("/deleteAllData")
	public ResponseEntity<String> deleteAllData() {
		employeeService.deleteAllData();
		return ResponseEntity.ok("empty");
	}
}

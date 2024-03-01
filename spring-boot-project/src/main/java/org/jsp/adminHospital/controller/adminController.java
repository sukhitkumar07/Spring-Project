package org.jsp.adminHospital.controller;

import java.util.List;

import org.jsp.adminHospital.dto.Admin;
import org.jsp.adminHospital.dto.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping(value = "/Admins")
public class adminController {
	@Autowired
	private org.jsp.adminHospital.service.adminServices adminServices;

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseStructure<Admin> saveAdmin(@RequestBody Admin Admin) {
		return adminServices.saveAdmin(Admin);
	}
	@PutMapping
	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(@RequestBody Admin Admin) {
		return adminServices.updateAdmin(Admin);
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<ResponseStructure<Admin>> findById(@PathVariable(name = "id") int id) {
		return adminServices.findById(id);
	}
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteById(@PathVariable(name = "id") int id) {
		return adminServices.deleteById(id);
	}
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseStructure<List<Admin>> findAll() {
		return adminServices.findAll();
	}
	@PostMapping("/verify-by-phone")
	public ResponseEntity<ResponseStructure<Admin>> verifyAdmin(@RequestParam long phone,
			@RequestParam String password) {
		return adminServices.verifyAdmin(phone, password);
	}
	@PostMapping("/verify-by-email")
	public ResponseEntity<ResponseStructure<Admin>> verifyAdmin(@RequestParam String phone,
			@RequestParam String password) {
		return adminServices.verifyAdmin(phone, password);
	}

	@GetMapping("/find-by-name/{name}")
	public ResponseEntity<ResponseStructure<List<Admin>>> findByName(@PathVariable String name) {
		return adminServices.findByName(name);
	}

}

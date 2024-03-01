package org.jsp.adminHospital.controller;

import java.util.List;

import org.jsp.adminHospital.dto.Hospital;
import org.jsp.adminHospital.dto.ResponseStructure;
import org.jsp.adminHospital.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HospitalController
{
   @Autowired
   private HospitalService service;
   
   @PostMapping(value = "/hospitals")
	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(@RequestBody Hospital hospital) {
		return service.saveHospital(hospital);
	}

	@PutMapping(value = "/hospitals")
	public ResponseEntity<ResponseStructure<Hospital>> updateHospital(@RequestBody Hospital hospital) {
		return service.updateHospital(hospital);
	}

	@GetMapping("/hospitals/{id}")
	public ResponseEntity<ResponseStructure<Hospital>> findHospitalById(@PathVariable int id) {
		return service.findHospitalById(id);
	}

	@GetMapping("/hospitals")
	public ResponseEntity<ResponseStructure<List<Hospital>>> findAllHospitals() {
		return service.findAllHospitals();
	}

	@DeleteMapping("/hospitals/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteHospital(@PathVariable int id) {
		return service.deleteHospital(id);
	}
   
}

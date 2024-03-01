package org.jsp.adminHospital.controller;

import org.jsp.adminHospital.dto.Branch;
import org.jsp.adminHospital.dto.ResponseStructure;
import org.jsp.adminHospital.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BranchController {
	@Autowired
	private BranchService branchService;
	@PostMapping("/branchs")
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(@RequestBody Branch Branch){
		return branchService.saveBranch(Branch);
		
	}
	@PutMapping("/branchs")
	public ResponseEntity<ResponseStructure<Branch>> updateBranch(@RequestBody Branch Branch){
		return branchService.updateBranch(Branch);
		
	}
	@GetMapping("/Branchs/{id}")
	public ResponseEntity<ResponseStructure<Branch>> findById(@PathVariable(name="id")int id){
		return branchService.findById(id);
	}
	@PostMapping("/Branchs/verify-by-phone")
	public ResponseEntity<ResponseStructure<Branch>> verifyBranch(@RequestParam(name="phone") long phone,@RequestParam(name="password")String password){
		return branchService.verifyBranch(phone, password);
	}
	@PostMapping("/Branchs/verify-by-email")
	public ResponseEntity<ResponseStructure<Branch>> verifyBranch(@RequestParam(name="email") String email,@RequestParam(name="password")String password){
		return branchService.verifyBranch(email, password);
	}

}



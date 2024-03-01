package org.jsp.adminHospital.service;

import java.util.Optional;

import org.jsp.adminHospital.dao.BranchDao;
import org.jsp.adminHospital.dto.Branch;
import org.jsp.adminHospital.dto.ResponseStructure;
import org.jsp.adminHospital.exception.IdNotFoundException;
import org.jsp.adminHospital.exception.InvalidCredentialsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BranchService {
	@Autowired
	private BranchDao branchDao;
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(Branch branch){
		ResponseStructure<Branch>  structure=new ResponseStructure<>();
		structure.setData(branchDao.saveBranch(branch));
		structure.setMesssage("branch saved");
		structure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Branch>>(structure,HttpStatus.CREATED);
		
	}
	public ResponseEntity<ResponseStructure<Branch>> updateBranch(Branch branch){
		ResponseStructure<Branch>  structure=new ResponseStructure<>();
		structure.setData(branchDao.updateBranch(branch));
		structure.setMesssage("branch saved");
		structure.setStatusCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<Branch>>(structure,HttpStatus.ACCEPTED);
		
	}
	public ResponseEntity<ResponseStructure<Branch>> findById(int id){
		ResponseStructure<Branch> structure=new ResponseStructure<>();
		Optional<Branch> recBranch=branchDao.findById(id);
		if(recBranch.isPresent()) {
			structure.setData(recBranch.get());
			structure.setMesssage("Branch found");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Branch>>(structure,HttpStatus.ACCEPTED);
			
	}
		throw new IdNotFoundException();
		
	}
	public ResponseEntity<ResponseStructure<Branch>> verifyBranch(long phone,String password){
		ResponseStructure<Branch> structure=new ResponseStructure<>();
		Optional<Branch> recBranch=branchDao.verifyByPhone(phone, password);
		if(recBranch.isPresent()) {
			structure.setData(recBranch.get());
			structure.setMesssage("Branch found");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Branch>>(structure,HttpStatus.OK);
			
	}
		throw new InvalidCredentialsException();
		
	}
	public ResponseEntity<ResponseStructure<Branch>> verifyBranch(String email,String password){
		ResponseStructure<Branch> structure=new ResponseStructure<>();
		Optional<Branch> recBranch=branchDao.verifyByEmail(email, password);
		if(recBranch.isPresent()) {
			structure.setData(recBranch.get());
			structure.setMesssage("Branch found");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Branch>>(structure,HttpStatus.OK);
			
	}
		throw new InvalidCredentialsException();
		
	}
}



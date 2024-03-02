package org.jsp.adminHospital.dao;

import java.util.Optional;

import org.jsp.adminHospital.dto.Branch;
import org.jsp.adminHospital.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BranchDao {
	@Autowired
	private BranchRepository repository;
	
	public Branch saveBranch (Branch branch) {
		return repository.save(branch);
	}
	public Branch updateBranch (Branch branch) {
		return repository.save(branch);
	}
	public Optional<Branch> findById(int id){
		return repository.findById(id);
	
	}
	public Optional<Branch> verifyByPhone(long phone,String password){
		return repository.verifyBranch(phone, password);
	}
	public Optional<Branch> verifyByEmail(String email,String password){
		return repository.verifyBranch(email, password);
	}
	
	

}

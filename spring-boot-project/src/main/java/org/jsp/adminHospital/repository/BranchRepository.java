package org.jsp.adminHospital.repository;

import java.util.Optional;

import org.jsp.adminHospital.dto.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BranchRepository extends JpaRepository<Branch,Integer> {
	@Query("select b from Branch b where b.phone=?1 and b.password=?2")
	public Optional<Branch> verifyUser(long phone,String password);
	@Query("select b from Branch b where b.email=?1 and b.password=?2")
	public Optional<Branch> verifyUser(String email,String password);
	

}

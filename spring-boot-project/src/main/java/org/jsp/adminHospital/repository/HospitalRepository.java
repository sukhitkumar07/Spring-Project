package org.jsp.adminHospital.repository;

import org.jsp.adminHospital.dto.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital,Integer>
{

}

package org.jsp.adminHospital.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.adminHospital.dto.Hospital;
import org.jsp.adminHospital.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HospitalDao
{
  @Autowired
  private HospitalRepository repo;
  
  public Hospital saveHospital(Hospital h)
  {
	  return repo.save(h);
  }
  public Hospital updateHospital(Hospital h)
  {
	  return repo.save(h);
  }
  public Optional<Hospital> findById(int id)
  {
	  return repo.findById(id);
  }
  public List<Hospital> findAll()
  {
	  return repo.findAll();
  }
  public boolean delete(int id)
  {
	  Optional<Hospital> dbHospital=repo.findById(id);
	  if(dbHospital.isPresent())
	  {
		 repo.delete(dbHospital.get());
		 return true;
	  }
	  return false;
  }
}

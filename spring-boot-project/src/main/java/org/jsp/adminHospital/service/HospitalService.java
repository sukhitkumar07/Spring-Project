package org.jsp.adminHospital.service;

import java.util.List;
import java.util.Optional;

import org.jsp.adminHospital.dao.HospitalDao;
import org.jsp.adminHospital.dto.Hospital;
import org.jsp.adminHospital.dto.ResponseStructure;
import org.jsp.adminHospital.exception.IdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class HospitalService
{
   @Autowired
   private HospitalDao hospitalDao;
   
   public ResponseEntity<ResponseStructure<Hospital>> saveHospital(Hospital Hospital) {
		ResponseStructure<Hospital> structure = new ResponseStructure<>();
		structure.setData(hospitalDao.saveHospital(Hospital));
		structure.setMessage("Hospital saved succesfully");
		structure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Hospital>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Hospital>> updateHospital(Hospital Hospital) {
		ResponseStructure<Hospital> structure = new ResponseStructure<>();
		structure.setData(hospitalDao.updateHospital(Hospital));
		structure.setMessage("Hospital Updated succesfully");
		structure.setStatusCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<Hospital>>(structure, HttpStatus.ACCEPTED);
	}

	public ResponseEntity<ResponseStructure<Hospital>> findHospitalById(int id) {
		Optional<Hospital> dBHospital = hospitalDao.findById(id);
		ResponseStructure<Hospital> structure = new ResponseStructure<>();
		if (dBHospital.isPresent()) {
			structure.setData(dBHospital.get());
			structure.setMessage("Hospital Found");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Hospital>>(structure, HttpStatus.OK);
		}
		
		throw new IdNotFoundException("given id is not present");
	}

	public ResponseEntity<ResponseStructure<List<Hospital>>> findAllHospitals() {
		ResponseStructure<List<Hospital>> structure = new ResponseStructure<>();
		structure.setData(hospitalDao.findAll());
		structure.setMessage("List of All Hospitals");
		structure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<Hospital>>>(structure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<String>> deleteHospital(int id) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		Optional<Hospital> dbHospital = hospitalDao.findById(id);
		if (dbHospital.isPresent()) {
			hospitalDao.delete(id);
			structure.setMessage("Hospital Deleted");
			structure.setData("Hospital Found");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
		}
		throw new IdNotFoundException("id is not valid to delete");
	}
}

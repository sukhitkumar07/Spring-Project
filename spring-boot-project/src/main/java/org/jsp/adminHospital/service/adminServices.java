package org.jsp.adminHospital.service;

import java.util.List;
import java.util.Optional;

import org.jsp.adminHospital.dao.adminDao;
import org.jsp.adminHospital.dto.Admin;
import org.jsp.adminHospital.dto.ResponseStructure;
import org.jsp.adminHospital.exception.IdNotFoundException;
import org.jsp.adminHospital.exception.InvalidCredentialsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
@Service
public class adminServices {
	@Autowired
	private adminDao AdminDao;
	
	public ResponseStructure<Admin> saveAdmin(Admin Admin) {
		ResponseStructure<Admin> structure = new ResponseStructure<>();
		structure.setMessage("Admin saved");
		structure.setData(AdminDao.saveAdmin(Admin));
		structure.setStatusCode(HttpStatus.CREATED.value());
		return structure;
	}

	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(Admin Admin) {
		Optional<Admin> recAdmin = AdminDao.findById(Admin.getId());
		ResponseStructure<Admin> structure = new ResponseStructure<>();
		if (recAdmin.isPresent()) {
			Admin dbAdmin = recAdmin.get();
			dbAdmin.setEmail(Admin.getEmail());
			dbAdmin.setName(Admin.getName());
			dbAdmin.setPhone(Admin.getPhone());
			dbAdmin.setPassword(Admin.getPassword());
			structure.setMessage("Admin Updated");
			structure.setData(AdminDao.saveAdmin(Admin));
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.ACCEPTED);
		}
		throw new IdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<Admin>> findById(int id) {
		Optional<Admin> recAdmin = AdminDao.findById(id);
		ResponseStructure<Admin> structure = new ResponseStructure<>();
		if (recAdmin.isPresent()) {
			structure.setData(recAdmin.get());
			structure.setMessage("Admin Found");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.OK);
		}
		throw new IdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<String>> deleteById(int id) {
		Optional<Admin> recAdmin = AdminDao.findById(id);
		ResponseStructure<String> structure = new ResponseStructure<>();
		if (recAdmin.isPresent()) {
			structure.setMessage("Admin found");
			structure.setData("Admin deleted");
			structure.setStatusCode(HttpStatus.OK.value());
			AdminDao.deleteById(id);
			return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
		}
		structure.setMessage("Admin Not found");
		structure.setData("cannot delete Admin as Id is Invalid");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	public ResponseStructure<List<Admin>> findAll() {
		ResponseStructure<List<Admin>> structure = new ResponseStructure<>();
		structure.setMessage("List of Admins");
		structure.setData(AdminDao.findAll());
		structure.setStatusCode(HttpStatus.OK.value());
		return structure;
	}

	public ResponseEntity<ResponseStructure<Admin>> verifyAdmin(
			long phone, String password) {
		Optional<Admin> recAdmin = AdminDao.verify(phone, password);
		ResponseStructure<Admin> structure = new ResponseStructure<>();
		if (recAdmin.isPresent()) {
			structure.setMessage("Verification Succesfull");
			structure.setData(recAdmin.get());
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Admin>>
			         (structure, HttpStatus.OK);
		}
		throw new InvalidCredentialsException("Invalid Phone Number or Password");
	}
	public ResponseEntity<ResponseStructure<Admin>> verifyAdmin(
			String phone, String password) {
		Optional<Admin> recAdmin = AdminDao.verify(phone, password);
		ResponseStructure<Admin> structure = new ResponseStructure<>();
		if (recAdmin.isPresent()) {
			structure.setMessage("Verification Succesfull");
			structure.setData(recAdmin.get());
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Admin>>
			         (structure, HttpStatus.OK);
		}
		throw new InvalidCredentialsException("Invalid Phone email or Password");
	}

	public ResponseEntity<ResponseStructure<List<Admin>>> findByName(String name) {
		ResponseStructure<List<Admin>> structure = new ResponseStructure<>();
		List<Admin> Admins = AdminDao.findByName(name);
		structure.setData(Admins);
		if (Admins.size() > 0) {
			structure.setMessage("List of Admins with entered name ");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<List<Admin>>>(structure, HttpStatus.OK);
		}
		structure.setMessage("No Admin found with the entered name ");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<List<Admin>>>(structure, HttpStatus.NOT_FOUND);
	}

}

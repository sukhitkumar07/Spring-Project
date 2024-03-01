package org.jsp.adminHospital.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.adminHospital.dto.Admin;
import org.jsp.adminHospital.repository.adminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class adminDao {
	@Autowired
	private adminRepository AdminRepository;

	public Admin saveAdmin(Admin Admin) {
		return AdminRepository.save(Admin);
	}

	public Optional<Admin> findById(int id) {
		return AdminRepository.findById(id);
	}

	public List<Admin> findAll() {
		return AdminRepository.findAll();
	}

	public List<Admin> findByName(String name) {
		return AdminRepository.findByName(name);
	}

	public boolean deleteById(int id) {
		Optional<Admin> recAdmin = findById(id);
		if (recAdmin.isPresent()) {
			AdminRepository.delete(recAdmin.get());
			return true;
		}
		return false;
	}

	public Optional<Admin> verify(long phone, String password) {
		return AdminRepository.verify(phone, password);
	}
	public Optional<Admin> verify(String phone, String password) {
		return AdminRepository.verify(phone, password);
	}

}

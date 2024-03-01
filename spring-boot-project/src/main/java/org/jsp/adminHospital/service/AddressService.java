package org.jsp.adminHospital.service;

import java.util.Optional;

import org.jsp.adminHospital.dao.AddressDao;
import org.jsp.adminHospital.dto.Address;
import org.jsp.adminHospital.dto.ResponseStructure;
import org.jsp.adminHospital.exception.AddressNotFoundException;
import org.jsp.adminHospital.exception.IdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
	@Autowired
	private AddressDao addressDao;

	public ResponseStructure<Address> saveAddress(Address address) {
		ResponseStructure<Address> structure = new ResponseStructure<>();
		structure.setMessage("Address Saved");
		structure.setData(addressDao.saveAddress(address));
		structure.setStatusCode(HttpStatus.CREATED.value());
		return structure;
	}

	public ResponseEntity<ResponseStructure<Address>> updateAddress(Address address) {
		Optional<Address> recAddress = addressDao.findById(address.getId());
		ResponseStructure<Address> structure = new ResponseStructure<>();
		if (recAddress.isPresent()) {
			Address dbAddress = recAddress.get();
			dbAddress.setId(address.getId());
			dbAddress.setBuilding(address.getBuilding());
			dbAddress.setCity(address.getCity());
			dbAddress.setCountry(address.getCountry());
			dbAddress.setLandmark(address.getLandmark());
			dbAddress.setState(address.getState());
			dbAddress.setStreet(address.getStreet());
			dbAddress.setPincode(address.getPincode());
			structure.setMessage("Address Updated");
			structure.setData(addressDao.saveAddress(address));
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<Address>>(structure, HttpStatus.ACCEPTED);
		}
		throw new IdNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<Address>> findById(int id) {
		Optional<Address> recMerchant = addressDao.findById(id);
		ResponseStructure<Address> structure = new ResponseStructure<>();
		if (recMerchant.isPresent()) {
			structure.setMessage("Address Found");
			structure.setData(recMerchant.get());
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Address>>(structure, HttpStatus.OK);
		}
		throw new AddressNotFoundException("Enterd Id is invalid");
	}

}

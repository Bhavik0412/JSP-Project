package com.navaera.assignment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.navaera.assignment.entity.Customer;
import com.navaera.assignment.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepo;

	public List<Customer> getAllCustomer() {
		List<Customer> findAll = customerRepo.findAll();
		return findAll;
	}

	public Customer getCustomerById(Long id) {
		return customerRepo.findById(id).get();
	}

	public Boolean saveOrUpdate(Customer customer) {
		Optional<Customer> findById = customerRepo.findById(customer.getId());
		if (findById.isPresent()) {
			customer.setAccountNumber(findById.get().getAccountNumber());
			customerRepo.save(customer);
			return true;
		} else {
			customer.setAccountNumber(String.valueOf(generateAccountNumber()));
			customerRepo.save(customer);
			return true;
		}
	}

	private static String generateAccountNumber() {
		String uuid = UUID.randomUUID().toString();
		String numericUuid = uuid.replaceAll("[^0-9]", "");

		// Ensure numericUuid has a length of at least 16 characters
		while (numericUuid.length() < 16) {
			numericUuid = "0" + numericUuid;
		}

		// Take the first 16 characters of numericUuid
		String accountNumber = numericUuid.substring(0, 16);
		System.out.println(accountNumber);
		return accountNumber;
	}

	public Boolean deleteById(Long id) {
		Optional<Customer> findById = customerRepo.findById(id);
		if (findById.isPresent()) {
			Customer customer = findById.get();
			customerRepo.delete(customer);
			return true;
		} else {
			return false;
		}
	}
}

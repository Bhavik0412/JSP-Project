package com.navaera.assignment.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotEmpty
	private String name;

	@NotEmpty
	private String gender;
	// so due to @Past annotation only past date can be accepted so future date
	// enter should be avoided
	@Past
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dob;

	@NotEmpty
	private String address;
	// so due to @Pattern annotation only numeric(0-9) number accept for uid
	@Pattern(regexp = "\\d{16}")
	private String uid;

	@NotEmpty
	private String proffesion;

	@NotEmpty
	private String citizenship;

	@Column
	private String accountNumber;

	@NotNull
	@Min(value = 0)
	private BigDecimal openingBalance;

	public Customer() {

	}

	public Customer(String name, String gender, LocalDate dob, String address, String uid, String proffesion,
			String citizenship, BigDecimal openingBalance) {
		this.name = name;
		this.gender = gender;
		this.dob = dob;
		this.address = address;
		this.uid = uid;
		this.proffesion = proffesion;
		this.citizenship = citizenship;
		this.openingBalance = openingBalance;

		// Generate a unique account number using UUID
		this.accountNumber = generateAccountNumber();
	}

	private String generateAccountNumber() {
		String uuid = UUID.randomUUID().toString();
		// Extract only numeric characters from the UUID
		String numericUuid = uuid.replaceAll("[^0-9]", "");

		// Ensure the numeric UUID has a length of at least 16 characters
		while (numericUuid.length() < 16) {
			numericUuid = "0" + numericUuid;
		}

		// Take the first 16 characters to ensure a length of 16
		return numericUuid.substring(0, 16);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getProffesion() {
		return proffesion;
	}

	public void setProffesion(String proffesion) {
		this.proffesion = proffesion;
	}

	public String getCitizenship() {
		return citizenship;
	}

	public void setCitizenship(String citizenship) {
		this.citizenship = citizenship;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public BigDecimal getOpeningBalance() {
		return openingBalance;
	}

	public void setOpeningBalance(BigDecimal openingBalance) {
		this.openingBalance = openingBalance;
	}

	@Override
	public int hashCode() {
		return Objects.hash(accountNumber, address, citizenship, dob, gender, id, name, openingBalance, proffesion,
				uid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(accountNumber, other.accountNumber) && Objects.equals(address, other.address)
				&& Objects.equals(citizenship, other.citizenship) && Objects.equals(dob, other.dob)
				&& Objects.equals(gender, other.gender) && id == other.id && Objects.equals(name, other.name)
				&& Objects.equals(openingBalance, other.openingBalance) && Objects.equals(proffesion, other.proffesion)
				&& Objects.equals(uid, other.uid);
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", gender=" + gender + ", dob=" + dob + ", address=" + address
				+ ", uid=" + uid + ", proffesion=" + proffesion + ", citizenship=" + citizenship + ", accountNumber="
				+ accountNumber + ", openingBalance=" + openingBalance + "]";
	}

}

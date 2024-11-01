package com.springheaven.orm.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; // value type
	@Column(name = "student_firstname", length = 70, nullable = false)
	private String firstName; // value type
	@Column(name = "student_lastname", length = 70, nullable = false)
	private String lastName; // value type
	@Column(name = "student_email", length = 70, nullable = false)
	private String email; // value type

	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name = "addressLine1", column = @Column(name = "home_address_line1", length = 200, nullable = false)),
			@AttributeOverride(name = "addressLine2", column = @Column(name = "home_address_line2", length = 200, nullable = false)),
			@AttributeOverride(name = "city", column = @Column(name = "home_city", length = 200, nullable = false)),
			@AttributeOverride(name = "country", column = @Column(name = "home_country", length = 200, nullable = false)),
	/*
	 * @AttributeOverride(name = "home.mobileNo", column = @Column(name =
	 * "home_mobile_no")),
	 * 
	 * @AttributeOverride(name = "home.officeNo", column = @Column(name =
	 * "home_office_no"))
	 */ })
	private Address homeaddress; // composite value type

	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name = "addressLine1", column = @Column(name = "hostel_address_line1", length = 200, nullable = false)),
			@AttributeOverride(name = "addressLine2", column = @Column(name = "hostel_address_line2", length = 200, nullable = false)),
			@AttributeOverride(name = "city", column = @Column(name = "hostel_city", length = 200, nullable = false)),
			@AttributeOverride(name = "country", column = @Column(name = "hostel_country", length = 200, nullable = false)),
	/*
	 * @AttributeOverride(name = "hostel.mobileNo", column = @Column(name =
	 * "hostel_mobile_no")),
	 * 
	 * @AttributeOverride(name = "hostel.officeNo", column = @Column(name =
	 * "hostel_office_no"))
	 */ })
	private Address hostelAddress; // composite value type

	/*
	 * @AttributeOverrides({ @AttributeOverride(name = "address_line1", column
	 * = @Column(name = "home_address_line1")) }) private Address hosteladdress; //
	 * composite value type
	 */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getHomeaddress() {
		return homeaddress;
	}

	public void setHomeaddress(Address homeaddress) {
		this.homeaddress = homeaddress;
	}

	public Address getHostelAddress() {
		return hostelAddress;
	}

	public void setHostelAddress(Address hostelAddress) {
		this.hostelAddress = hostelAddress;
	}

}

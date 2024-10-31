package com.springheaven.orm.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable // we use Embeddable for the composite value type
public class Address {
	// @Column(name="address_line1",length = 200,nullable=false)
	public String addressLine1;
	// @Column(name="address_line2",length = 200,nullable=false)
	public String addressLine2;
	// @Column(name="city",length = 200,nullable=false)
	public String city;
	// @Column(name="country")
	public String country;

	/*
	 * @AttributeOverrides({
	 * 
	 * @AttributeOverride(name = "mobileNo", column = @Column(name =
	 * "personal_phone_no")),
	 * 
	 * @AttributeOverride(name = "officeNo", column = @Column(name =
	 * "personal_office_no")) })
	 * 
	 * @Embedded private Phone personnalcontact;
	 */
	/*
	 * @AttributeOverrides({
	 * 
	 * @AttributeOverride(name = "mobileNo", column = @Column(name =
	 * "official_phone_no")),
	 * 
	 * @AttributeOverride(name = "officeNo", column = @Column(name =
	 * "official_office_no")) })
	 * 
	 * @Embedded private Phone officialContact;
	 * 
	 * public Phone getOfficialContact() { return officialContact; }
	 * 
	 * public void setOfficialContact(Phone officialContact) { this.officialContact
	 * = officialContact; }
	 */

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	/*
	 * public Phone getPersonnalcontact() { return personnalcontact; }
	 * 
	 * public void setPersonnalcontact(Phone personnalcontact) {
	 * this.personnalcontact = personnalcontact; }
	 */

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
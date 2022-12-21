package com.masai.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.masai.enums.AddressType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer addressId;
	
	@NotNull
	private String area;
	
	@NotNull
	private String state;
	
	@NotNull
	private String district;
	
	@NotNull
	@Pattern(regexp="[0-9]{6}", message = "pincode must have 6 digits")
	private String pincode;
	
	@NotNull
	private AddressType addresstype;

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public AddressType getAddresstype() {
		return addresstype;
	}

	public void setAddresstype(AddressType addresstype) {
		this.addresstype = addresstype;
	}

	public Address(Integer addressId, @NotNull String area, @NotNull String state, @NotNull String district,
			@NotNull @Pattern(regexp = "[0-9]{6}", message = "pincode must have 6 digits") String pincode,
			@NotNull AddressType addresstype) {
		super();
		this.addressId = addressId;
		this.area = area;
		this.state = state;
		this.district = district;
		this.pincode = pincode;
		this.addresstype = addresstype;
	}

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}

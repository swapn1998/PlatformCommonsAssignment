package com.masai.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.entity.Address;

public interface AddressRepo extends JpaRepository<Address, Integer> {

}

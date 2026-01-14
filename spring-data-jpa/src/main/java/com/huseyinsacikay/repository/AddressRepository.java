package com.huseyinsacikay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.huseyinsacikay.entities.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{

}

package com.huseyinsacikay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.huseyinsacikay.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}

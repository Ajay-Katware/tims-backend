package com.tejovat.tims.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tejovat.tims.model.CustomerMaster;

@Repository
public interface CustomerRepository extends CrudRepository<CustomerMaster, Serializable>{

}

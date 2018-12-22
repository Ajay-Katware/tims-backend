package com.tejovat.tims.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tejovat.tims.model.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Serializable>{

}

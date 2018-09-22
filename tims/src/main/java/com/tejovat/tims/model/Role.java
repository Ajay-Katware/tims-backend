package com.tejovat.tims.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="role")
public class Role  implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String role;
	private String description;

	public Role() {
		
	}

	public Role(Integer id, String role, String description) {
		this.id = id;
		this.role = role;
		this.description = description;
	}



	@Id @GeneratedValue(strategy=IDENTITY)
	@Column(name="id", unique=true, nullable=false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	@Column(name="role")
	@NotNull(message = "Role name can not be null.")
	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
	@Column(name="description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", role=" + role + ", description=" + description + "]";
	}
}




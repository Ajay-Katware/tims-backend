package com.tejovat.tims.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tejovat.tims.model.Role;
import com.tejovat.tims.service.RoleService;

@RestController
@RequestMapping("/roles")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Iterable<Role> getAllRoles() throws Exception{
		return roleService.getRoleList();
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST, consumes = {"application/json", "application/xml"}, produces = {"application/json", "application/xml"})
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Role> createRole(@RequestBody Role role, HttpServletRequest request) throws Exception {
		Role createdRole = roleService.saveRole(role);
		return ResponseEntity.ok().body(createdRole);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {"application/json", "application/xml"})
	public Role getUserByUserId(@PathVariable("id") Integer id) throws Exception {
		Role role = roleService.getRole(id);
		return role;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = {"application/json", "application/xml"})
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteUser(@PathVariable("id") Integer id) throws Exception {
		roleService.deleteRole(id);
	}
	
	@RequestMapping(value = "/checkRoleByName", method = RequestMethod.GET,consumes = {"application/json", "application/xml"}, produces = {"application/json", "application/xml"})
	public ResponseEntity<Boolean> checkUseremail(@RequestParam("roleName") String roleName) {
		Role role = roleService.getRoleByName(roleName);
		if(role!=null) {
			return ResponseEntity.ok().body(true);
		}
		return ResponseEntity.ok().body(false);
	}

}


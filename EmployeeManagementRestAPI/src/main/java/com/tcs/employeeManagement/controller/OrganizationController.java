package com.tcs.employeeManagement.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.tcs.employeeManagement.exeception.ResourceNotFoundException;
import com.tcs.employeeManagement.model.Organization;
import com.tcs.employeeManagement.service.OrganizationServices;

@RestController
@RequestMapping("/api/v1/organization")
public class OrganizationController {

	@Autowired
	OrganizationServices orgS;

	@GetMapping
	public List<Organization>  getOrganizations()
	{
		return orgS.getOrganizations().get();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Organization>  getOrganizationById(@PathVariable("id") int organizationId) throws ResourceNotFoundException
	{	
		Organization org = orgS.findById(organizationId).orElseThrow(() -> new ResourceNotFoundException("Organization not found."));
		return ResponseEntity.ok(org);
	}
	
	@PostMapping()
	public ResponseEntity<?> addOrganization(@RequestBody Organization organization, UriComponentsBuilder builder,
			HttpServletRequest httpRequest) {
		Organization org = orgS.addOrganization(organization);
		UriComponents components = builder.path(httpRequest.getRequestURI() + "/{id}").buildAndExpand(org.getId());
		return ResponseEntity.created(components.toUri()).body(org);
	}
	
	@DeleteMapping("/{id}")
	public Map<String, Boolean> deleteOrganizationById(@PathVariable int id) throws ResourceNotFoundException
	{
		orgS.findById(id).orElseThrow(() -> new ResourceNotFoundException("Organization not found."));
		orgS.deleteOrganization(id);
		HashMap<String, Boolean> res =  new HashMap<>();
		res.put("delete", Boolean.TRUE);
		return res;
				
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Organization> updateOrganization(@PathVariable("id") int id,  @Valid @RequestBody Organization organization) throws ResourceNotFoundException
	{
		Organization org = orgS.findById(id).orElseThrow(() -> new ResourceNotFoundException("Organization not found."));
		organization.setId((long) id);
		org = orgS.addOrganization(organization);
		return ResponseEntity.ok(org);	
	}
}

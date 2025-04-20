package com.RestFullStart.Restdemo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RestFullStart.Restdemo.Modal.CloudVendor;
import com.RestFullStart.Restdemo.Service.CloudVendorService;
import com.RestFullStart.Restdemo.response.ResponseHandler;

// Rest controller mark the class and tell that this class is responsible for API calls

@RestController

@RequestMapping("/cloudvendor")

public class CloudVendorController {
	
	CloudVendorService cloudVendorService;
	
	public CloudVendorController(CloudVendorService cloudVendorService)
	{
		this.cloudVendorService = cloudVendorService;
	}

	// Read Specific Cloud Vendor Details
	@GetMapping("{vendorId}")
	public ResponseEntity<Object> getCloudVendorDetails(@PathVariable("vendorId") String vendorId)
	{
		return ResponseHandler.responseBuilder("Requested vendor details are given here ", HttpStatus.OK, cloudVendorService.getCloudVendor(vendorId));
		//new CloudVendor("c1","vendor1","Address one","xxxxxx");
	}
	
	// Read all Cloud Vendor Details
	
	@GetMapping()
	public List<CloudVendor> getAllCloudVendorDetails()
	{
		return cloudVendorService.getAllCloudVendors();//new CloudVendor("c1","vendor1","Address one","xxxxxx");
	}
	
	@PostMapping
	public String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor)
	{
		cloudVendorService.createCloudVendor(cloudVendor);
		
		return "Cloud Vendor Created SuccessFully";
	}
	
	@PutMapping
	public String updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor)
	{
		cloudVendorService.updateCloudVendor(cloudVendor);
		
		return "Cloud Vendor Updated SuccessFully";
	}
	
	@DeleteMapping("{vendorId}")
	public String deleteCloudVendorDetails(@PathVariable("vendorId") String vendorID)
	{
		cloudVendorService.deleteCloudVendor(vendorID);
		
		return "Cloud Vendor deleted SuccessFully";
	}
	
}

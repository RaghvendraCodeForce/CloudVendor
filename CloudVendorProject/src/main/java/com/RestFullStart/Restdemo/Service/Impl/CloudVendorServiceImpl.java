package com.RestFullStart.Restdemo.Service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.RestFullStart.Restdemo.Excepion.CloudVendorNotFoundException;
import com.RestFullStart.Restdemo.Modal.CloudVendor;
import com.RestFullStart.Restdemo.Repository.CloudVendorRepository;
import com.RestFullStart.Restdemo.Service.CloudVendorService;

@Service

public class CloudVendorServiceImpl implements CloudVendorService{
	
	
	// instantiate cloud vendor repository as it's the layer responsible for communicating with the database
	
	CloudVendorRepository cloudVendorRepository;
	
	public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepository)
	{
		this.cloudVendorRepository = cloudVendorRepository;
	}

	@Override
	public String createCloudVendor(CloudVendor cloudVendor) {
		// more business logic
		cloudVendorRepository.save(cloudVendor);
		return "Success";
	}

	@Override
	public String updateCloudVendor(CloudVendor cloudVendor) {
		cloudVendorRepository.save(cloudVendor);
		return "Success";
	}

	@Override
	public String deleteCloudVendor(String cloudVendorID) {
		cloudVendorRepository.deleteById(cloudVendorID);
		return "Success";
	}

	@Override
	public CloudVendor getCloudVendor(String cloudVendorId) {
		if(cloudVendorRepository.findById(cloudVendorId).isEmpty())
		{
			throw new CloudVendorNotFoundException("Requested Cloud Vendor does not exist");
		}
		return cloudVendorRepository.findById(cloudVendorId).get();
	}

	@Override
	public List<CloudVendor> getAllCloudVendors() {
		return cloudVendorRepository.findAll();
	}
}

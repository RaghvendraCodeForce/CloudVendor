package com.RestFullStart.Restdemo.Service;

import java.util.List;

import com.RestFullStart.Restdemo.Modal.CloudVendor;

public interface CloudVendorService {

	public String createCloudVendor(CloudVendor cloudVendor);
	
	public String updateCloudVendor(CloudVendor cloudVendor);
	
	public String deleteCloudVendor(String cloudVendorID); // deleting based on ic
	
	public CloudVendor getCloudVendor(String cloudVendorId);
	
	public List<CloudVendor> getAllCloudVendors();
	
}

package com.RestFullStart.Restdemo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.RestFullStart.Restdemo.Modal.CloudVendor;

public interface CloudVendorRepository extends JpaRepository<CloudVendor, String> {

}

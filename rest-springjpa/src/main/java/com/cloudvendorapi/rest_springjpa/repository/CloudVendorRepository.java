package com.cloudvendorapi.rest_springjpa.repository;

import com.cloudvendorapi.rest_springjpa.model.CloudVendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CloudVendorRepository extends JpaRepository<CloudVendor, String> {
}

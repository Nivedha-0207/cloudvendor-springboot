package com.cloudvendorapi.rest_springjpa.service.impl;

import com.cloudvendorapi.rest_springjpa.exception.CloudVendorFileNotFoundException;
import com.cloudvendorapi.rest_springjpa.model.CloudVendor;
import com.cloudvendorapi.rest_springjpa.repository.CloudVendorRepository;
import com.cloudvendorapi.rest_springjpa.service.CloudVendorService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CloudVendorServiceImpl implements CloudVendorService {

    CloudVendorRepository cloudVendorRepository;

    public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepository) {
        this.cloudVendorRepository = cloudVendorRepository;
    }

    @Override
    public String createCloudVendor(CloudVendor cloudVendor) {
        cloudVendorRepository.save(cloudVendor);
        return "Sucess!";
    }

    @Override
    public String updateCloudVendor(CloudVendor cloudVendor) {
        cloudVendorRepository.save(cloudVendor);
        return "updated";
    }

    @Override
    public String deleteCloudVendor(String vendorId) {
        cloudVendorRepository.deleteById(vendorId);
        return "deletion sucessfull!";
    }

    @Override
    public CloudVendor getCloudVendor(String vendorId) {
        if(cloudVendorRepository.findById(vendorId).isEmpty())
            throw new CloudVendorFileNotFoundException("Requested cloud vendor does not exist!");
        return cloudVendorRepository.findById(vendorId).get();

    }

    @Override
    public List<CloudVendor> getAllVendor() {
        return cloudVendorRepository.findAll();
    }
}

package com.cloudvendorapi.rest_springjpa.controller;


import com.cloudvendorapi.rest_springjpa.model.CloudVendor;
import com.cloudvendorapi.rest_springjpa.response.ResponseHandler;
import com.cloudvendorapi.rest_springjpa.service.CloudVendorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorAPIController {

  CloudVendorService cloudVendorService;

    public CloudVendorAPIController(CloudVendorService cloudVendorService) {
        this.cloudVendorService = cloudVendorService;
    }

    //for specific cloud vendor
    @GetMapping("{vendorId}")
    public ResponseEntity<Object> getVendorDetailsById(@PathVariable("vendorId") String vendorId)
    {

       return ResponseHandler.responseBuilder("Requested vendor details are given here",HttpStatus.OK,cloudVendorService.getCloudVendor(vendorId));



    }
    //for all cloud vendor
    @GetMapping()
    public List<CloudVendor> getAllVendorDetailsById(String vendorId)
    {
        return cloudVendorService.getAllVendor();


    }

    @PostMapping
    public String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor){

        cloudVendorService.createCloudVendor(cloudVendor);
        return "Sucessfully created vendorDetails";

    }

    @PutMapping
    public String updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor){

        cloudVendorService.updateCloudVendor(cloudVendor);
        return "Sucessfully updated the vendorDetails";

    }

    @DeleteMapping("{vendorId}")
    public String deleteCloudVendorDetails(@PathVariable("vendorId") String vendorId){

        cloudVendorService.deleteCloudVendor(vendorId);
        return "Sucessfully deleted the cloudvendorDetails";

    }




}

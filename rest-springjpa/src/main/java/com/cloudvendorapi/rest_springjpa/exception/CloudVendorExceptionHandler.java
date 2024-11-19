package com.cloudvendorapi.rest_springjpa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CloudVendorExceptionHandler {

    @ExceptionHandler(value={CloudVendorFileNotFoundException.class})
    public ResponseEntity<Object> handleCloudVendorExceptionNotFound(CloudVendorFileNotFoundException cloudVendorFileNotFoundException ){
        CloudVendorException  CloudVendorException = new CloudVendorException(
                cloudVendorFileNotFoundException.getMessage(),
        cloudVendorFileNotFoundException.getCause(),
                HttpStatus.NOT_FOUND
        );

        return new ResponseEntity<>(CloudVendorException, HttpStatus.NOT_FOUND);

    }
}

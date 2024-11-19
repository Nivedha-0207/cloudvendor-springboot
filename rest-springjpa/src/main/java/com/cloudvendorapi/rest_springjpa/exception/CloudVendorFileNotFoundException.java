package com.cloudvendorapi.rest_springjpa.exception;

public class CloudVendorFileNotFoundException extends RuntimeException{
    public CloudVendorFileNotFoundException(String message) {
        super(message);
    }

    public CloudVendorFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

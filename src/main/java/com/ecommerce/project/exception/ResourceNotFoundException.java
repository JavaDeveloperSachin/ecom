package com.ecommerce.project.exception;

public class ResourceNotFoundException extends  RuntimeException {
String resourceName;
String field;
String fieldName;
int fieldId;


    public ResourceNotFoundException(){

    }
    public ResourceNotFoundException(String field, String fieldName, String resourceName) {
        super(String.format("%s Not Found %S : %S",resourceName,field,fieldName));
        this.field = field;
        this.fieldName = fieldName;
        this.resourceName = resourceName;
    }

    public ResourceNotFoundException(String field, int fieldId, String resourceName) {
        super(String.format("%s Not Found %S : %d",field,resourceName,fieldId));
        this.field = field;
        this.fieldId = fieldId;
        this.resourceName = resourceName;
    }
}

package com.ezql.parser.util;

public class FieldDetails {
    String fieldName;
    String nestedParent;
    String fieldType;

    public FieldDetails(String field, String path, String type) {
	this.fieldName = field;
	this.nestedParent = path;
	this.fieldType = type;
    }

    public String getFieldName() {
	return fieldName;
    }

    public void setFieldName(String fieldName) {
	this.fieldName = fieldName;
    }

    public String getNestedParent() {
	return nestedParent;
    }

    public void setNestedParent(String path) {
	this.nestedParent = path;
    }

    public String getFieldType() {
	return fieldType;
    }

    public void setFieldType(String fieldType) {
	this.fieldType = fieldType;
    }

    @Override
    public String toString() {
	return "FieldDetails [fieldName=" + fieldName + ", nestedParent=" + nestedParent + ", fieldType=" + fieldType
		+ "]";
    }
}
package com.ezql.parser.util;

import java.util.HashMap;
import java.util.Map;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class EsMappingUtil {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormat
	    .forPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

    public static Map<String, FieldDetails> getFieldDetailsFromEsMapping(Map<String, Object> properties) {
	Map<String, FieldDetails> metadata = new HashMap<>();
	buildFieldMetaDataMap(metadata, "", "", properties);
	return metadata;
    }

    @SuppressWarnings("unchecked")
    private static void buildFieldMetaDataMap(Map<String, FieldDetails> metadata, String nestedPath, String fieldPath,
	    Map<String, Object> properties) {
	for (Map.Entry<String, Object> entry : properties.entrySet()) {
	    String fieldName = entry.getKey();
	    if (!"".equals(fieldPath)) {
		fieldName = fieldPath + "." + fieldName;
	    }
	    Map<String, Object> fieldValue = (Map<String, Object>) entry.getValue();
	    String esDataType = (String) fieldValue.get("type");

	    if (esDataType != null && !esDataType.equals("nested")) {
		metadata.put(fieldName.toLowerCase(), new FieldDetails(fieldName, nestedPath, esDataType));
	    } else {
		// nested or object type
		String newNestedPath = nestedPath;
		String newFieldPath = fieldPath;

		Object value = fieldValue.get("properties");
		// if object type then update in fieldPath
		// if nested type then update in nestedPath
		if (esDataType != null && esDataType.equals("nested")) {
		    if ("".equals(nestedPath))
			newNestedPath = fieldName;
		    else {
			newNestedPath = nestedPath + "." + fieldName;
		    }
		    newFieldPath = "";
		} else {
		    newFieldPath = fieldName;
		}
		buildFieldMetaDataMap(metadata, newNestedPath, newFieldPath, (Map<String, Object>) value);
	    }
	}
    }

    public static Object getObjectFromString(String type, String val) {
	if (val == null) {
	    return null;
	}
	switch (type.toLowerCase()) {
	case "string":
	    return val;
	case "float":
	case "double":
	    return Double.parseDouble(val);
	case "integer":
	case "long":
	case "short":
	    return Long.parseLong(val);
	case "date":
	case "timestamp":
	    return DATE_TIME_FORMATTER.parseDateTime(val);
	default:
	    break;
	}
	throw new IllegalArgumentException("Unknown datatype : " + type);
    }
}

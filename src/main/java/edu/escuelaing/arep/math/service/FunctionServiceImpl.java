package edu.escuelaing.arep.math.service;

import org.json.JSONObject;
import spark.Request;
import spark.Response;

public class FunctionServiceImpl {
	
	 public Object exp(Request req, Response res) {
        String val = req.queryParams("value");
        try {
        	Double num = Double.parseDouble(val);
        	Double result = Calculate.exp(num);
        	return toJson("exp", num, result);
        }
        catch (NumberFormatException e) {
        	return "Debe ingresar un número";
        }
	 }
	 
	 public Object cos(Request req, Response res) {
        String val = req.queryParams("value");
        try {
        	Double num = Double.parseDouble(val);
        	Double result = Calculate.cos(num);
        	return toJson("cos", num, result);
        }
        catch (NumberFormatException e) {
        	return "Debe ingresar un número";
        }
	 }
	 
	 private Object toJson(String operation, Double num, Double result) {
		JSONObject json = new JSONObject();
		json.put("operation", operation);
 		json.put("input", num);
 		json.put("output", result);
 		return json;
	 }
}

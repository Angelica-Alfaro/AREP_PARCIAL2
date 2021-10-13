package edu.escuelaing.arep.math.controller;

import static spark.Spark.get;
import static spark.Spark.post;
import spark.Request;
import spark.Response;

import edu.escuelaing.arep.math.service.FunctionServiceImpl;

/**
 * Class that manages service endpoints.
 * @author Angélica
 */
public class FunctionServiceController {
	/**
	 * Method that receive the service
	 * @param myFunctionServiceImpl - service to manage
	 */
	public FunctionServiceController(FunctionServiceImpl  myFunctionServiceImpl ) {
		get("/exp", (req,res) -> myFunctionServiceImpl.exp(req, res));
		get("/cos", (req, res) -> myFunctionServiceImpl.cos(req, res));
	}

}


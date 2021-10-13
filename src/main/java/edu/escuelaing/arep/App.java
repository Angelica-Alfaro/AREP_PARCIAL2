package edu.escuelaing.arep;

import static spark.Spark.*;

import edu.escuelaing.arep.math.controller.FunctionServiceController;
import edu.escuelaing.arep.math.service.FunctionServiceImpl;


/**
 * Communication  using java network management libraries.
 * @author Angélica
 *
 */
public class App {
	
	/**
	 * Start the web server
	 * @param args - server connection
	 */
	public static void main(String[] args) {
		port(getPort());
		new FunctionServiceController(new FunctionServiceImpl()); 
	}

	/**
	 * This method reads the default port as specified by the PORT variable in the
	 * environment.
	 *
	 * Provides the port so you need this to run the project.
	 */
	static int getPort() {
		if (System.getenv("PORT") != null) {
			return Integer.parseInt(System.getenv("PORT"));
		}
		return 4567; 
	}
}
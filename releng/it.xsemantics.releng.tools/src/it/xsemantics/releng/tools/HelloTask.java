/**
 * 
 */
package it.xsemantics.releng.tools;

import org.apache.tools.ant.Task;

/**
 * @author bettini
 * 
 */
public class HelloTask extends Task {
	public void execute() {
		String message = getProject().getProperty("ant.project.name");
		String passedDir = getProject().getProperty("passed.dir");

		log("Project: " + message);
		log("Hello from " + getLocation());
		log("passed.dir: " + passedDir);
	}
}

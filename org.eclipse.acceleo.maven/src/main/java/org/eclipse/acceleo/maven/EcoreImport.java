package org.eclipse.acceleo.maven;

import java.io.File;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author <a href="mailto:vincent.aranega@axellience.com">Vincent Aranega</a>
 */
public class EcoreImport {

	/**
	 * The project root containing .ecore files.
	 */
	private File root;
	
	/**
	 * List of folder that should be scanned.
	 */
	private List<String> inputs;

	/**
	 * Returns the project root.
	 * @return The project root as a {@File} Object.
	 */
	public File getRoot() {
		return root;
	}
	
	/**
	 * Returns the list of folder to scan.
	 * @return The list of folder to scan.
	 */
	public List<String> getInputs() {
		if (inputs == null) {
			this.inputs = new LinkedList<String>();
		}
		return inputs;
	}
	
	/**
	 * Default constructor
	 */
	public EcoreImport() {
		
	}
	
	/**
	 * 
	 * @param root The project root.
	 * @param inputs Paths to the folder that need to be scanned.
	 */
	public EcoreImport(File root, String... inputs) {
		this.root = root;
		Collections.addAll(getInputs(), inputs);
	}
	
	/**
	 * Scan the <i>inputs</i> folder in order to find
	 * <b>.ecore</b> files.
	 * @return The list of <b>.ecore</b> files found in the project.
	 */
	public List<File> getEcores() {
		List<File> results = new LinkedList<File>();
		for (String input : getInputs()) {
			File f = new File(root.getAbsolutePath() + "/" + input);
			results.addAll(scanForEcore(f));
		}
		
		return results;
	}
	
	private List<File> scanForEcore(File root) {
		List<File> tmpres = new LinkedList<File>();
		if (root.isFile()) {
			if (root.getName().endsWith(".ecore")) {
				tmpres.add(root);
			}
		} else {
			for (File inFile : root.listFiles()) {
				tmpres.addAll(scanForEcore(inFile));
			}
		}
		
		return tmpres;
	}
	
}

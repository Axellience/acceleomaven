/*******************************************************************************
 * Copyright (c) 2008, 2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.acceleo.maven;

import java.io.File;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class EcoreImport {

	/**
	 * The project root.
	 */
	private File root;
	
	/**
	 * 
	 */
	private List<String> inputs;

	/**
	 * 
	 * @return
	 */
	public File getRoot() {
		return root;
	}
	
	/**
	 * 
	 * @return
	 */
	public List<String> getInputs() {
		if (inputs == null) {
			this.inputs = new LinkedList<String>();
		}
		return inputs;
	}
	
	public EcoreImport() {
		
	}
	
	public EcoreImport(File root, String... inputs) {
		this.root = root;
		Collections.addAll(getInputs(), inputs);
	}
	
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

Acceleo Maven
=============

Acceleo Maven compilation plugin. Tweaks on original plugin (released by Obeo) to enable registration of .ecore files for .mtl compilation.  

Installation
------------
In `org.eclipse.acceleo.maven` folder, just use:
~~~
mvn clean install
~~~

Pom.xml Configuration
----------------------

The Acceleo Maven must be added to project pom.xml
~~~
...
  <build>
    <plugins>
      ...
      <plugin>
        <groupId>org.eclipse.acceleo</groupId>
        <artifactId>maven</artifactId>
        <version>3.2.2</version>
      </plugin>
      ...
    </plugins>
  </build>
~~~

Plugin configuration is the same as the original Acceleo Maven Compilation plugin with minor addition. You can indicate where the .ecore should be found. By default, .ecore file are always searched in the current project (on the whole project).

~~~
<groupId>org.eclipse.acceleo</groupId>
<artifactId>maven</artifactId>
<version>3.2.2</version>
<configuration>
  <ecoreImports>
	  <ecoreImport>
		  <root>my_directory</root>
			<inputs>
			  <input>src/main/java</input>
			</inputs>
		</ecoreImport>
	</ecoreImports>
</configuration>
~~~

This snippet add the project root "my_directory" as a .ecore project container and more precisely the "src/main/java" project folder.

Here is another exemple of a full configuration:

~~~
<groupId>org.eclipse.acceleo</groupId>
<artifactId>maven</artifactId>
<version>3.2.2</version>
<configuration>
  <failOnError>true</failOnError>
  <useBinaryResources>false</useBinaryResources>
  <usePlatformResourcePath>true</usePlatformResourcePath>
  <acceleoProject>
    <root>${project.basedir}</root>
    <entries>
      <entry>
        <input>src/main/java</input>
        <output>target/classes</output>
      </entry>
    </entries>
  </acceleoProject>
  <packagesToRegister>
    <packageToRegister>org.eclipse.uml2.uml.UMLPackage</packageToRegister> 
    <packageToRegister>org.eclipse.emf.ecore.EcorePackage</packageToRegister>
  </packagesToRegister>
  <ecoreImports>
	  <ecoreImport>
		  <root>my_directory</root>
			<inputs>
			  <input>src/main/java</input>
			</inputs>
		</ecoreImport>
	</ecoreImports>
</configuration>
~~~



Launch Project .mtl Compilation
------------------------

Compilation is called by invoking the following maven call. The plugin must be installed in your maven repository.
~~~
mvn org.eclipse.acceleo:maven:3.2.2:acceleo-compile compile
~~~

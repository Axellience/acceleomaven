Acceleo Maven
=============

Acceleo Maven compilation plugin. Tweaks on original plugin (released by Obeo) to enable registration of .ecore files for .mtl compilation.  

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

Launche Project .mtl Compilation
------------------------

Compilation is called by invoking the following maven call
~~~
mvn org.eclipse.acceleo:maven:3.2.2:acceleo-compile compile
~~~

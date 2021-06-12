**This is a Source Code Analyzer module**

This module takes a source code file from the web or stored locally on the computer and performs some Source Code Analysis.

It calculates the ***Lines of Code (LOC), Number of Classes (NOC)*** and the ***Number of Methods (NOM)***.

It uses two methods for calculating these metrics:

1. **regex** -> transforms source file into a single String
2. **strcomp** -> transforms source file into a String List

Afterwards the module creates an ***output file*** at a given path containing all the above methods. 
The **output file type** can be either ***csv*** or ***json***

You can call the program after building with Maven, by executing the below command:

***java -jar "jar with dependencies" arg0 arg1 arg2 arg3 arg4***

**arg0** -> Java source code input file (Path)
**arg1** -> Source code analyzer type (regex, strcomp)
**arg2** -> Source code location type (local, web)
**arg3** -> Output file path 
**arg4** -> Output file type (csv,json)

![Class Diagram](images/ClassDiagram?raw=true "Class Diafram")
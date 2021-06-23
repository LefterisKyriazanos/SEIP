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

![Class Diagram](images/ClassDiagram.jpg?raw=true)

I used the Facade Design Pattern.
The AnalyzerFacade class serves as a front-facing interface
masking more complex underlying or structural code.
I used it to provide a more simple interface to the system.

This design pattern adds more layers to the sub-system and defines an entry point to each sub-system.

**Drawbacks** 

AnalyzerFacade class is complex with multiple ***If else blocks***.
Expanding subsystems, as for example adding a new Analysis method different than REGEX and STRCOMP would require adding more if else blocks in the AnalyzerFacade class (more specifically the ***codeAnalyzer method***). Then the appropriate methods should be added to the class of the subsystem and of course the corresponding Test cases should be written. 

A good way to reduce complexity and duplication of code, improving extensibility would be to apply the bridge design pattern between the SourceCodeAnalyzer class and the SourceFileReader class. 

The MetricsExporter class can be extended easily right now by adding the appropriate export methods for the new file types. 

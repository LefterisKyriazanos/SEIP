# SEIP

[![Build Status](https://travis-ci.com/LefterisKyriazanos/SEIP.svg?token=8y5kSJ8xcysLgSMNifGc&branch=main)](https://travis-ci.com/LefterisKyriazanos/SEIP)

The purpose of this repository is to create a Maven project with modules. 
This is an assignment of the class "Software Engineering In Practice" i took as a Student of the Department of Management Science and Technology at the 
Athens University of economics and Business.

In this assignment i created a Maven parent - child project, that takes a text file with Student Grades and creates it's Histogram. 

I used eclipse as an IDE, java to write my main class and functions, and the java library jfreechart to generate the Histogram. 
I also used Maven to manage dependencies and packaging. 

One way to build and run this project using eclipse, is to clone this repository and import it to eclipse as a Maven project.
Then right-click on it and choose Run As -> Maven Install. 
This will Build the project. 

Then go the command line and run this command: 
  $ java -jar path-to-jar-file path-to-grades-file
  
  
 This will run the project and create the student Grades Histogram. 
  
  
 Prerequisites:
  Java 1.8
  Eclipse with its maven plugin installed
  


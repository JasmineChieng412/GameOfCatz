INTRODUCTION
--------------
The gameofcatz Menu module loads input files and lets user to find,add, remove 
or update their nodes and moves through a world made of those nodes.
The menu contains 10 options for the user to select such as to 
allow the user to load the data that they want as well as to 
display and save the data in to file.


REQUIREMENTS
---------------
The program does not require any additional files to run. 
All files are already prepared and provided in the folder. 

All files were given in .txt format.


INSTALLATION / COMPILATION
--------------------------
To compile the program and all of the .java files needed to 
run the program, enter in the command line:

user@ubuntu:~$javac readGraph.java
user@ubuntu:~$javac DSAGraphVertex.java 
user@ubuntu:~$javac DSAGraphEdge.java  
user@ubuntu:~$javac DSAGraph.java 
user@ubuntu:~$javac DSAStack.java 
user@ubuntu:~$javac DSAQueue.java 
user@ubuntu:~$javac DSABinarySearchTree.java 
user@ubuntu:~$javac DSALinkedList.java 
user@ubuntu:~$javac DSAListNode.java 
user@ubuntu:~$javac gameofcatz.java

Note: if you do not want to type all this, you can do
      this: user@ubuntu:~$javac javac *.java

CONFIGURATION
--------------
Compile all the necessary files then enter in the command line:

user@ubuntu:~$java gameofcatz

*The order of compilation does not matter because you will have 
already complied everything. But if you were to compile everything
separately, you are recommended to compile all .java files before
compiling gameofcatz.java.


FAQ
---
What if I mispelled a file name but I have entered all required 
the fields to enter to the menu?

-> You have to exit the menu and re-type all the required fields 
   correctly and double check before clicking enter.

/-----------------------------------------------------------------
Why do I have to compile every .java file first before 
compiling cryptoGraph.java?
-> It is because droneCollector.java is the main program to run 
   everything. Compiling it first might produce errors.



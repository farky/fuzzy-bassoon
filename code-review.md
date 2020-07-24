- try to externalize a configuration (application properties)
- instead of using while-do rather use do-while. it solves "zero iteration"
- in.hasNextLine() is redundant. in.nextLine() is blocking, and it waits for next line input
- readability: 
    - if it's possible, try to avoid using of structured expression negation
    - line 21: use constant with self explainable name
- create out PrintStream only in case if input stream is not empty or has any lines
- output file name pattern is used on the two places -> use constant or separate method for creating it. ideal both of them
- directory for creating new output files is not explicitly specified. but for listing created files yes. it should be same for both and only on one place (constant or parameter)
- listing created files - there can be files from previous run or any other files. all of them will be printed as a new created
- if it's not specified that directory should be cleared at the begging the listing should take into account the counter and show only new files (it's still not ideal. it shoud be cleared or use separate dedicated folder for each run)

next suggestions
- use logging instead of system.out
- write Javadocs
- write unit tests
- in maven pom.xml define source and target java versions
  

       
    

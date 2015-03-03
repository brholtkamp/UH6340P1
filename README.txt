COSC 6340 Project 1:
Brian Holtkamp  0875483
Kajol 1358284

Contributions to the Project:
Commit logs are on http://www.github.com/brholtkamp/UH6340/commit/master/

Compilation Instructions:
This project is built as a Maven project, so compilation can be done by:
    mvn compile
and executed with:
    mvn exec:java

Design:
This application is built in Java with the help of the ANTLR library.  ANTLR is a language library that builds a lexer/parser based upon a given grammar.  This is utilized in order to parse the SQL commands in a standard and safe way.  The grammar definition is contained within the SQL/SQL.g file.

The database functionality is done manually with ASCII text files and controlled interactions with the files.  Any edits to the dictionary are checked before commited to the file.  Any insertions into a table are checked before committed to the file.

The application mostly resides within a handful of classes:
    DataDictionary.java which handles all interaction with the Data Dictionary and creation of tables.
    SQLCommandHandler.java which parses the SQL commands and retains the data gathered from the SQL command.
    DBHandler.java which is the primary interface to the DB itself and utilizes the data from SQLCommandHandler in order to act accordingly to the user's input.
    Main.java is just used to allow for user input into DBHandler.handleCommand(String command).

The DB itself consists of a Data Dictionary file and individual files for the tables:
db.txt = Data Dictionary that contains table schemas
*.txt = Database tables themselves that exist within ./tables/*.txt

db.txt: Everything will be comma delimited, with newlines separating tuples
tableName,fieldName,dataType,fileLocation,\n
...

Example:
employee,id,INTEGER,employee.txt,
employee,name,STRING,employee.txt,
employee,division,STRING,employee.txt,
salary,id,INTEGER,salary.txt,
salary,salary,INTEGER,salary.txt,
...

*.txt: Everything will be comma delimited, with newlines separating tuples
field1,field2,field3,...\n
...

Example:
1,Alicia,Direction,
2,Bob,Production,
...

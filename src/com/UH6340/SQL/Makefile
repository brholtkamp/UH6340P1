ANTLRFILES = SQLLexer.java SQLBaseListener.java SQLListener.java SQLParser.java

all:
	antlr4 SQL.g
	javac $(ANTLRFILES) 

clean:
	rm $(ANTLRFILES) SQL*.class SQL*.tokens

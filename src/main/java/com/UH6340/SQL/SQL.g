grammar SQL;

// Parser Rules

commands        :   command commands
                |   command
                ;

command         :   tableCreation
                |   tableInsertion
                |   tableSelection
                ;

// Table creation requirements
tableCreation   :   'CREATE' table '(' fields ')'
                ;

table           :   NAME
                ;

fields          :   field ',' fields
                |   field
                ;

field           :   NAME TYPE
                ;

// Table insertion requirements
tableInsertion  :   'INSERT INTO' table '(' values ')'
                ;

values          :   value ',' values
                |   value
                ;

value           :   INTEGER
                |   CONSTANT
                ;

// Table selection requirements
tableSelection  :   'SELECT' selections 'FROM' tables 'WHERE' queries
                |   'SELECT' selections 'FROM' tables
                ;

selections      :   selection ',' selections
                |   selection
                ;

selection       :   EVERYTHING
                |   NAME
                ;

tables          :   table ',' tables
                |   table
                ;

queries         :   query ',' queries
                |   query
                ;

query           :   variable '=' variable
                ;

variable        :   NAME
                |   CONSTANT
                |   INTEGER
                ;

//Lexer Rules

NAME        :   (('a'..'z')('a'..'z' | '0'..'9')*)
            ;

CONSTANT    :   ('\'' (('A'..'Z') | ('a'..'z') | ('0'..'9') | ' ')+ '\'')
            ;

EVERYTHING  :   '*'
            ;

INTEGER     :   ('0'..'9')+
            ;

TYPE        :   ('INT'
            |   'STRING')
            ;

WHITESPACE  :   ('\t'
            |   ' '
            |   '\r'
            |   '\n'
            |   '\u000C')+
            ->  skip
            ;

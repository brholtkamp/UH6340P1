grammar SQL;

// Parser Rules

tableCreation   :   CREATE table values NEWLINE
                ;

tableInsertion  :   INSERT table values NEWLINE
                ;

tableSelection  :   SELECT selection FROM tables WHERE fieldOperation
                |   SELECT selection FROM tables
                ;

selection       :   //Something
                ;

fieldOperation  :   //Something
                ;


tables  :   table tables
        |   table
        ;

table   :   NAME
        ;

values  :   value values
        |   value
        ;

value   :   NAME TYPE COMMA
        |   NAME TYPE
        ;



//Lexer Rules

CREATE  :   'CREATE'
        ;

INSERT  :   'INSERT INTO'
        ;

SELECT  :   'SELECT'
        ;

FROM    :   'FROM'
        ;

WHERE   :   'WHERE'
        ;

NAME    :   ('a'..'z')+
        ;

TYPE    :   ('INT'
        |   'STRING')
        ;

COMMA   :   ','
        ;

NEWLINE :   '\n'
        ;

WHITESPACE  :   ('\t'
            |   ' '
            |   '\r'
            |   '\u000C')+
            ->  skip
            ;

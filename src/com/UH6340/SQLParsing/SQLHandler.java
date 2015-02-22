package com.UH6340.SQLParsing;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.Pair;

import java.util.ArrayList;

/**
 * Created by Brian Holtkamp on 2/21/2015.
 * Handles SQL commands
 */

public class SQLHandler {

// Class to handle the rule productions with ANTLR
    class SQLCommandListener extends SQLBaseListener {
        int commandType;
        ArrayList<String> tables = new ArrayList<String>();
        ArrayList<Pair<String, String>> fields = new ArrayList<Pair<String, String>>();
        ArrayList<String> values = new ArrayList<String>();
        ArrayList<String> selections = new ArrayList<String>();
        ArrayList<Pair<String, String>> queries = new ArrayList<Pair<String, String>>();

        // Determine command types
        @Override
        public void exitTableInsertion(SQLParser.TableInsertionContext context) {
            commandType = SQLParser.RULE_tableInsertion;
        }

        @Override
        public void exitTableCreation(SQLParser.TableCreationContext context) {
            commandType = SQLParser.RULE_tableCreation;
        }

        @Override
        public void exitTableSelection(SQLParser.TableSelectionContext context) {
            commandType = SQLParser.RULE_tableSelection;
        }

        int getCommandType() {
            String commandName = "undefined";
            switch(commandType) {
                case SQLParser.RULE_tableCreation:
                    commandName = "CREATE";
                    break;
                case SQLParser.RULE_tableInsertion:
                    commandName = "INSERT INTO";
                    break;
                case SQLParser.RULE_tableSelection:
                    commandName = "SELECT";
                    break;
            }
            System.out.println("Command is: " + commandName);

            return commandType;
        }

        @Override
        public void exitTable(SQLParser.TableContext context) {
            tables.add(context.getChild(0).toString());
        }

        ArrayList<String> getTables() {
            if (!tables.isEmpty()) {
                System.out.print("Tables: ");
                for (String table : tables) {
                    System.out.println(table);
                }
            }

            return tables;
        }

        @Override
        public void exitField(SQLParser.FieldContext context) {
            Pair<String, String> field = new Pair<String, String>(context.getChild(0).toString(), context.getChild(1).toString());
            fields.add(field);
        }

        ArrayList<Pair<String, String>> getFields() {
            if (!fields.isEmpty()) {
                System.out.print("Fields: ");
                for (Pair<String, String> field : fields) {
                    System.out.println(field.a + ":" + field.b);
                }
            }

            return fields;
        }

        @Override
        public void exitValue(SQLParser.ValueContext context) {
            values.add(context.getChild(0).toString());
        }

        ArrayList<String> getValues() {
            if (!values.isEmpty()) {
                System.out.print("Values: ");
                for (String value : values) {
                    System.out.println(value);
                }
            }

            return values;
        }

        @Override
        public void exitSelection(SQLParser.SelectionContext context) {
            selections.add(context.getChild(0).toString());
        }

        ArrayList<String> getSelections() {
            if (!selections.isEmpty()) {
                System.out.print("Selections: ");
                for (String selection : selections) {
                    System.out.println(selection);
                }
            }

            return selections;
        }

        @Override
        public void exitQuery(SQLParser.QueryContext context) {
            Pair<String, String> query = new Pair<String, String>(context.variable(0).getChild(0).toString(), context.variable(1).getChild(0).toString());
            queries.add(query);
        }

        ArrayList<Pair<String, String>> getQueries() {
            if (!queries.isEmpty()) {
                System.out.print("Queries: ");
                for (Pair<String, String> query : queries) {
                    System.out.println(query.a + ":" + query.b);
                }
            }

            return queries;
        }
    }

    public void handleMessage(String sqlCommand) {
        // Accept the SQL command
        SQLLexer lexer = new SQLLexer(new ANTLRInputStream(sqlCommand));

        // Tokenize the input
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // Send the tokens into the parser
        SQLParser parser = new SQLParser(tokens);

        // Add in an error listener in order to catch flaws in the inputs
        parser.addErrorListener(new BaseErrorListener() {
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer, Object wrongSymbol, int line, int row, String message, RecognitionException e) {
                System.err.println("Failed to parse at line " + line + ":" + row + ":" + message);
            }
        });

        // Add in the listener class defined above
        SQLCommandListener listener = new SQLCommandListener();
        parser.addParseListener(listener);

        // Find the command for this message
        parser.command();

        listener.getCommandType();
        listener.getTables();
        listener.getFields();
        listener.getValues();
        listener.getSelections();
        listener.getQueries();
        System.out.println();
    }

}

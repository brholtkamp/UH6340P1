package com.UH6340.SQL;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.Pair;

import java.util.ArrayList;

/**
 * Created by Brian Holtkamp on 2/21/2015.
 * Handles SQL commands
 *
 * Rule definitions:
 * CREATE table ( fields)
 * INSERT INTO table ( values )
 * SELECT selections FROM tables { WHERE queries }
 */

public class SQLHandler {
    int commandType = -1;
    ArrayList<String> tables = new ArrayList<String>();
    ArrayList<Pair<String, String>> fields = new ArrayList<Pair<String, String>>();
    ArrayList<String> values = new ArrayList<String>();
    ArrayList<String> selections = new ArrayList<String>();
    ArrayList<Pair<String, String>> queries = new ArrayList<Pair<String, String>>();

    // Class to handle the rule productions with ANTLR
    class SQLCommandListener extends SQLBaseListener {
        int commandType = -1;
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
            return commandType;
        }

        void printCommandType() {
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
                default:
                    break;
            }
            System.out.println("Command is: " + commandName);
        }

        @Override
        public void exitTable(SQLParser.TableContext context) {
            tables.add(context.getChild(0).toString());
        }

        ArrayList<String> getTables() {
            return tables;
        }

        void printTables() {
            if (!tables.isEmpty()) {
                System.out.print("Tables: ");
                for (String table : tables) {
                    System.out.println(table);
                }
            }
        }

        @Override
        public void exitField(SQLParser.FieldContext context) {
            Pair<String, String> field = new Pair<String, String>(context.getChild(0).toString(), context.getChild(1).toString());
            fields.add(field);
        }

        ArrayList<Pair<String, String>> getFields() {
            return fields;
        }

        void printFields() {
            if (!fields.isEmpty()) {
                System.out.print("Fields: ");
                for (Pair<String, String> field : fields) {
                    System.out.println(field.a + ":" + field.b);
                }
            }
        }

        @Override
        public void exitValue(SQLParser.ValueContext context) {
            values.add(context.getChild(0).toString());
        }

        ArrayList<String> getValues() {
            return values;
        }

        void printValues() {
            if (!values.isEmpty()) {
                System.out.print("Values: ");
                for (String value : values) {
                    System.out.println(value);
                }
            }
        }

        @Override
        public void exitSelection(SQLParser.SelectionContext context) {
            selections.add(context.getChild(0).toString());
        }

        ArrayList<String> getSelections() {
            return selections;
        }

        void printSelections() {
            if (!selections.isEmpty()) {
                System.out.print("Selections: ");
                for (String selection : selections) {
                    System.out.println(selection);
                }
            }
        }

        @Override
        public void exitQuery(SQLParser.QueryContext context) {
            Pair<String, String> query = new Pair<String, String>(context.variable(0).getChild(0).toString(), context.variable(1).getChild(0).toString());
            queries.add(query);
        }

        ArrayList<Pair<String, String>> getQueries() {
            return queries;
        }

        void printQueries() {
            if (!queries.isEmpty()) {
                System.out.print("Queries: ");
                for (Pair<String, String> query : queries) {
                    System.out.println(query.a + ":" + query.b);
                }
            }
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

        reset();
        copyResults(listener);
    }

    private void reset() {
        commandType = -1;
        tables.clear();
        fields.clear();
        values.clear();
        selections.clear();
        queries.clear();
    }

    private void copyResults(SQLCommandListener listener) {
        commandType = listener.getCommandType();
        tables = listener.getTables();
        fields = listener.getFields();
        values = listener.getValues();
        selections = listener.getSelections();
        queries = listener.getQueries();
    }

    public void printCommand(SQLCommandListener listener) {
        listener.printCommandType();
        listener.printTables();
        listener.printFields();
        listener.printSelections();
        listener.printValues();
        listener.printQueries();
        System.out.println();
    }

    public int getCommandType() {
        return commandType;
    }

    public ArrayList<String> getTables() {
        return tables;
    }

    public ArrayList<Pair<String, String>> getFields() {
        return fields;
    }

    public ArrayList<String> getValues() {
        return values;
    }

    public ArrayList<String> getSelections() {
        return selections;
    }

    public ArrayList<Pair<String, String>> getQueries() {
        return queries;
    }
}

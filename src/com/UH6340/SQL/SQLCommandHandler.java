package com.UH6340.SQL;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.Pair;
import org.antlr.v4.runtime.misc.ParseCancellationException;

import java.util.ArrayList;

/**
 * Created by Brian Holtkamp on 2/21/2015.
 * Handles SQL queries
 *
 * Rule definitions:
 * CREATE table ( fields)
 * INSERT INTO table ( values )
 * SELECT selections FROM tables { WHERE queries }
 */


public class SQLCommandHandler {
    final static int maxStringSize = 64;

    int queryType = -1;
    ArrayList<String> tables = new ArrayList<String>();
    ArrayList<Pair<String, String>> fields = new ArrayList<Pair<String, String>>();
    ArrayList<String> values = new ArrayList<String>();
    ArrayList<String> selections = new ArrayList<String>();
    ArrayList<Pair<String, String>> queries = new ArrayList<Pair<String, String>>();

    // Class to handle the rule productions with ANTLR
    class SQLCommandListener extends SQLBaseListener {
        int queryType = -1;
        ArrayList<String> tables = new ArrayList<String>();
        ArrayList<Pair<String, String>> fields = new ArrayList<Pair<String, String>>();
        ArrayList<String> values = new ArrayList<String>();
        ArrayList<String> selections = new ArrayList<String>();
        ArrayList<Pair<String, String>> queries = new ArrayList<Pair<String, String>>();

        // Determine command types
        @Override
        public void exitTableInsertion(SQLParser.TableInsertionContext context) {
            queryType = SQLParser.RULE_tableInsertion;
        }

        @Override
        public void exitTableCreation(SQLParser.TableCreationContext context) {
            queryType = SQLParser.RULE_tableCreation;
        }

        @Override
        public void exitTableSelection(SQLParser.TableSelectionContext context) {
            queryType = SQLParser.RULE_tableSelection;
        }

        int getQueryType() {
            return queryType;
        }

        @Override
        public void exitTable(SQLParser.TableContext context) {
            tables.add(context.getChild(0).toString());
        }

        ArrayList<String> getTables() {
            return tables;
        }

        @Override
        public void exitField(SQLParser.FieldContext context) {
            if (context.getChild(0).toString().replaceAll("\"", "").length() > maxStringSize) {
                throw new ParseCancellationException("Name exceeds " + maxStringSize + " size: " + context.getChild(0).toString().replaceAll("\"", ""));
            }

            Pair<String, String> field = new Pair<String, String>(context.getChild(0).toString().replaceAll("\"", ""), context.getChild(1).toString().replaceAll("\"", ""));
            fields.add(field);
        }

        ArrayList<Pair<String, String>> getFields() {
            return fields;
        }

        @Override
        public void exitValue(SQLParser.ValueContext context) {
            if (context.getChild(0).toString().replaceAll("\"", "").length() > maxStringSize) {
                throw new ParseCancellationException("String exceeds " + maxStringSize + " size: " + context.getChild(0).toString().replaceAll("\"", ""));
            }

            values.add(context.getChild(0).toString().replaceAll("\"", ""));
        }

        ArrayList<String> getValues() {
            return values;
        }

        @Override
        public void exitSelection(SQLParser.SelectionContext context) {
            selections.add(context.getChild(0).toString());
        }

        ArrayList<String> getSelections() {
            return selections;
        }

        @Override
        public void exitQuery(SQLParser.QueryContext context) {
            Pair<String, String> query = new Pair<String, String>(context.variable(0).getChild(0).toString(), context.variable(1).getChild(0).toString());
            queries.add(query);
        }

        ArrayList<Pair<String, String>> getQueries() {
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

        reset();
        copyResults(listener);
    }

    private void reset() {
        queryType = -1;
        tables.clear();
        fields.clear();
        values.clear();
        selections.clear();
        queries.clear();
    }

    private void copyResults(SQLCommandListener listener) {
        queryType = listener.getQueryType();
        tables = listener.getTables();
        fields = listener.getFields();
        values = listener.getValues();
        selections = listener.getSelections();
        queries = listener.getQueries();
    }

    public int getQueryType() {
        return queryType;
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

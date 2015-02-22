// Generated from SQL.g by ANTLR 4.5

package com.UH6340.SQLParsing;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SQLParser}.
 */
public interface SQLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SQLParser#commands}.
	 * @param ctx the parse tree
	 */
	void enterCommands(SQLParser.CommandsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#commands}.
	 * @param ctx the parse tree
	 */
	void exitCommands(SQLParser.CommandsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#command}.
	 * @param ctx the parse tree
	 */
	void enterCommand(SQLParser.CommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#command}.
	 * @param ctx the parse tree
	 */
	void exitCommand(SQLParser.CommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#tableCreation}.
	 * @param ctx the parse tree
	 */
	void enterTableCreation(SQLParser.TableCreationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#tableCreation}.
	 * @param ctx the parse tree
	 */
	void exitTableCreation(SQLParser.TableCreationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#table}.
	 * @param ctx the parse tree
	 */
	void enterTable(SQLParser.TableContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#table}.
	 * @param ctx the parse tree
	 */
	void exitTable(SQLParser.TableContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#fields}.
	 * @param ctx the parse tree
	 */
	void enterFields(SQLParser.FieldsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#fields}.
	 * @param ctx the parse tree
	 */
	void exitFields(SQLParser.FieldsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#field}.
	 * @param ctx the parse tree
	 */
	void enterField(SQLParser.FieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#field}.
	 * @param ctx the parse tree
	 */
	void exitField(SQLParser.FieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#tableInsertion}.
	 * @param ctx the parse tree
	 */
	void enterTableInsertion(SQLParser.TableInsertionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#tableInsertion}.
	 * @param ctx the parse tree
	 */
	void exitTableInsertion(SQLParser.TableInsertionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#values}.
	 * @param ctx the parse tree
	 */
	void enterValues(SQLParser.ValuesContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#values}.
	 * @param ctx the parse tree
	 */
	void exitValues(SQLParser.ValuesContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(SQLParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(SQLParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#tableSelection}.
	 * @param ctx the parse tree
	 */
	void enterTableSelection(SQLParser.TableSelectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#tableSelection}.
	 * @param ctx the parse tree
	 */
	void exitTableSelection(SQLParser.TableSelectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#selections}.
	 * @param ctx the parse tree
	 */
	void enterSelections(SQLParser.SelectionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#selections}.
	 * @param ctx the parse tree
	 */
	void exitSelections(SQLParser.SelectionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#selection}.
	 * @param ctx the parse tree
	 */
	void enterSelection(SQLParser.SelectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#selection}.
	 * @param ctx the parse tree
	 */
	void exitSelection(SQLParser.SelectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#tables}.
	 * @param ctx the parse tree
	 */
	void enterTables(SQLParser.TablesContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#tables}.
	 * @param ctx the parse tree
	 */
	void exitTables(SQLParser.TablesContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#queries}.
	 * @param ctx the parse tree
	 */
	void enterQueries(SQLParser.QueriesContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#queries}.
	 * @param ctx the parse tree
	 */
	void exitQueries(SQLParser.QueriesContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#query}.
	 * @param ctx the parse tree
	 */
	void enterQuery(SQLParser.QueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#query}.
	 * @param ctx the parse tree
	 */
	void exitQuery(SQLParser.QueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(SQLParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(SQLParser.VariableContext ctx);
}
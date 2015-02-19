// Generated from SQL.g by ANTLR 4.4
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SQLParser}.
 */
public interface SQLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SQLParser#tables}.
	 * @param ctx the parse tree
	 */
	void enterTables(@NotNull SQLParser.TablesContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#tables}.
	 * @param ctx the parse tree
	 */
	void exitTables(@NotNull SQLParser.TablesContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#tableInsertion}.
	 * @param ctx the parse tree
	 */
	void enterTableInsertion(@NotNull SQLParser.TableInsertionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#tableInsertion}.
	 * @param ctx the parse tree
	 */
	void exitTableInsertion(@NotNull SQLParser.TableInsertionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#selection}.
	 * @param ctx the parse tree
	 */
	void enterSelection(@NotNull SQLParser.SelectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#selection}.
	 * @param ctx the parse tree
	 */
	void exitSelection(@NotNull SQLParser.SelectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#fieldOperation}.
	 * @param ctx the parse tree
	 */
	void enterFieldOperation(@NotNull SQLParser.FieldOperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#fieldOperation}.
	 * @param ctx the parse tree
	 */
	void exitFieldOperation(@NotNull SQLParser.FieldOperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#values}.
	 * @param ctx the parse tree
	 */
	void enterValues(@NotNull SQLParser.ValuesContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#values}.
	 * @param ctx the parse tree
	 */
	void exitValues(@NotNull SQLParser.ValuesContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#tableSelection}.
	 * @param ctx the parse tree
	 */
	void enterTableSelection(@NotNull SQLParser.TableSelectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#tableSelection}.
	 * @param ctx the parse tree
	 */
	void exitTableSelection(@NotNull SQLParser.TableSelectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(@NotNull SQLParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(@NotNull SQLParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#table}.
	 * @param ctx the parse tree
	 */
	void enterTable(@NotNull SQLParser.TableContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#table}.
	 * @param ctx the parse tree
	 */
	void exitTable(@NotNull SQLParser.TableContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#tableCreation}.
	 * @param ctx the parse tree
	 */
	void enterTableCreation(@NotNull SQLParser.TableCreationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#tableCreation}.
	 * @param ctx the parse tree
	 */
	void exitTableCreation(@NotNull SQLParser.TableCreationContext ctx);
}
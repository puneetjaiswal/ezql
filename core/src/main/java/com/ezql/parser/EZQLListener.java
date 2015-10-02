// Generated from ./src/main/java/com/ezql/parser/EZQL.g4 by ANTLR 4.5
package com.ezql.parser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link EZQLParser}.
 */
public interface EZQLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link EZQLParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(EZQLParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link EZQLParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(EZQLParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link EZQLParser#selectdb}.
	 * @param ctx the parse tree
	 */
	void enterSelectdb(EZQLParser.SelectdbContext ctx);
	/**
	 * Exit a parse tree produced by {@link EZQLParser#selectdb}.
	 * @param ctx the parse tree
	 */
	void exitSelectdb(EZQLParser.SelectdbContext ctx);
	/**
	 * Enter a parse tree produced by {@link EZQLParser#limitclause}.
	 * @param ctx the parse tree
	 */
	void enterLimitclause(EZQLParser.LimitclauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link EZQLParser#limitclause}.
	 * @param ctx the parse tree
	 */
	void exitLimitclause(EZQLParser.LimitclauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link EZQLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(EZQLParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link EZQLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(EZQLParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link EZQLParser#text_predicate}.
	 * @param ctx the parse tree
	 */
	void enterText_predicate(EZQLParser.Text_predicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link EZQLParser#text_predicate}.
	 * @param ctx the parse tree
	 */
	void exitText_predicate(EZQLParser.Text_predicateContext ctx);
	/**
	 * Enter a parse tree produced by {@link EZQLParser#predicate}.
	 * @param ctx the parse tree
	 */
	void enterPredicate(EZQLParser.PredicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link EZQLParser#predicate}.
	 * @param ctx the parse tree
	 */
	void exitPredicate(EZQLParser.PredicateContext ctx);
	/**
	 * Enter a parse tree produced by {@link EZQLParser#singleValuePredicate}.
	 * @param ctx the parse tree
	 */
	void enterSingleValuePredicate(EZQLParser.SingleValuePredicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link EZQLParser#singleValuePredicate}.
	 * @param ctx the parse tree
	 */
	void exitSingleValuePredicate(EZQLParser.SingleValuePredicateContext ctx);
	/**
	 * Enter a parse tree produced by {@link EZQLParser#multiValuePredicate}.
	 * @param ctx the parse tree
	 */
	void enterMultiValuePredicate(EZQLParser.MultiValuePredicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link EZQLParser#multiValuePredicate}.
	 * @param ctx the parse tree
	 */
	void exitMultiValuePredicate(EZQLParser.MultiValuePredicateContext ctx);
	/**
	 * Enter a parse tree produced by {@link EZQLParser#rangePredicate}.
	 * @param ctx the parse tree
	 */
	void enterRangePredicate(EZQLParser.RangePredicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link EZQLParser#rangePredicate}.
	 * @param ctx the parse tree
	 */
	void exitRangePredicate(EZQLParser.RangePredicateContext ctx);
	/**
	 * Enter a parse tree produced by {@link EZQLParser#low}.
	 * @param ctx the parse tree
	 */
	void enterLow(EZQLParser.LowContext ctx);
	/**
	 * Exit a parse tree produced by {@link EZQLParser#low}.
	 * @param ctx the parse tree
	 */
	void exitLow(EZQLParser.LowContext ctx);
	/**
	 * Enter a parse tree produced by {@link EZQLParser#high}.
	 * @param ctx the parse tree
	 */
	void enterHigh(EZQLParser.HighContext ctx);
	/**
	 * Exit a parse tree produced by {@link EZQLParser#high}.
	 * @param ctx the parse tree
	 */
	void exitHigh(EZQLParser.HighContext ctx);
	/**
	 * Enter a parse tree produced by {@link EZQLParser#values}.
	 * @param ctx the parse tree
	 */
	void enterValues(EZQLParser.ValuesContext ctx);
	/**
	 * Exit a parse tree produced by {@link EZQLParser#values}.
	 * @param ctx the parse tree
	 */
	void exitValues(EZQLParser.ValuesContext ctx);
	/**
	 * Enter a parse tree produced by {@link EZQLParser#field}.
	 * @param ctx the parse tree
	 */
	void enterField(EZQLParser.FieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link EZQLParser#field}.
	 * @param ctx the parse tree
	 */
	void exitField(EZQLParser.FieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link EZQLParser#function_group_by}.
	 * @param ctx the parse tree
	 */
	void enterFunction_group_by(EZQLParser.Function_group_byContext ctx);
	/**
	 * Exit a parse tree produced by {@link EZQLParser#function_group_by}.
	 * @param ctx the parse tree
	 */
	void exitFunction_group_by(EZQLParser.Function_group_byContext ctx);
	/**
	 * Enter a parse tree produced by {@link EZQLParser#text}.
	 * @param ctx the parse tree
	 */
	void enterText(EZQLParser.TextContext ctx);
	/**
	 * Exit a parse tree produced by {@link EZQLParser#text}.
	 * @param ctx the parse tree
	 */
	void exitText(EZQLParser.TextContext ctx);
	/**
	 * Enter a parse tree produced by {@link EZQLParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(EZQLParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link EZQLParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(EZQLParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link EZQLParser#count_function}.
	 * @param ctx the parse tree
	 */
	void enterCount_function(EZQLParser.Count_functionContext ctx);
	/**
	 * Exit a parse tree produced by {@link EZQLParser#count_function}.
	 * @param ctx the parse tree
	 */
	void exitCount_function(EZQLParser.Count_functionContext ctx);
	/**
	 * Enter a parse tree produced by {@link EZQLParser#sum_function}.
	 * @param ctx the parse tree
	 */
	void enterSum_function(EZQLParser.Sum_functionContext ctx);
	/**
	 * Exit a parse tree produced by {@link EZQLParser#sum_function}.
	 * @param ctx the parse tree
	 */
	void exitSum_function(EZQLParser.Sum_functionContext ctx);
}
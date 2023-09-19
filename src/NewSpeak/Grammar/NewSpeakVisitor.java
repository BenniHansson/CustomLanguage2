// Generated from C:/Github/CustomLanguage/src/NewSpeak/Grammar\NewSpeak.g4 by ANTLR 4.12.0
package NewSpeak.Grammar;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link NewSpeakParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface NewSpeakVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link NewSpeakParser#file}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFile(NewSpeakParser.FileContext ctx);
	/**
	 * Visit a parse tree produced by {@link NewSpeakParser#code}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCode(NewSpeakParser.CodeContext ctx);
	/**
	 * Visit a parse tree produced by {@link NewSpeakParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(NewSpeakParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link NewSpeakParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl(NewSpeakParser.DeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link NewSpeakParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(NewSpeakParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NewSpeakParser#unaryexpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryexpression(NewSpeakParser.UnaryexpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link NewSpeakParser#addexpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddexpression(NewSpeakParser.AddexpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link NewSpeakParser#subexpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubexpression(NewSpeakParser.SubexpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link NewSpeakParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(NewSpeakParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link NewSpeakParser#while}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile(NewSpeakParser.WhileContext ctx);
	/**
	 * Visit a parse tree produced by {@link NewSpeakParser#whilecondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhilecondition(NewSpeakParser.WhileconditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link NewSpeakParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(NewSpeakParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link NewSpeakParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(NewSpeakParser.PrintContext ctx);
}
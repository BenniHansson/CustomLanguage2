package NewSpeak;

import NewSpeak.Grammar.NewSpeakBaseListener;
import NewSpeak.Grammar.NewSpeakParser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.sql.SQLOutput;
import java.util.LinkedList;

public class CompileNewSpeak extends NewSpeakBaseListener {
    StringBuilder compiled = new StringBuilder();
    int loopCounter = 0;

    LinkedList<Integer> loopStack = new LinkedList<>();

    @Override public void enterFile(NewSpeakParser.FileContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitFile(NewSpeakParser.FileContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterCode(NewSpeakParser.CodeContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitCode(NewSpeakParser.CodeContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterStatement(NewSpeakParser.StatementContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitStatement(NewSpeakParser.StatementContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterDecl(NewSpeakParser.DeclContext ctx) {
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitDecl(NewSpeakParser.DeclContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterAssign(NewSpeakParser.AssignContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitAssign(NewSpeakParser.AssignContext ctx) {
        compiledLine("pop " + ctx.ID().getText());
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterWhile(NewSpeakParser.WhileContext ctx) {
        loopCounter ++;
        loopStack.push(loopCounter);
        compiledLine("label enterLoop" + loopCounter);



    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitWhile(NewSpeakParser.WhileContext ctx) {
        int exitCounter = loopStack.pop();
        compiledLine("goto enterLoop"+exitCounter);
        compiledLine("label exitLoop"+exitCounter);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterWhilecondition(NewSpeakParser.WhileconditionContext ctx) {
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitWhilecondition(NewSpeakParser.WhileconditionContext ctx) {
        String operation = "";

        switch (ctx.condition().getText()) {
            case "greater" -> operation= "gt";
            case "ungreater" -> operation= "lt";
            case "equal" -> operation= "eq";
        }
        compiledLine(operation);
        compiledLine("not");
        compiledLine("if-goto exitLoop"+loopCounter);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterCondition(NewSpeakParser.ConditionContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitCondition(NewSpeakParser.ConditionContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterAddexpression(NewSpeakParser.AddexpressionContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitAddexpression(NewSpeakParser.AddexpressionContext ctx) {
        compiledLine("add");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */

    @Override public void enterSubexpression(NewSpeakParser.SubexpressionContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitSubexpression(NewSpeakParser.SubexpressionContext ctx) {
        compiledLine("sub");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterUnaryexpression(NewSpeakParser.UnaryexpressionContext ctx) {
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitUnaryexpression(NewSpeakParser.UnaryexpressionContext ctx) {
        String value = "";
        if(ctx.ID() == null) {
            value = ctx.INT().getText();
        }
        else {
            value = ctx.ID().getText();
        }
        compiled.append("push ");
        compiledLine(value);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterPrint(NewSpeakParser.PrintContext ctx) {
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitPrint(NewSpeakParser.PrintContext ctx) {
        String value = "";
        if(ctx.ID() == null) {
            value = ctx.INT().getText();
        }
        else {
            value = ctx.ID().getText();
        }
        compiledLine("print "+value);

    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterExpr(NewSpeakParser.ExprContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitExpr(NewSpeakParser.ExprContext ctx) { }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterEveryRule(ParserRuleContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitEveryRule(ParserRuleContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void visitTerminal(TerminalNode node) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void visitErrorNode(ErrorNode node) { }

    private void compiledLine(String line) {
        compiled.append(line).append("\n");
    }

    public String getCompiled() {
        return compiled.toString();
    }
}

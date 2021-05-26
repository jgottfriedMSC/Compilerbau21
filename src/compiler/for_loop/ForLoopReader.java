package compiler.for_loop;

import compiler.*;

public class ForLoopReader implements ForLoopReaderIntf {

    private final CompileEnvIntf compileEnv;
    private final StmtReaderIntf stmtReader;
    private final ExprReaderIntf exprReader;
    private final LexerIntf lexer;

    public ForLoopReader(CompileEnvIntf compileEnv, StmtReaderIntf stmtReader, ExprReaderIntf exprReader, LexerIntf lexer) {
        this.compileEnv = compileEnv;
        this.stmtReader = stmtReader;
        this.exprReader = exprReader;
        this.lexer = lexer;
    }

    public void readForLoop() throws Exception {
        final InstrBlock prevBlock = compileEnv.getCurrentBlock();
        final InstrBlock postIterationBlock = compileEnv.createBlock();
        lexer.advance();
        lexer.expect(Token.Type.LPAREN);
        stmtReader.getStmt();
        final InstrBlock forLoopBlock = compileEnv.createBlock();
        prevBlock.addInstr(new Instr.JumpInstr(forLoopBlock));
        compileEnv.setCurrentBlock(postIterationBlock);
        exprReader.getExpr();
        lexer.expect(Token.Type.SEMICOL);
        stmtReader.getStmt();
        lexer.expect(Token.Type.RPAREN);
        compileEnv.setCurrentBlock(forLoopBlock);
        stmtReader.getBlockStmt();
        final InstrBlock postBlock = compileEnv.createBlock();
        compileEnv.setCurrentBlock(postBlock);
        stmtReader.getStmtList();
        compileEnv.setCurrentBlock(forLoopBlock);
        final Instr.JumpInstr jump = new Instr.JumpInstr(postIterationBlock);
        final Instr.JumpCondInstr condInstr = new Instr.JumpCondInstr(forLoopBlock, postBlock);
        forLoopBlock.addInstr(jump);
        postIterationBlock.addInstr(condInstr);
        compileEnv.setCurrentBlock(prevBlock);
    }

}

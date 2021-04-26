package compiler;

public interface NumberCalcIntf {
	
    // creates a NumberCalc for a given FileReader
	// NumberCalcIntf(FileReaderIntf reader)
	
	/** calculate sum
	 * grammar rule:
	 * sum : product (PLUS product)*
	 */
	int getSum() throws Exception;

	/** calculate product
	 * grammar rule:
	 * product: unaryMinus (MUL unaryMinus)*
	 */
	int getProduct() throws Exception;
	
	/** calculate unary minus expr
	 * unaryMinusExpr: MINUS? atomicExpr
	 */
	int getUnaryMinusExpr() throws Exception;
	
	/** calculate atomic expr
	 * atomicExpr : NUMBER
	 * atomicExpr : LPAREN sum RPAREN
	 */
	int getAtomicExpr() throws Exception;

}

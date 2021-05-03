package compiler;

public class NumberCalc implements NumberCalcIntf {
	
	FileReaderIntf m_fileReader;
	NumberReaderIntf m_numberReader;

    // creates a NumberCalc for a given FileReader
	// NumberCalcIntf(FileReaderIntf reader)
	public NumberCalc(FileReaderIntf reader) {
		m_fileReader = reader;
		m_numberReader = new NumberReader(reader);
	}
	
	/** calculate sum
	 * grammar rule:
	 * sum : product (PLUS product)*
	 */
	public int getSum() throws Exception {
		int result = getProduct();
		char c = m_fileReader.lookAheadChar();
		while (c == '+') {
			m_fileReader.expect('+');
			result += getProduct();
			c = m_fileReader.lookAheadChar();
		}
		return result;
	}

	/** calculate product
	 * grammar rule:
	 * product: unaryMinus (MUL unaryMinus)*
	 */
	public int getProduct() throws Exception {
		int result = getUnaryMinusExpr();
		char c = m_fileReader.lookAheadChar();
		while (c == '*') {
			m_fileReader.expect('*');
			result *= getProduct();
			c = m_fileReader.lookAheadChar();
		}
		return result;
	}

	/** calculate unary minus expr
	 * unaryMinusExpr: MINUS? atomicExpr
	 */
	public int getUnaryMinusExpr() throws Exception {
		int result = 0;
		int sign = 1;
		char c = m_fileReader.lookAheadChar();
		if (c == '-') {
			m_fileReader.advance();
			sign = -1;
		}
		result = getAtomicExpr();
		result *= sign;
		return result;
	}

	/** calculate atomic expr
	 * atomicExpr : NUMBER
	 * atomicExpr : LPAREN sum RPAREN
	 */
	public int getAtomicExpr() throws Exception {
		char c = m_fileReader.lookAheadChar();
		int result = 0;
		if (c == '(') {
			m_fileReader.advance();
			result = getSum();
			m_fileReader.expect(')');
		} else {
			result = m_numberReader.getNumber();
		}
		
		return result;
	}

}

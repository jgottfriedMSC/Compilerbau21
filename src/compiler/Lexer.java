package compiler;

import compiler.TokenIntf.Type;

public class Lexer implements LexerIntf {
	private FileReaderIntf m_reader;
	private Token m_nextToken;

    // construct a Lexer from the given file reader
	public Lexer(FileReaderIntf reader) throws Exception {
		m_reader = reader;
		advance();
	}
	
	public Token lookAheadToken() {
		return m_nextToken;
	}
	
	@Override
	public void advance() throws Exception {
		// skip white spaces
        while (isWhiteSpace(m_reader.lookAheadChar())) {
        	m_reader.advance();
        }
		// determine token type
        Token.Type tokenType = getTokenType(m_reader.lookAheadChar());
		m_nextToken = new Token();
		m_nextToken.m_type = tokenType;

        // read token content
		if (tokenType == Token.Type.INTEGER) {
			m_nextToken.m_intValue = getNumber();
		} else if (tokenType == Token.Type.IDENT) {
			m_nextToken.m_stringValue = getIdent();
		} else {
			m_reader.advance();
		}	
	}

	public void expect(Type tokenType) throws Exception {
		if (m_nextToken.m_type != tokenType) {
			throw new Exception();
		} else {
			advance();
		}
	}
	
	public Token.Type getTokenType(char firstChar) throws Exception {
		Token.Type tokenType;
		if (firstChar == '(') {
			tokenType = Token.Type.LPAREN;
		} else if (firstChar == ')') {
			tokenType = Token.Type.RPAREN;			
		} else if (firstChar == '+') {
			tokenType = Token.Type.PLUS;			
		} else if (firstChar == '*') {
			tokenType = Token.Type.MUL;			
		} else if (firstChar == '=') {
			tokenType = Token.Type.ASSIGN;			
		} else if (firstChar == 0) {
			tokenType = Token.Type.EOF;			
		} else if (isDigit(firstChar)) {
			tokenType = Token.Type.INTEGER;			
		} else if (isIdentifierStart(firstChar)) {
			tokenType = Token.Type.IDENT;			
		} else {
			throw new Exception();
		}
		return tokenType;
	}
	
	@Override
	public String getIdent() throws Exception {
		String ident = new String();
		char nextChar = m_reader.lookAheadChar();
		do {
			ident += nextChar;
			m_reader.advance();
			nextChar = m_reader.lookAheadChar();
		} while (isIdentifierPart(nextChar));
		return ident;
	}

	// 'az' 'AZ' '0-9' '_'
	public boolean isIdentifierPart(char c) {
		boolean isIdentifierPart = false;
		if (c >= 'a' && c <= 'z') {
			isIdentifierPart = true;
		} else if (c >= 'A' && c <= 'Z') {
			isIdentifierPart = true;
		} else if (c >= '0' && c <= '9') {
			isIdentifierPart = true;
		} else if (c == '_') {
			isIdentifierPart = true;
		}
		return isIdentifierPart;
	}

	public boolean isIdentifierStart(char c) {
		boolean isIdentifierPart = false;
		if (c >= 'a' && c <= 'z') {
			isIdentifierPart = true;
		} else if (c >= 'A' && c <= 'Z') {
			isIdentifierPart = true;
		} else if (c == '_') {
			isIdentifierPart = true;
		}
		return isIdentifierPart;
	}

	@Override
	public int getNumber() throws Exception {
		int result = 0;
		char nextChar = m_reader.lookAheadChar();
		do {
			result *= 10;
			result += nextChar - '0';
			m_reader.advance();
			nextChar = m_reader.lookAheadChar();
		} while (isDigit(nextChar));
		return result;
	}

	@Override
	public boolean isDigit(char c) {
		boolean isDigit = (c >= '0' && c <= '9') ? true : false; 
		return isDigit;
	}

	@Override
	public boolean isWhiteSpace(char c) {
		boolean isWhitespace = Character.isWhitespace(c);
		return isWhitespace;
	}

}

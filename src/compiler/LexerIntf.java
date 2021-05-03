package compiler;

public interface LexerIntf {
	
    // construct a Lexer from the given file reader
	// public LexerIntf(FileReaderIntf reader) throws Exception

	/**
	 *  look at the current token without consuming it
	 *  @returns current token
	 */
	public Token lookAheadToken();

	/** 
	 * consume current token and advances to next token
	 */
	public void advance() throws Exception;
	
	/**
	 *  check if next token is the expected token
	 *  throws exception if not
	 */
	public void expect(Token.Type tokenType) throws Exception;
	
	/**
	 *  get the type of a token looking at the first char
	 */
	public Token.Type getTokenType(char firstChar) throws Exception;

	/**
	 *  read an identifer from in put
	 */
	public String getIdent() throws Exception;

    /**
     *  is the given character part of an identifier?       
     */
	public boolean isIdentifierPart(char c);

	/**
	 * get number value
	 */
	public int getNumber() throws Exception;

	/**
	 *  is the given character a digit?
	 */
	public boolean isDigit(char c);

	/**
	 *  is the given character a whitespace?
	 */
	public boolean isWhiteSpace(char c);
}

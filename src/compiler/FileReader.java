package compiler;

import java.io.*;

public class FileReader implements FileReaderIntf {
    private InputStream m_inputStream;
    private Reader m_inputStreamReader;
    private char m_nextChar;
    
	public FileReader(InputStream inputStream) throws Exception {
		m_inputStream       = inputStream;
		m_inputStreamReader = new InputStreamReader(m_inputStream);
		advance();
	}
	
	public char lookAheadChar() {
		return m_nextChar;
	}
	
	public void advance() throws Exception {
		int nextChar = m_inputStreamReader.read();
		m_nextChar = (nextChar == -1) ? 0 : (char)nextChar;
	}

}
